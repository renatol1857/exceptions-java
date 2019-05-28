package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Date checkIn, checkOut;
	private int numQuarto;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Date checkIn, Date checkOut, int numQuarto) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numQuarto = numQuarto;
	}
	
	
	
	public Date getChekIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public float duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDates (Date checkIn, Date checkOut) {
		Date dateNow = new Date();
		
		if ( checkIn.before(dateNow) )
			return "Data de check-in inferior a data atual.";
		if(checkIn.after(checkOut))
			return "Data de check-in superior a data de check-out.";
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return toString();
	}

	@Override
	public String toString() {
		return "Reserva [checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + ", numQuarto=" + numQuarto + ", " + String.format("%.2f", duration()) + "]";
	}
	
	

}