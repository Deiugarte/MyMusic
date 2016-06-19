package myfan.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFabrication {

	private final String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * Covierte un tipo DateFabrication a un String con la DateFabrication
	 * 
	 * @param date
	 * @return
	 */
	public Date getDateFromString(String date) {
		Date returnDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			returnDate = simpleDateFormat.parse(date);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return returnDate;
	}

	/**
	 * Calcula la fecha actual del sistema
	 * 
	 * @return un tipo de fecha DateFabrication
	 */
	public Date getCurrentDate() {
		String currentDate;
		Date dateFabrication = null;
		Calendar currentDateComputer = Calendar.getInstance();
		DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		currentDate = dateFormatter.format(currentDateComputer.getTime());
		try {
			dateFabrication = dateFormatter.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFabrication;
	}

}
