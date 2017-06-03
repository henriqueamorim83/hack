package br.com.hntecnologia.infra.run.graficos;

import java.io.File;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
 
public class GraficoPizza {
  public static void main(String[] args) {
    DefaultPieDataset ds = new DefaultPieDataset();
    ds.setValue("Norte", 13000000);
    ds.setValue("Nordeste", 48000000);
    ds.setValue("Centro-Oeste", 11000000);
    ds.setValue("Sudeste", 73000000);
    ds.setValue("Sul", 25500000);
    JFreeChart grafico =
      ChartFactory.createPieChart("População Nacional", ds, true, false, false);
    try {
      ChartUtilities.saveChartAsPNG(new File("/home/henrique/pizza.png"), grafico, 400, 250);
    }
    catch(Exception e) { /* Tratar */ }
  }
}