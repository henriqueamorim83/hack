package br.com.hntecnologia.infra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DateUtil {

	public static String getDateFormat(Date date) {
		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			result = sdf.format(date);
		}
		return result;
	}

	public static String integerToMonth(int month) {
		String result;
		switch (month) {
		case 1:
			result = "Janeiro";
			break;
		case 2:
			result = "Fevereiro";
			break;
		case 3:
			result = "Mar�o";
			break;
		case 4:
			result = "Abril";
			break;
		case 5:
			result = "Maio";
			break;
		case 6:
			result = "Junho";
			break;
		case 7:
			result = "Julho";
			break;
		case 8:
			result = "Agosto";
			break;
		case 9:
			result = "Setembro";
			break;
		case 10:
			result = "Outubro";
			break;
		case 11:
			result = "Novembro";
			break;
		case 12:
			result = "Dezembro";
			break;

		default:
			result = null;
		}
		return result;

	}

	public static String getMes(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("M");
		result = sdf.format(date);
		Integer mes = Integer.valueOf(result);
		switch (mes) {
		case 1:
			result = "Janeiro";
			break;
		case 2:
			result = "Fevereiro";
			break;
		case 3:
			result = "Março";
			break;
		case 4:
			result = "Abril";
			break;
		case 5:
			result = "Maio";
			break;
		case 6:
			result = "Junho";
			break;
		case 7:
			result = "Julho";
			break;
		case 8:
			result = "Agosto";
			break;
		case 9:
			result = "Setembro";
			break;
		case 10:
			result = "Outubro";
			break;
		case 11:
			result = "Novembro";
			break;
		case 12:
			result = "Dezembro";
			break;

		default:
			result = null;
		}
		return result;

	}

	public static String getMesNumeral(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		result = sdf.format(date);
		return result;
	}

	public static String getDia(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		result = sdf.format(date);

		return result;

	}

	public static int getDiaNumeral(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		result = sdf.format(date);

		return Integer.parseInt(result);

	}

	public static String getAno(Date date) {
		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			result = sdf.format(date);
		}
		return result;
	}

	public static int getAnoNumeral(Date date) {
		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			result = sdf.format(date);
		}
		return Integer.parseInt(result);
	}

	public static String getDateTimeFormat(Date date) {

		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			result = sdf.format(date);
		}
		return result;
	}

	public static String getDateCompleteTimeFormat(Date date) {

		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			result = sdf.format(date);
		}
		return result;
	}

	public static String getDateJS(Date date) {

		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy,M'-1',d,H,m,s'+2'");
			result = sdf.format(date);
		}
		return result;
	}

	public static String getHourCompleteTimeFormat(Date date) {

		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			result = sdf.format(date);
		}
		return result;
	}

	public static String getDateTime(Date date) {

		String result = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			result = sdf.format(date);
		}
		return result;
	}

	public static boolean isSabadoOuDomingo(Date data) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		int diaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
		return diaSemana == GregorianCalendar.SATURDAY
				|| diaSemana == GregorianCalendar.SUNDAY;
	}

	@SuppressWarnings("deprecation")
	public static boolean isForaHoraNormal(Date data) {

		Date horarioNormal = new Date();
		horarioNormal.setHours(19);
		horarioNormal.setMinutes(00);
		horarioNormal.setSeconds(00);

		if (data.getTime() > horarioNormal.getTime()) {
			return true;
		} else {
			return false;
		}
	}

	public static String formataHoras(long tempo) {

		if (tempo == 0) {
			return "0h 00min";
		}

		int[] ret = new int[3];

		String hora = "";
		if (tempo < 1000) {
			ret[2] = (int) tempo;
		} else {
			ret[2] = 0;
		}

		int secs = (int) tempo / 1000;

		if (tempo == 0) {
			hora = "0";
		} else {
			// calcula nmero de horas, minutos e segundos
			// System.out.println("secs: "+secs);

			ret[0] = secs / 3600;
			// System.out.println("ret[0]: "+ret[0]);
			secs = secs % 3600;
			ret[1] = secs / 60;
			// System.out.println("ret[1]: "+ret[1]);
			secs = secs % 60;
			// se tempo for maior que 1000
			if (ret[2] == 0) {
				// System.out.println("secs: "+ret[2]);
				ret[2] = secs;
			}
			// System.out.println("ret[2]: "+ret[2]);
			hora += ret[0] + "h " + (ret[1] > 9 ? "" : "0") + ret[1] + "min";
		} // fim do if (tempo == 0)

		return hora;
	}

	/*
	public static String getPeriodoEntreDatasMesmoDia(Date d1, Date d2) {

		LocalTime start = new LocalTime(d1);
		LocalTime end = new LocalTime(d2);
		Period period = new Period(start, end);

		return String.valueOf(period.getHours()) + "hs "
				+ String.valueOf(period.getMinutes()) + "min";
	}
	*/

	public static String getDiaSemana(int dia) {
		String result = null;
		switch (dia) {
		case 1:
			result = "Domingo";
			break;
		case 2:
			result = "Segunda-feira";
			break;
		case 3:
			result = "Terça-feira";
			break;
		case 4:
			result = "Quarta-feira";
			break;
		case 5:
			result = "Quinta-feira";
			break;
		case 6:
			result = "Sexta-feira";
			break;
		case 7:
			result = "S�bado";
			break;
		default:
			result = null;
		}
		return result;
	}

	public static String getDiaSemana(Date date) {
		String result = null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int dia = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dia) {
		case 1:
			result = "Domingo";
			break;
		case 2:
			result = "Segunda-feira";
			break;
		case 3:
			result = "Ter�a-feira";
			break;
		case 4:
			result = "Quarta-feira";
			break;
		case 5:
			result = "Quinta-feira";
			break;
		case 6:
			result = "Sexta-feira";
			break;
		case 7:
			result = "S�bado";
			break;
		default:
			result = null;
		}
		return result;
	}

	public static String getMes(int mes) {
		String result = null;
		switch (mes) {
		case 1:
			result = "Janeiro";
			break;
		case 2:
			result = "Fevereiro";
			break;
		case 3:
			result = "Mar�o";
			break;
		case 4:
			result = "Abril";
			break;
		case 5:
			result = "Maio";
			break;
		case 6:
			result = "Junho";
			break;
		case 7:
			result = "Julho";
			break;
		case 8:
			result = "Agosto";
			break;
		case 9:
			result = "Setembro";
			break;
		case 10:
			result = "Outubro";
			break;
		case 11:
			result = "Novembro";
			break;
		case 12:
			result = "Dezembro";
			break;
		default:
			result = null;
		}
		return result;
	}

	public static String getMesSigla(int mes) {
		String result = null;
		switch (mes) {
		case 1:
			result = "Jan";
			break;
		case 2:
			result = "Fev";
			break;
		case 3:
			result = "Mar";
			break;
		case 4:
			result = "Abr";
			break;
		case 5:
			result = "Mai";
			break;
		case 6:
			result = "Jun";
			break;
		case 7:
			result = "Jul";
			break;
		case 8:
			result = "Ago";
			break;
		case 9:
			result = "Set";
			break;
		case 10:
			result = "Out";
			break;
		case 11:
			result = "Nov";
			break;
		case 12:
			result = "Dez";
			break;
		default:
			result = null;
		}
		return result;
	}

	public static long getDiferencaHoras(Date d1, Date d2) {

		long diferenca = 0;

		if (d1 != null && d2 != null) {
			diferenca = d2.getTime() - d1.getTime();
		}

		return diferenca;
	}

	public static String getDiferencaHorasMinutos(Date d1, Date d2) {

		long milisecs = (d2.getTime() - d1.getTime());
		long segundos = milisecs / 1000;
		long minutos = segundos / 60;
		long horas = minutos / 60;

		return horas + "hs " + minutos + "min";

	}

	public static long getDiferencaMinutos(Date d1, Date d2) {

		long milisecs = (d2.getTime() - d1.getTime());
		long segundos = milisecs / 1000;
		long minutos = segundos / 60;

		return minutos;

	}

	public static long getSomaHoras(Date d1, Date d2) {

		long diferenca = 0;

		if (d1 != null && d2 != null) {
			diferenca = d2.getTime() + d1.getTime();
		}

		return diferenca;
	}

	public static Date converteData(String mydata) {
		Date data = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = format.parse(mydata);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}

	public static Date converteDataCompleta(String mydata) {
		Date data = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			data = format.parse(mydata);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}

	public static String converteDataToString(java.util.Date dtData) {
		SimpleDateFormat formatBra;
		formatBra = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			java.util.Date newData = formatBra.parse(dtData.toString());
			return (formatBra.format(newData));
		} catch (ParseException Ex) {
			return "Erro na convers�o da data";
		}
	}
	
	public static String converteDataSemHoraToString(java.util.Date dtData) {
		SimpleDateFormat formatBra;
		formatBra = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date newData = formatBra.parse(dtData.toString());
			return (formatBra.format(newData));
		} catch (ParseException Ex) {
			return "Erro na convers�o da data";
		}
	}

	public static Date converteHoraToDate(String mydata) {
		Date data = null;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			data = format.parse(mydata);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}

	/*
	@SuppressWarnings("deprecation")
	public static String getMesAno(Date mydata) {
		String mes = String.valueOf(mydata.getMonth());
		String ano = String.valueOf(mydata.getYear());

		return mes + ano;
	}
*/
	public static String getFormattedData(int dia, int mes, int ano) {
		String strDia = null;
		String strMes = null;
		if (dia < 10) {
			strDia = "0" + dia;
		} else {
			strDia = Integer.toString(dia);
		}
		if (mes < 10) {
			strMes = "0" + mes;
		} else {
			strMes = Integer.toString(mes);
		}
		return strDia + "/" + strMes + "/" + Integer.toString(ano);
	}

	public static String getTodayDate() {
		Calendar dataAtual = Calendar.getInstance();

		Integer ano = dataAtual.get(Calendar.YEAR);
		Integer mes = dataAtual.get(Calendar.MONTH);
		Integer dia = dataAtual.get(Calendar.DAY_OF_MONTH);
		mes += 1;

		return getFormattedData(dia, mes, ano);
	}

	
	public static int getDaysOfInterval(Date dataInicial, Date dataFinal) {

		String diaInicial, mesInicial, anoInicial, anoFinal, mesFinal, diaFinal;
		anoInicial = getAno(dataInicial);
		anoFinal = getAno(dataFinal);
		mesInicial = getMesNumeral(dataInicial);
		mesFinal = getMesNumeral(dataFinal);
		diaInicial = getDia(dataInicial);
		diaFinal = getDia(dataFinal);

		DateTime inicio = new DateTime(Integer.valueOf(anoInicial),
				Integer.valueOf(mesInicial), Integer.valueOf(diaInicial), 0, 0,
				0, 0);
		DateTime fim = new DateTime(Integer.valueOf(anoFinal),
				Integer.valueOf(mesFinal), Integer.valueOf(diaFinal), 0, 0, 0,
				0);

		int dias = Days.daysBetween(inicio, fim).getDays();

		return dias;
	}
	

	public static boolean yearIsBisext(int year) {
		// Ano Bisexto (Regras do Calendário Gregoriano):
		// 1 - Todo ano divisível por 4 é bissexto
		// 2 - Todo ano divisível por 100 não é bissexto
		// 3 - Mas se o ano for também divisível por 400 é bissexto
		// FONTE: http://blog.webcalc.com.br/2006/04/29/o-que-e-ano-bissexto/
		boolean retorno;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					retorno = true;
				} else {
					retorno = false;
				}
			} else {
				retorno = true;
			}
		} else {
			retorno = false;
		}
		return retorno;
	}

	// Usar os meses de 0 a 11 para poder funcionar corretamente
	public static int getUltimoDiaMes(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static Date getUltimaDataMesAtual() {

		Calendar dataAtual = Calendar.getInstance();
		Integer ano = dataAtual.get(Calendar.YEAR);
		Integer mes = dataAtual.get(Calendar.MONTH);
		Integer dia = dataAtual.getActualMaximum(Calendar.DAY_OF_MONTH);
		dataAtual.set(ano, mes, dia, 0, 0, 0);

		return dataAtual.getTime();
	}

	public static Date getPrimeiraDataMesAtual() {
		Calendar dataAtual = Calendar.getInstance();
		Integer ano = dataAtual.get(Calendar.YEAR);
		Integer mes = dataAtual.get(Calendar.MONTH);
		Integer dia = 1;
		dataAtual.set(ano, mes, dia, 0, 0, 0);

		return dataAtual.getTime();
	}

	public static Date getPrimeiraDataMesAnterior() {
		Calendar dataAtual = Calendar.getInstance();
		Integer ano = dataAtual.get(Calendar.YEAR);
		Integer mes = dataAtual.get(Calendar.MONTH) - 1;
		Integer dia = 1;
		dataAtual.set(ano, mes, dia, 0, 0, 0);

		return dataAtual.getTime();
	}

	public static String getProximoMes() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.MONTH, +1);
		return sd.format(dataAtual.getTime());
	}

	public static int getDaysMonth(int month, int year) {
		// O ano valor do ano será usado para verificar se o ano é bisexto
		int[] mes = new int[12];

		mes[0] = 31;

		if (yearIsBisext(year)) {
			mes[1] = 29;
		} else {
			mes[1] = 28;
		}

		mes[2] = 31;

		mes[3] = 30;

		mes[4] = 31;

		mes[5] = 30;

		mes[6] = 31;

		mes[7] = 31;

		mes[8] = 30;

		mes[9] = 31;

		mes[10] = 30;

		mes[11] = 31;

		if (month < 1) {
			return mes[month];
		} else {
			return mes[month - 1];
		}
	}

	public static boolean isJaPassouUmAno(Date inicial, Date finalData) {
		String diaInicial, mesInicial, anoInicial, anoFinal, mesFinal, diaFinal;
		anoInicial = getAno(inicial);
		anoFinal = getAno(finalData);
		mesInicial = getMesNumeral(inicial);
		mesFinal = getMesNumeral(finalData);
		diaInicial = getDia(inicial);
		diaFinal = getDia(finalData);

		if (Integer.valueOf(anoFinal) > Integer.valueOf(anoInicial)) {
			if (Integer.valueOf(anoFinal) - Integer.valueOf(anoInicial) == 1) {
				if (Integer.valueOf(mesFinal) >= Integer.valueOf(mesInicial)) {
					if (Integer.valueOf(mesFinal) == Integer
							.valueOf(mesInicial)) {
						if (Integer.valueOf(diaFinal) > Integer
								.valueOf(diaInicial)) {
							return true;
						}
					} else {
						return true;
					}
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	public static int getQtdMeses(Date dataInicial, Date dataFinal)
			throws ParseException {

		String diaInicial, mesInicial, anoInicial, anoFinal, mesFinal, diaFinal;
		anoInicial = getAno(dataInicial);
		anoFinal = getAno(dataFinal);
		mesInicial = getMesNumeral(dataInicial);
		mesFinal = getMesNumeral(dataFinal);
		diaInicial = getDia(dataInicial);
		diaFinal = getDia(dataFinal);

		DateTime start = new DateTime(Integer.valueOf(anoInicial),
				Integer.valueOf(mesInicial), Integer.valueOf(diaInicial), 0, 0,
				0, 0);
		DateTime end = new DateTime(Integer.valueOf(anoFinal),
				Integer.valueOf(mesFinal), Integer.valueOf(diaFinal), 0, 0, 0,
				0);

		return Months.monthsBetween(start, end).getMonths();
	}
	*/

	public static Date getDataSemHora(Date data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String dataFormatada = formato.format(data);

		return formato.parse(dataFormatada);
	}

	public static int getAno() {
		int ano = Calendar.getInstance().get(Calendar.YEAR);

		return ano;
	}

	public static int getMes() {
		int mes = Calendar.getInstance().get(Calendar.MONTH);

		return mes;
	}

	public static int getDiaDoMes() {
		int diaHoje = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		return diaHoje;
	}

	public static List<Date> getDiasDoMes(int mes) throws ParseException {
		List<Date> listaDias = new ArrayList<Date>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int ultimoDiaMes = getUltimoDiaMes(mes);

		int ano = getAno();

		if (yearIsBisext(ano) && mes == 1) {
			ultimoDiaMes += 1;
		}

		mes += 1;

		for (int i = 1; i <= ultimoDiaMes; i++) {
			String dataString = i + "/" + mes + "/" + ano;

			Date data = sdf.parse(dataString);

			listaDias.add(data);
		}

		return listaDias;
	}

	public static List<Date> getDiasDoMes(int mes, int ano)
			throws ParseException {
		List<Date> listaDias = new ArrayList<Date>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int ultimoDiaMes = getUltimoDiaMes(mes);

		if (yearIsBisext(ano) && mes == 1) {
			ultimoDiaMes += 1;
		}

		mes += 1;

		for (int i = 1; i <= ultimoDiaMes; i++) {
			String dataString = i + "/" + mes + "/" + ano;

			Date data = sdf.parse(dataString);

			listaDias.add(data);
		}

		return listaDias;
	}

	public static int getQuantDiasDoMes(int mes) throws ParseException {

		int ultimoDiaMes = getUltimoDiaMes(mes);
		return ultimoDiaMes;
	}

	@SuppressWarnings("deprecation")
	public static List<Date> getDiasDoMesPorData(Date valorData)
			throws ParseException {

		int mes = valorData.getMonth();
		int ano = valorData.getYear();

		List<Date> listaDias = new ArrayList<Date>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int ultimoDiaMes = getUltimoDiaMes(mes);

		if (yearIsBisext(ano) && mes == 1) {
			ultimoDiaMes += 1;
		}

		mes += 1;

		for (int i = 1; i <= ultimoDiaMes; i++) {
			String dataString = i + "/" + mes + "/" + ano;

			Date data = sdf.parse(dataString);

			listaDias.add(data);
		}

		return listaDias;
	}

	public static int getSemanaDoDia(Date dia) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dia);

		return gc.get(GregorianCalendar.WEEK_OF_MONTH);
	}

	public static int getMesDoDia(Date dia) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dia);

		return gc.get(GregorianCalendar.MONTH);
	}

	public static boolean getVerificaDataEntreDatas(Date dataInicial,
			Date dataFinal, Date dataAVerificar) {
		return dataAVerificar.getTime() >= dataInicial.getTime()
				&& dataAVerificar.getTime() <= dataFinal.getTime();
	}

	public static int[] getAnosDoPeriodo(Date inicio, Date fim) {
		int[] arrayAnos = null;

		GregorianCalendar gcInicio = new GregorianCalendar();
		gcInicio.setTime(inicio);
		int anoInicial = gcInicio.get(GregorianCalendar.YEAR);

		GregorianCalendar gcFim = new GregorianCalendar();
		gcFim.setTime(fim);
		int anoFinal = gcFim.get(GregorianCalendar.YEAR);

		if (anoInicial > anoFinal) {
			return null;
		}

		int tamanhoArrayAnos = 1;

		if (anoInicial == anoFinal) {
			arrayAnos = new int[tamanhoArrayAnos];
			arrayAnos[0] = anoInicial;
		} else {
			int cont = 0;

			tamanhoArrayAnos += (anoFinal - anoInicial);

			int ano = anoInicial;

			arrayAnos = new int[tamanhoArrayAnos];

			for (int i = ano; i <= anoFinal; i++) {
				arrayAnos[cont] = i;

				cont++;
			}

		}

		return arrayAnos;
	}

	public static Date getPrimeiroUltimoDiaUtilSemana(Date dia,
			boolean isPrimeiro) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dia);

		int primeiroDiaMes = 1;
		int ultimoDiaMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (isPrimeiro) {
			if (calendar.get(Calendar.DAY_OF_MONTH) != primeiroDiaMes) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			}

			return calendar.getTime();
		} else {
			if (calendar.get(Calendar.DAY_OF_MONTH) != ultimoDiaMes) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}

			return calendar.getTime();
		}

	}

	public static String getDataAtualPorExtenso(){  
	     
	    String retorno = null;  
	    
	    Calendar calendar = Calendar.getInstance(); 
	    Date hoje = new Date();  
	    calendar.setTime(hoje);  
	   
	    int mes = calendar.get(Calendar.MONTH);  
	    int dia = calendar.get(Calendar.DAY_OF_MONTH);  
	    int ano = calendar.get(Calendar.YEAR);  
	     	    
	    retorno =  dia + " de " + obterMesPorExtenso(mes) + " de " + ano;  
	    
	    int hora = calendar.get(Calendar.HOUR);
	    int minuto = calendar.get(Calendar.MINUTE);
	    int segundo  = calendar.get(Calendar.SECOND);
	    String horas = hora<10?"0"+hora:""+hora;
	    String minutos = minuto<10?"0"+minuto:""+minuto;
	    String segundos= segundo<10?"0"+segundo:""+segundo;
	    retorno += "   "+horas+":"+minutos+":"+segundos;
	    
	    return retorno;  
	    
	}
	
	public static String obterMesPorExtenso(int codigo){
		
		String mesf = null;  
		
		switch(codigo) {  
	    	
	    	case 0:  mesf = "Janeiro"; 
	    	break;
	    	
	    	case 1:  mesf = "Fevereiro";  
	    	break;
	    	
	    	case 2:  mesf = "Março";  
	    	break;
	    	
	    	case 3:  mesf = "Abril";  
	    	break;
	    	
	    	case 4:  mesf = "Maio";  
	    	break;
	    	
	    	case 5:  mesf = "Junho";  
	    	break;
	    	
	    	case 6:  mesf = "Julho";  
	    	break;
	    	
	    	case 7:  mesf = "Agosto";  
	    	break;
	    	
	    	case 8:  mesf = "Setembro";  
	    	break;
	    	
	    	case 9: mesf = "Outubro";  
	    	break;
	    	
	    	case 10: mesf = "Novembro";  
	    	break;
	    	
	    	case 11: mesf = "Dezembro";  
	    	break;
	    	
	    } 
		 
		return mesf;
		
	}

}