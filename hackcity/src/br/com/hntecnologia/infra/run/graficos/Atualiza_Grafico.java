package br.com.hntecnologia.infra.run.graficos;

/** 
* 
* @author xxxxx 
*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class Atualiza_Grafico extends javax.swing.JFrame {

	static double[] dado = new double[2592000];
	static int[] tempo = new int[2592000];
	static int[] Cor = new int[2592000];

	static int contador = 0;
	static JFreeChart chart;

static XYSeries series = new XYSeries("XYGraph");
static XYSeries series1 = new XYSeries("XYGraph1");
static XYSeries series2 = new XYSeries("XYGraph2");
static XYSeries series3 = new XYSeries("XYGraph3");
static XYSeries series4 = new XYSeries("XYGraph4");
static XYSeries series5 = new XYSeries("XYGraph5");
static XYSeries series6 = new XYSeries("XYGraph6");
static XYSeries series7 = new XYSeries("XYGraph7");

	static XYSeriesCollection ds = new XYSeriesCollection();

	public Atualiza_Grafico(String title, String TextoY, String TextoX, String Titulo)
			throws InterruptedException, IOException {

		super(title);

		ds.addSeries(series);
		ds.addSeries(series1);
		ds.addSeries(series2);
		ds.addSeries(series3);
		ds.addSeries(series4);
		ds.addSeries(series5);
		ds.addSeries(series6);
		ds.addSeries(series7);

		createChart(ds, TextoY, TextoX, Titulo);

		JPanel chartPanel = new ChartPanel(chart);

		chartPanel.setPreferredSize(new java.awt.Dimension(450, 270));

		setContentPane(chartPanel);
		this.pack();
		RefineryUtilities.positionFrameOnScreen(this, 0.5, 0.5);

		this.setVisible(true);

	}

	private static void createChart(XYSeriesCollection dataset1, String TextoY, String TextoX, String Titulo) {
		// create the chart...
		chart = ChartFactory.createXYLineChart(Titulo, // chart title
				TextoX, // x axis label
				TextoY, // y axis label
				dataset1, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
		);

		XYPlot plot = chart.getXYPlot();

		XYItemRenderer renderer = plot.getRenderer();

		// Definindo Linhas:
		renderer.setSeriesStroke(0, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(0, Color.BLUE);

		renderer.setSeriesStroke(1, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(1, Color.RED);

		renderer.setSeriesStroke(2, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(2, Color.YELLOW);

		renderer.setSeriesStroke(3, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(3, Color.GREEN);

		renderer.setSeriesStroke(4, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(4, Color.BLACK);

		renderer.setSeriesStroke(5, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(5, Color.ORANGE);

		renderer.setSeriesStroke(6, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(6, Color.PINK);

		renderer.setSeriesStroke(7, new BasicStroke(1.7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f,
				new float[] { 1.0f, 1.0f }, 0.0f));
		renderer.setSeriesPaint(7, Color.MAGENTA);

	}

	private static void atualiza_dados(Double novo_dado, int nova_cor, String TextoY, String TextoX, String Titulo)
			throws InterruptedException, IOException {

		// Altera os valores dos dados do gráfico para atualizar

		// tempo discreto:
		tempo[contador] = contador;

		dado[contador] = novo_dado;

		Cor[contador] = nova_cor;

		if (Cor[contador] == 0) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 0) {
					series.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 1) {

			series.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series1.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 1) {
					series1.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 2) {

			series1.add(tempo[contador], null);
			series.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series2.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 2) {
					series2.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 3) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series3.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 3) {
					series3.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 4) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series4.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 4) {
					series4.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 5) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series5.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 5) {
					series5.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 6) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series.add(tempo[contador], null);
			series7.add(tempo[contador], null);

			series6.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 6) {
					series6.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		if (Cor[contador] == 7) {

			series1.add(tempo[contador], null);
			series2.add(tempo[contador], null);
			series3.add(tempo[contador], null);
			series4.add(tempo[contador], null);
			series5.add(tempo[contador], null);
			series6.add(tempo[contador], null);
			series.add(tempo[contador], null);

			series7.add(tempo[contador], dado[contador]);

			if (contador != 0) {
				if (Cor[contador - 1] != 7) {
					series7.add(tempo[contador - 1], dado[contador - 1]);
				}
			}

		}

		createChart(ds, TextoY, TextoX, Titulo);

		// Quantidade de dados:
		contador++;

	}

	public JPanel atualizacao(Double novo_dado, int nova_cor, String TextoY, String TextoX, String Titulo)
			throws InterruptedException, IOException {

		atualiza_dados(novo_dado, nova_cor, TextoY, TextoX, Titulo);
		JPanel chartPanel = new ChartPanel(chart);
		setContentPane(chartPanel);
		chartPanel.setVisible(true);

		return chartPanel;

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO code application logic here
		//janela_interface jn = new janela_interface();
		//jn.setVisible(true);

	}

}