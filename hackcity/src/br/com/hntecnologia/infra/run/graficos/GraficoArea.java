package br.com.hntecnologia.infra.run.graficos;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;
 
public class GraficoArea {
  public static void main(String[] args) {
    DefaultCategoryDataset ds = new DefaultCategoryDataset();
    ds.setValue(2.3, "Compra", "Jan/2002");
    ds.setValue(2.53, "Compra", "Jul/2002");
    ds.setValue(3.47, "Compra", "Jan/2003");
    ds.setValue(2.78, "Compra", "Jul/2003");
    ds.setValue(2.8, "Compra", "Jan/2004");
    ds.setValue(3.05, "Compra", "Jul/2004");
 
    JFreeChart grafico = ChartFactory.createAreaChart("Dólar","Período","Preço",
      ds,PlotOrientation.VERTICAL,true,false,false);
   
    Plot plot = grafico.getPlot();
 
    //transparência
    plot.setForegroundAlpha(0.7f);
    //imagem de fundo
    URL url = GraficoArea.class.getClassLoader().getResource("background.jpg");
    Image img = new ImageIcon(url).getImage();
    plot.setBackgroundImage(img);
   
    try {
      ChartUtilities.saveChartAsPNG(new File("/home/henrique/area.png"), grafico, 400, 250);
    } catch(Exception e) {/* Tratar */ }
  }
}
