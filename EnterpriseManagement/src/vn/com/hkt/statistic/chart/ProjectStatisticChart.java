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
import vn.com.hkt.statistic.spi.ProjectRevenueStatistic;

/**
 *
 * @author QuynhNguyen
 */
public class ProjectStatisticChart {

    float revenue = 0, spending = 0, profit = 0;
    Calendar startDate = null, endDate = null;
    long idProject = 0, idEnterprise = 0, idDepartment = 0;

    public XYDataset createDataset() {
        Calendar dateStart, dateEnd;
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.setDomainIsPointsInTime(true);
        TimeSeries s1 = new TimeSeries("Obtain", Date.class);
        TimeSeries s2 = new TimeSeries("Spending", Date.class);
        TimeSeries s3 = new TimeSeries("Profit", Date.class);

        int check = 0;
        /*check =1 : thong ke theo ngay,
         * =2 : thong ke theo thang; 
         * =3 : thong ke theo nam
         * =4 : thong ke theo tuan
         * =5 : thong ke theo quy
         * 
         */
      //  int total = 0;
        /* total =1 : tinh doanh thu theo  cha,
         * =2 : tinh doanh thu theo  cha va cac con
         * =3 : tinh doanh thu theo cac con 
         */

        if (check == 1) {
            dateStart = Calendar.getInstance();
            dateEnd = Calendar.getInstance();
            dateEnd.add(Calendar.DATE, 1);
            TimeSeriesCollection datasetStatisticPerDay = new TimeSeriesCollection();
            while (dateStart.before(dateEnd)) {
                ProjectRevenueStatistic prs = new ProjectRevenueStatistic();
               // if (total == 1) {
                    revenue = prs.revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateStart.getTime());
                    spending = prs.spendingGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
              //  }
                /*
                if (total == 2) {
                    revenue = prs.revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateEnd.getTime());
                    spending = prs.spendingGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
                    revenue = prs.revenueGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateEnd.getTime());
                    spending = prs.spendingGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), dateStart.getTime());
                    profit = revenue - spending;
                }
                 * 
                 */
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
            int monthSt = dateStart.get(Calendar.MONTH);
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, monthSt , 1);
            Calendar nextMonth = Calendar.getInstance();
            nextMonth.set(yearSt, monthSt + 1, 1);
            dateEnd = Calendar.getInstance();
            int monthE = dateEnd.get(Calendar.MONTH);
            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE, monthE + 1, 1);

            while (dateStart.before(dateEnd)) {
                ProjectRevenueStatistic prs = new ProjectRevenueStatistic();
               // if (total == 1) {
                    revenue = prs.revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    spending = prs.revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
              //  }
                /*
                if (total == 2) {
                    revenue = prs.revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    spending = prs.revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
                    revenue = prs.revenueGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    spending = prs.revenueGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextMonth.getTime());
                    profit = revenue - spending;
                }
                 * 
                 */
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
            int yearSt = dateStart.get(Calendar.YEAR);
            dateStart.set(yearSt, 0, 1);
            Calendar nextYear = Calendar.getInstance();
            nextYear.set(yearSt + 1, 0, 1);
            dateEnd = Calendar.getInstance();
            int yearE = dateEnd.get(Calendar.YEAR);
            dateEnd.set(yearE + 1, 0, 1);
            while (dateStart.before(dateEnd)) {
                ProjectRevenueStatistic prs = new ProjectRevenueStatistic();
               // if (total == 1) {

                    revenue = prs.revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    spending = prs.revenueGetByProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
              //  }
                /*
                if (total == 2) {
                    revenue = prs.revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    spending = prs.revenueGetByTotalProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }
                if (total == 3) {
                    revenue = prs.revenueGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    spending = prs.revenueGetByTotalChildrenProject(idProject, idDepartment, idEnterprise, dateStart.getTime(), nextYear.getTime());
                    profit = revenue - spending;
                }

                 * 
                 */
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
//        if (check == 4) {
//            dateStart = Calendar.getInstance();
//            int dayofweek= dateStart.get(Calendar.DAY_OF_WEEK);
//            Calendar
//            dateEnd = Calendar.getInstance();
//            dateEnd.add(Calendar.DATE, 1);
//            TimeSeriesCollection datasetStatisticPerWeek = new TimeSeriesCollection();
//        }
        return dataset;
    }
}
