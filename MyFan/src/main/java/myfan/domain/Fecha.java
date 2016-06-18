package myfan.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

	private final String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * Covierte un tipo Date a un String con la Fecha
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
	 * @return un tipo de fecha Date
	 */
	public Date getCurrentDate() {
		String currentDate;
		Date date = null;
		Calendar currentDateComputer = Calendar.getInstance();
		DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		currentDate = dateFormatter.format(currentDateComputer.getTime());
		try {
			date = dateFormatter.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
