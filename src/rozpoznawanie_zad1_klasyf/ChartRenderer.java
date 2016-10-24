/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozpoznawanie_zad1_klasyf;

/**
 *
 * @author Michał
 */
import java.util.Random;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

public class ChartRenderer {
  ChartFrame cf;
  DefaultXYDataset ds = new DefaultXYDataset();
    
  public ChartRenderer(String tytul) {
      NumberAxis xAxis = new NumberAxis("Cecha 2");
 //     xAxis.setAutoRangeIncludesZero(false);
      NumberAxis yAxis = new NumberAxis("Cecha 1");
      //XYItemRenderer rend;
     // rend = new XYLineAndShapeRenderer(false, true);
        //XYItemRenderer rend = new XYLineAndShapeRenderer(true, false);
      XYDotRenderer rend = new XYDotRenderer();
      rend.setDotHeight(5);
      rend.setDotWidth(5);
      XYPlot plot = new XYPlot(ds, xAxis, yAxis, rend);
//      dataset.addSeries("sin", sin);
        
      plot.setOrientation(PlotOrientation.VERTICAL);
      JFreeChart fc = new JFreeChart(plot);
        cf = new ChartFrame(tytul, fc);
        cf.setSize(1280, 720);
   }

   public void Render(float[][] features, String name) {
        ChartRenderer w = new ChartRenderer(name);
        //Random randomNumberGenerator = new Random();
        int d = features.length;
        
        double[][] dane = new double[2][d];
        
        int[] dTab = new int[10];
        int[] dIndexTab = new int[10];
        
        for(int i=0; i<10; i++){
            dTab[i] = 0;
        }
                
        int tmp = 0;
        for(int i = 0; i<d; i++){
            tmp = (int)features[i][2];
            dTab[tmp]++;
        }
        
        for(int i = 0; i<10; i++){
            //System.out.println(dTab[i]);
        }
        
        double[][] dane0 = new double[2][dTab[0]];
        double[][] dane1 = new double[2][dTab[1]];
        double[][] dane2 = new double[2][dTab[2]];
        double[][] dane3 = new double[2][dTab[3]];
        double[][] dane4 = new double[2][dTab[4]];
        double[][] dane5 = new double[2][dTab[5]];
        double[][] dane6 = new double[2][dTab[6]];
        double[][] dane7 = new double[2][dTab[7]];
        double[][] dane8 = new double[2][dTab[8]];
        double[][] dane9 = new double[2][dTab[9]];
        
        for(int i = 0; i<d; i++){
            //System.out.println("|" + (int)features[i][2]);
            switch((int)features[i][2]){
                case 0:
                    dane0[0][dIndexTab[0]] = features[i][0];
                    dane0[1][dIndexTab[0]] = features[i][1];
                    dIndexTab[0]++;
                    break;
                case 1:
                    dane1[0][dIndexTab[1]] = features[i][0];
                    dane1[1][dIndexTab[1]] = features[i][1];
                    dIndexTab[1]++;
                    break;
                case 2:
                    dane2[0][dIndexTab[2]] = features[i][0];
                    dane2[1][dIndexTab[2]] = features[i][1];
                    dIndexTab[2]++;
                    break;
                case 3:
                    dane3[0][dIndexTab[3]] = features[i][0];
                    dane3[1][dIndexTab[3]] = features[i][1];
                    dIndexTab[3]++;
                    break;
                case 4:
                    dane4[0][dIndexTab[4]] = features[i][0];
                    dane4[1][dIndexTab[4]] = features[i][1];
                    dIndexTab[4]++;
                    break;
                case 5:
                    dane5[0][dIndexTab[5]] = features[i][0];
                    dane5[1][dIndexTab[5]] = features[i][1];
                    dIndexTab[5]++;
                    break;
                case 6:
                    dane6[0][dIndexTab[6]] = features[i][0];
                    dane6[1][dIndexTab[6]] = features[i][1];
                    dIndexTab[6]++;
                    break;
                case 7:
                    dane7[0][dIndexTab[7]] = features[i][0];
                    dane7[1][dIndexTab[7]] = features[i][1];
                    dIndexTab[7]++;
                    break;
                case 8:
                    dane8[0][dIndexTab[8]] = features[i][0];
                    dane8[1][dIndexTab[8]] = features[i][1];
                    dIndexTab[8]++;
                    break;
                case 9:
                    dane9[0][dIndexTab[9]] = features[i][0];
                    dane9[1][dIndexTab[9]] = features[i][1];
                    dIndexTab[9]++;
                    break;
                default:
                    break;
            }
        }
        //w.Render("wartości własne", dane);
        ds.addSeries("0", dane0);
        ds.addSeries("1", dane1);
        ds.addSeries("2", dane2);
        ds.addSeries("3", dane3);
        ds.addSeries("4", dane4);
        ds.addSeries("5", dane5);
        ds.addSeries("6", dane6);
        ds.addSeries("7", dane7);
        ds.addSeries("8", dane8);
        ds.addSeries("9", dane9);
        cf.pack();
        cf.setVisible(true);
   }
    
   public void Render2(float[][] features, String name) {
        ChartRenderer w = new ChartRenderer(name);
        //Random randomNumberGenerator = new Random();
        int d = features.length;
        
        double[][] dane = new double[2][d];
        
       
        
        for(int i = 0; i<d; i++){
            dane[0][i] = features[i][0];
            dane[1][i] = features[i][1];
        }
            //System.out.println("|" + (int)features[i][2]);
            
        ds.addSeries("Unknown features", dane);
        cf.pack();
        cf.setVisible(true);
   }
}
