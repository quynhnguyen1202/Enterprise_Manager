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
import vn.com.hkt.statistic.spi.EnterpriseRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class EnterpriseStatisticChart {

    private static final int DAY_TYPE = 1;
    private static final int MONTH_TYPE = 2;
    private static final int YEAR_TYPE = 3;
    private static final int PARENT_TYPE = 1;
    private static final int TOTAL_TYPE = 2;
    private static final int CHILDREN_TYPE = 3;

    public XYDataset createDataset(int check, int total, long id, Date start, Date end) {
        Calendar dateStart, dateEnd;
        float revenue = 0, spending = 0, profit = 0;
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.setDomainIsPointsInTime(true);//
        dateStart = Calendar.getInstance();
        dateStart.setTime(start);
        dateEnd = Calendar.getInstance();
        dateEnd.setTime(end);
        if (check == 1) {
            TimeSeries s1 = new TimeSeries("Revenues", Day.class);
            TimeSeries s2 = new TimeSeries("Spending", Day.class);
            TimeSeries s3 = new TimeSeries("Profit", Day.class);
            dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            TimeSeriesCollection datasetStatisticPerDay = new TimeSeriesCollection();
            while (dateStart.compareTo(dateEnd) <= 0) {
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == PARENT_TYPE) {// cha
                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    spending = ers.spendingGetByEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {// cha,con
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), dateEnd.getTime());
                    spending = ers.spendingGetByTotalEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {// cac con
                    revenue = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), dateEnd.getTime());
                    spending = ers.spendingGetByTotalChildrenEnterprise(id, dateStart.getTime(), dateStart.getTime());
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
        } else if (check == MONTH_TYPE) {
            TimeSeries s1 = new TimeSeries("Revenues", Month.class);
            TimeSeries s2 = new TimeSeries("Spending", Month.class);
            TimeSeries s3 = new TimeSeries("Profit", Month.class);
            TimeSeriesCollection datasetStatisticPerMonth = new TimeSeriesCollection();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int monthSt = dateStart.get(Calendar.MONTH);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, monthSt, 1);

            int monthE = dateEnd.get(Calendar.MONTH);
            int yearE = dateEnd.get(Calendar.YEAR);
            int dayE = dateEnd.getActualMaximum(Calendar.DATE);
            dateEnd.set(yearE, monthE, dayE);

            while (dateStart.compareTo(dateEnd) <= 0) {
                // set time for end of month
                int lastDayOfMonth = dateStart.getActualMaximum(Calendar.DATE);
                monthSt = dateStart.get(Calendar.MONTH);
                yearSt = dateStart.get(Calendar.YEAR);
                Calendar EndOfMonth = Calendar.getInstance();
                EndOfMonth.set(yearSt, monthSt, lastDayOfMonth);
                // 
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == PARENT_TYPE) {
                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
                    spending = ers.revenueGetByEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
                    spending = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {
                    revenue = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
                    spending = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), EndOfMonth.getTime());
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
            TimeSeries s1 = new TimeSeries("Revenues", Year.class);
            TimeSeries s2 = new TimeSeries("Spending", Year.class);
            TimeSeries s3 = new TimeSeries("Profit", Year.class);
            TimeSeriesCollection datasetStatisticPerYear = new TimeSeriesCollection();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, 0, 1);
            Calendar endOfYear = Calendar.getInstance();
            endOfYear.set(yearSt, 11, 31);

            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE, 11, 31);
            while (dateStart.compareTo(dateEnd) <= 0) {
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == PARENT_TYPE) {

                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    spending = ers.revenueGetByEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    profit = revenue - spending;
                }
                if (total == TOTAL_TYPE) {
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    spending = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    profit = revenue - spending;
                }
                if (total == CHILDREN_TYPE) {
                    revenue = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    spending = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), endOfYear.getTime());
                    profit = revenue - spending;
                }

                s1.add(new Year(dateStart.getTime()), revenue);
                s2.add(new Year(dateStart.getTime()), spending);
                s3.add(new Year(dateStart.getTime()), profit);
                dateStart.add(Calendar.YEAR, 1);
                endOfYear.add(Calendar.YEAR, 1);

            }
            datasetStatisticPerYear.addSeries(s1);
            datasetStatisticPerYear.addSeries(s2);
            datasetStatisticPerYear.addSeries(s3);
            dataset = datasetStatisticPerYear;
        }

        return dataset;
    }
}
}