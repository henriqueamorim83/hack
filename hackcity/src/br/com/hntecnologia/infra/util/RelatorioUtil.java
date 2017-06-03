package br.com.hntecnologia.infra.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import br.com.hntecnologia.infra.relatorio.RelatorioInfra;
import br.com.hntecnologia.infra.util.constantes.Constantes;

public final class RelatorioUtil {
	@org.springframework.beans.factory.annotation.Autowired
	private static ServletContext servletContext;
	
	public static enum TipoGrafico {
    	Linha, Coluna, Pizza;
    	
    	public static Collection<String> listar(){
        	Collection<String> tiposGrafico = new ArrayList<String>();
        	tiposGrafico.add(Linha.toString());
        	tiposGrafico.add(Coluna.toString());
        	tiposGrafico.add(Pizza.toString());
        	return tiposGrafico;
        }
    };
	   
    public static enum FormatoImpressao {
    	PDF, XLS, CSV, RTF;
	};
	
	/**
	 * Método responsável por gerar um relatório jasper
	 * @param dados
	 * @param parametros
	 * @param arquivoJasper
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public static byte[] gerarRelatorio(Collection<?> dados, Map<String, Object> parametros, String arquivoJasper, FormatoImpressao tipo) throws Exception {	
		
		JasperReport jasperReport = null;
		InputStream inputStream = null;
		byte[] bytes = null;
		
		try {
			JRDataSource source = new JRBeanCollectionDataSource(dados);
			inputStream =   new FileInputStream(new File(arquivoJasper));  //RelatorioUtil.class.getClassLoader().getResourceAsStream(arquivoJasper);
			
			if(tipo != null){
				
				if(tipo.equals(FormatoImpressao.PDF)){
					//jasperReport = (JasperReport) JRLoader.loadObject(new File(servletContext.getRealPath("/resources/jasper/"+arquivoJasper)));
					jasperReport = (JasperReport) JRLoader.loadObject(inputStream);					
				    bytes = JasperRunManager.runReportToPdf(jasperReport, parametros, source);
				    inputStream.close();
				
				}else{ 
					
					JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, new JRBeanCollectionDataSource(dados));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					JRExporter exporter = null;
										
					if(tipo.equals(FormatoImpressao.RTF)){	
						
						exporter = new JRRtfExporter();
						exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
						exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
						
					}else if(tipo.equals(FormatoImpressao.CSV)){
						
						exporter = new JRCsvExporter();
						exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, "|");
						exporter.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, "\n");
						exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, print);
						exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
						
					}else if(tipo.equals(FormatoImpressao.XLS)){
											
						exporter = new JRXlsExporter();
						
						exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);  
						exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);  
						exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 65000);     
						exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
						exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
																	 						
					}
									
					exporter.exportReport();
					
					bytes = baos.toByteArray();
					
					baos.flush();
					baos.close();
					
				}
			}
			
		} catch (JRException e) {
		    
		    throw new Exception(e);

		} catch (IOException e) {
		    
		    throw new Exception(e);
		}
		
		return bytes;
	}
	
	/**
	 * Método responsável por unificar um ou mais relatórios jasper
	 * @param relatoriosPdf
	 * @return
	 * @throws Exception
	 */
	public static byte[] unificarRelatoriosPdf(List<byte[]> relatoriosPdf) throws Exception {
		
		byte[] pdfConcatenado = null;
		ByteArrayOutputStream outputStream = null;
		
		try {
			if (relatoriosPdf != null && !relatoriosPdf.isEmpty()) {
				byte[] relatorio = null;
				PdfCopy copiaPdf = null;
				Document documentoPdf = null;
				int pageOffset = 0;
				int qtdRelatorios = 0;
				
				Iterator<byte[]> iterator = relatoriosPdf.iterator();
				outputStream = new ByteArrayOutputStream();
				while (iterator.hasNext()) {
					relatorio = (byte[]) iterator.next();
					PdfReader reader = new PdfReader(relatorio);

					int qtdPaginas = reader.getNumberOfPages();
					pageOffset += qtdPaginas;
					
					if (qtdRelatorios == 0) {
						documentoPdf = new Document(reader.getPageSizeWithRotation(1));
						copiaPdf = new PdfCopy(documentoPdf, outputStream);
						documentoPdf.open();
					}
					
					PdfImportedPage page;
					
					for (int i = 0; i < qtdPaginas;) {
						++i;
						page = copiaPdf.getImportedPage(reader, i);
						copiaPdf.addPage(page);
					}
					
					PRAcroForm form = reader.getAcroForm();
					
					if (form != null) {
						copiaPdf.copyAcroForm(reader);
					}
					
					qtdRelatorios++;
				}
				documentoPdf.close();
			}
		} catch (IOException e) {
			
		    throw new Exception(e);
		
		} catch (DocumentException e) {
			
		    throw new Exception(e);
		
		}

		if(outputStream != null){
			pdfConcatenado = outputStream.toByteArray();
		}
		
		return pdfConcatenado;
	}

	
	public static byte[] gerarRelatorio(Collection<?> dados, Map<String, Object> parametros, JasperReport jasperReport, FormatoImpressao tipo) throws Exception {	
		
		
		InputStream inputStream = null;
		byte[] bytes = null;
		
		try {
			JRDataSource source = new JRBeanCollectionDataSource(dados);
			
			
			if(tipo != null){
				
				if(tipo.equals(FormatoImpressao.PDF)){
									
				    bytes = JasperRunManager.runReportToPdf(jasperReport, parametros, source);
				  
				
				}else{ 	
					inputStream = new FileInputStream(new File(""));
					JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, new JRBeanCollectionDataSource(dados));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					JRExporter exporter = null;
										
					if(tipo.equals(FormatoImpressao.RTF)){	
						
						exporter = new JRRtfExporter();
						exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
						exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
						
					}else if(tipo.equals(FormatoImpressao.CSV)){
						
						exporter = new JRCsvExporter();
						exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, "|");
						exporter.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, "\n");
						exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, print);
						exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
						
					}else if(tipo.equals(FormatoImpressao.XLS)){
											
						exporter = new JRXlsExporter();
						
						exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);  
						exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);  
						exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 65000);     
						exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
						exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
						exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
																	 						
					}
									
					exporter.exportReport();
					
					bytes = baos.toByteArray();
					
					baos.flush();
					baos.close();
					
				}
			}
			
		} catch (JRException e) {
		    
		    throw new Exception(e);

		} catch (IOException e) {
		    
		    throw new Exception(e);
		}
		
		return bytes;
	}
	
	
	}