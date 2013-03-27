/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.statistic.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author QuynhNguyen
 */
public class Chart extends ApplicationFrame {
    int choose=1;

    public Chart(String title) {
        super(title);
        final XYDataset dataset = createDataset(choose);
        JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
//        chartPanel.setMouseZoomable(true, false);
//        setContentPane(chartPanel);
        ChartFrame chartFrame = new ChartFrame("Enterprise1", chart, true);
        chartFrame.setSize(350, 450);
        chartFrame.setVisible(true);
    }

    private XYDataset createDataset(int choose) {
        int check = 1, total = 1;
        //int choose = 0;
        /*
         * choose = 1 : thong ke cho enterprise
         * choose =2 : thong ke theo department
         * choose = 3 : thong ke theo employee
         * choose = 4 : thong ke theo project
         */
        TimeSeriesCollection dataset=new TimeSeriesCollection();
        if (choose==1) {
          EnterpriseStatisticChart  ent= new EnterpriseStatisticChart();
          dataset=(TimeSeriesCollection) ent.createDataset(check, total);
                   }
        if(choose==2)
        {
        DepartmentStatisticChart dep= new DepartmentStatisticChart();
        dataset = (TimeSeriesCollection) dep.createDataset();
                
        }
        if(choose ==3)
        {
            EmployeeStatisticChart emp= new EmployeeStatisticChart();
            dataset=(TimeSeriesCollection) emp.createDataset();
        }
        if (choose==4)
        {
            ProjectStatisticChart pr= new ProjectStatisticChart();
            dataset=(TimeSeriesCollection) pr.createDataset();
        }
        return dataset;
        
    }

    private JFreeChart createChart(XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createTimeSeriesChart("Enterprise Statistic", "Date ", "Value", dataset, true, true, false);
        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.red);
        plot.setRangeGridlinePaint(Color.green);

        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);

        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setPlotLines(true);
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        }
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd:MM:yyyy"));
        return chart;
    }
    public static void main(String[] args) {
         final Chart demo = new Chart("Multiple Dataset Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        
    }
}
