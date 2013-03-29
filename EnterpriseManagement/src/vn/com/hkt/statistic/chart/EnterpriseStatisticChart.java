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

    public XYDataset createDataset(int check, int total, long id, Date start, Date end) {
        Calendar dateStart, dateEnd;
        float revenue = 0, spending = 0, profit = 0;
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.setDomainIsPointsInTime(true);
        TimeSeries s1 = new TimeSeries("Obtain", Date.class);
        TimeSeries s2 = new TimeSeries("Spending", Date.class);
        TimeSeries s3 = new TimeSeries("Profit", Date.class);

        //int check = 0;
        /*check =1 : thong ke theo ngay,
         * =2 : thong ke theo thang; 
         * =3 : thong ke theo nam
         * 
         */
        //int total = 0;
        /* total =1 : tinh doanh thu theo enterprise cha,
         * =2 : tinh doanh thu theo enterprise cha va cac con
         * =3 : tinh doanh thu theo cac con cua enterprise
         */

        if (check == 1) {
            dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            dateEnd.add(Calendar.DATE, 1);
            TimeSeriesCollection datasetStatisticPerDay = new TimeSeriesCollection();
            while (dateStart.before(dateEnd)) {
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == 1) {
                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    spending = ers.spendingGetByEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == 2) {
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), dateEnd.getTime());
                    spending = ers.spendingGetByTotalEnterprise(id, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
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
        }
        if (check == 2) {
            TimeSeriesCollection datasetStatisticPerMonth = new TimeSeriesCollection();
            dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int monthSt = dateStart.get(Calendar.MONTH);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, monthSt, 1);
            Calendar nextMonth = Calendar.getInstance();
            nextMonth.set(yearSt, monthSt + 1, 1);

            int monthE = dateEnd.get(Calendar.MONTH);
            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE, monthE + 1, 1);

            while (dateStart.before(dateEnd)) {
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == 1) {
                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    spending = ers.revenueGetByEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == 2) {
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    spending = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
                    revenue = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    spending = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
                }
                s1.add(new Month(dateStart.getTime()), revenue);
                s2.add(new Month(dateStart.getTime()), spending);
                s3.add(new Month(dateStart.getTime()), profit);
                dateStart.add(Calendar.MONTH, 1);
                nextMonth.add(Calendar.MONTH, 1);
            }
            datasetStatisticPerMonth.addSeries(s1);
            datasetStatisticPerMonth.addSeries(s2);
            datasetStatisticPerMonth.addSeries(s3);
            dataset = datasetStatisticPerMonth;
        }
        if (check == 3) {
            TimeSeriesCollection datasetStatisticPerYear = new TimeSeriesCollection();
            dateStart = Calendar.getInstance();
            dateStart.setTime(start);
            dateEnd = Calendar.getInstance();
            dateEnd.setTime(end);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, 0, 1);
            Calendar nextYear = Calendar.getInstance();
            nextYear.set(yearSt + 1, 0, 1);

            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE + 1, 0, 1);
            while (dateStart.before(dateEnd)) {
                EnterpriseRevenueStatistic ers = new EnterpriseRevenueStatistic();
                if (total == 1) {

                    revenue = ers.revenueGetByEnterprise(id, dateStart.getTime(), nextYear.getTime());
                    spending = ers.revenueGetByEnterprise(id, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }
                if (total == 2) {
                    revenue = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), nextYear.getTime());
                    spending = ers.revenueGetByTotalEnterprise(id, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
                    revenue = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), nextYear.getTime());
                    spending = ers.revenueGetByTotalChildrenEnterprise(id, dateStart.getTime(), nextYear.getTime());
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
