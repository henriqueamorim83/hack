package br.com.hntecnologia.infra.run.graficos;

import java.io.File;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;
 
public class GraficoBarras3D {
  public static void main(String[] args) {
    DefaultCategoryDataset ds = new DefaultCategoryDataset();
    ds.setValue(5, "Brasil", "2000"); ds.setValue(2, "Brasil", "2001");
    ds.setValue(-2, "Brasil", "2002"); ds.setValue(1, "Brasil", "2003");
    ds.setValue(4, "Brasil", "2004"); ds.setValue(3, "Argentina", "2000");
    ds.setValue(2, "Argentina", "2001"); ds.setValue(-6, "Argentina", "2002");
    ds.setValue(-2, "Argentina", "2003"); ds.setValue(3, "Argentina", "2004");
    ds.setValue(10, "EUA", "2000"); ds.setValue(4, "EUA", "2001");
    ds.setValue(0, "EUA", "2002"); ds.setValue(-1, "EUA", "2003");
    ds.setValue(5, "EUA", "2004");
 
    JFreeChart grafico = ChartFactory.createBarChart3D(
        "Balança Comercial","Ano","US$ (bi)",
         ds,PlotOrientation.VERTICAL,true,false,false
    );
   
    CategoryPlot plot = (CategoryPlot) grafico.getPlot();
    plot.setForegroundAlpha(0.9f);
    plot.setDomainGridlinesVisible(true);
 
    BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
    renderer.setDrawBarOutline(false);
 
    try {
      ChartUtilities.saveChartAsPNG(new File(
        "/home/henrique/barras3d.png"), grafico, 400, 250);
    }
    catch(Exception e) { /* Tratar */ }
  }
}