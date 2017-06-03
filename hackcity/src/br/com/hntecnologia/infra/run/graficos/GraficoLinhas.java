package br.com.hntecnologia.infra.run.graficos;

import java.io.File;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
 
public class GraficoLinhas {
  public static void main(String[] args) {
    String cat1 = "1000cc";
    String cat2 = "Outros";
    DefaultCategoryDataset ds = new DefaultCategoryDataset();
    ds.setValue(754419, cat1, "2000");
    ds.setValue(878260, cat1, "2001");
    ds.setValue(801869, cat1, "2002");
    ds.setValue(699926, cat1, "2003");
    ds.setValue(741561, cat1, "2004");
 
    ds.setValue(321413, cat2, "2000");
    ds.setValue(298297, cat2, "2001");
    ds.setValue(361848, cat2, "2002");
    ds.setValue(382456, cat2, "2003");
    ds.setValue(554309, cat2, "2004");
 
    JFreeChart grafico =
      ChartFactory.createLineChart("Vendas de Carros","Ano","Unidades",
      ds,PlotOrientation.VERTICAL,true,false,false);
    try {
      ChartUtilities.saveChartAsPNG(new File("/home/henrique/linhas.png"), grafico, 400, 250);
    } catch(Exception e) { /* Tratar */ }
  }
}