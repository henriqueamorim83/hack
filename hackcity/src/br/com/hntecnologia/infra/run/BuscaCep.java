package br.com.hntecnologia.infra.run;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BuscaCep
{

	// public static void main(String[] args){
	//
	// try {
	// JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
	//
	// Unmarshaller u = jc.createUnmarshaller();
	// URL url = new URL(
	// "http://cep.republicavirtual.com.br/web_cep.php?cep=11703240&formato=xml"
	// );
	// Webservicecep cep = (Webservicecep) u.unmarshal( url );
	//
	// System.out.println(cep);
	//
	//
	//
	// } catch (JAXBException e) {
	//
	// e.printStackTrace();
	// } catch (MalformedURLException e) {
	//
	// e.printStackTrace();
	// }
	//
	//
	// }

	public static void main ( String[] args ) throws MalformedURLException,
			JAXBException
	{

		// /Webservicecep web = getEndereco("88051370");
		String ab = "1";
		String ac = "2";
		String ad = "3";
		String ae = "4";
		String af = "5";

		Collection<String> abc = new ArrayList<String>();
		abc.add(ab);
		abc.add(ac);
		abc.add(ad);
		abc.add(ae);
		abc.add(af);

		try
		{
			FileOutputStream oStream = new FileOutputStream("d:\\arquivo.txt"); // ou
																				// usando
																				// um
																				// File
																				// com
																				// argumento
			OutputStreamWriter osw = new OutputStreamWriter(oStream);
			Writer writer = new BufferedWriter(osw);
			File file = new File("d:/testes.txt");
			FileWriter fw = new FileWriter(file , false);
			BufferedWriter bw = new BufferedWriter(fw);

			StringBuffer texto = new StringBuffer();
			for ( String palavra : abc)
			{
				texto.append(palavra + " \n\r");
				bw.write(palavra);
				bw.newLine();
			}
			System.out.println("CONTE�DO DESTINO: " + texto.toString()); // Apenas
																			// para
																			// testar
																			// se
																			// o
																			// problema
																			// n�o
																			// est�
																			// no
																			// StringBuffer
			// writer.write(texto.toString());

			bw.flush();
			bw.close();
			writer.flush();
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static Webservicecep getEndereco ( String cep )
			throws JAXBException, MalformedURLException
	{

		JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);

		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="
				+ cep + "&formato=xml");
		Webservicecep wCep = (Webservicecep) u.unmarshal(url);

		return wCep;

	}

}
