/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.chart;

import java.util.Calendar;
import java.util.Date;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import vn.com.hkt.statistic.spi.DepartmentRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class DepartmentStatisticChart {

    public static final int DAY_TYPE = 1;
    public static final int MONTH_TYPE = 2;
    public static final int YEAR_TYPE = 3;
    public static final int PARENT_TYPE = 1;
    public static final int TOTAL_TYPE = 2;
    public static final int CHILDREN_TYPE = 3;

    public XYDataset createDataset(int check, int total, long idDepartment, Date start, Date end) {
        float revenue = 0, spending = 0, profit = 0;
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.setDomainIsPointsInTime(true);

        if (check == DAY_TYPE) {
            TimeSeries s1 = new TimeSeries("Revenue", Day.class);
            TimeSeries s2 = new TimeSeries("Spending", Day.class);
            TimeSeries s3 = new TimeSeries("Profit", Day.class);

            Calendar dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            Calendar dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            TimeSeriesCollection datasetStatisticPerDay = new TimeSeriesCollection();
            while (dateStart.compareTo(dateEnd) <= 0) {
                DepartmentRevenueStatistic drs = new DepartmentRevenueStatistic();
                if (total == PARENT_TYPE) {
                    revenue = drs.revenueGetByDepartment(idDepartment, dateStart.getTime(), dateStart.getTime());
                    spending = drs.spendingGetByDepartment(idDepartment, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {
                    revenue = drs.revenueGetByTotalDepartment(idDepartment, dateStart.getTime(), dateEnd.getTime());
                    spending = drs.spendingGetByTotalDepartment(idDepartment, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {
                    revenue = drs.revenueGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), dateEnd.getTime());
                    spending = drs.spendingGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                s1.add(new Day(dateStart.getTime()), revenue);
                s2.add(new Day(dateStart.getTime()), spending);
                s3.add(new Day(dateStart.getTime()), profit);
                dateStart.add(Calendar.DATE, 1);
            }
            datasetStatisticPerDay.addSeries(s1);
            datasetStatisticPerDay.addSeries(s2);
            datasetStatisticPerDay.addSeries(s3);
            dataset = datasetStatisticPerDay;
        }
        if (check == MONTH_TYPE) {
            TimeSeries s1 = new TimeSeries("Revenue", Month.class);
            TimeSeries s2 = new TimeSeries("Spending", Month.class);
            TimeSeries s3 = new TimeSeries("Profit", Month.class);

            TimeSeriesCollection datasetStatisticPerMonth = new TimeSeriesCollection();
            Calendar dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            Calendar dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int monthSt = dateStart.get(Calendar.MONTH);
            int yearSt = dateStart.get(Calendar.YEAR);
            int lastDayOfMonth = dateStart.getActualMaximum(Calendar.DATE);
            dateStart.set(yearSt, monthSt, 1);
            Calendar EndOfMonth = Calendar.getInstance();
            EndOfMonth.set(yearSt, monthSt, lastDayOfMonth);

            int monthE = dateEnd.get(Calendar.MONTH);
            int yearE = dateEnd.get(Calendar.YEAR);
            int dayE = dateEnd.getActualMaximum(Calendar.DATE);
            dateEnd.set(yearE, monthE, dayE);

            while (dateStart.compareTo(dateEnd) <= 0) {
                DepartmentRevenueStatistic drs = new DepartmentRevenueStatistic();
                if (total == PARENT_TYPE) {
                    revenue = drs.revenueGetByDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    spending = drs.revenueGetByDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {
                    revenue = drs.revenueGetByTotalDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    spending = drs.revenueGetByTotalDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {
                    revenue = drs.revenueGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    spending = drs.revenueGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), EndOfMonth.getTime());
                    profit = revenue - spending;
                }
                s1.add(new Month(dateStart.getTime()), revenue);
                s2.add(new Month(dateStart.getTime()), spending);
                s3.add(new Month(dateStart.getTime()), profit);
                dateStart.add(Calendar.MONTH, 1);
            }
            datasetStatisticPerMonth.addSeries(s1);
            datasetStatisticPerMonth.addSeries(s2);
            datasetStatisticPerMonth.addSeries(s3);
            dataset = datasetStatisticPerMonth;
        }
        if (check == YEAR_TYPE) {
            TimeSeries s1 = new TimeSeries("Revenue", Year.class);
            TimeSeries s2 = new TimeSeries("Spending", Year.class);
            TimeSeries s3 = new TimeSeries("Profit", Year.class);

            TimeSeriesCollection datasetStatisticPerYear = new TimeSeriesCollection();
            Calendar dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            Calendar dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, 0, 1);
            Calendar nextYear = Calendar.getInstance();
            nextYear.set(yearSt + 1, 0, 1);

            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE, 0, 1);
            while (dateStart.compareTo(dateEnd) <= 0) {
                DepartmentRevenueStatistic drs = new DepartmentRevenueStatistic();
                if (total == PARENT_TYPE) {

                    revenue = drs.revenueGetByDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    spending = drs.revenueGetByDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {
                    revenue = drs.revenueGetByTotalDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    spending = drs.revenueGetByTotalDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {
                    revenue = drs.revenueGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    spending = drs.revenueGetByTotalChildrenDepartment(idDepartment, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }

                s1.add(new Year(dateStart.getTime()), revenue);
                s2.add(new Year(dateStart.getTime()), spending);
                s3.add(new Year(dateStart.getTime()), profit);
                dateStart.add(Calendar.YEAR, 1);
                nextYear.add(Calendar.YEAR, 1);

            }
            datasetStatisticPerYear.addSeries(s1);
            datasetStatisticPerYear.addSeries(s2);
            datasetStatisticPerYear.addSeries(s3);
            dataset = datasetStatisticPerYear;
        }

        return dataset;
    }
}
