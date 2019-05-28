package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Date checkIn, checkOut;
	private int numQuarto;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Date checkIn, Date checkOut, int numQuarto) {
		Date dateNow = new Date();
		if (checkIn.before(dateNow) || checkOut.before(dateNow) )
			throw new IllegalArgumentException("Data de check-in/out inferior a data atual.");
		if(checkIn.after(checkOut))
			throw new IllegalArgumentException("Check-in maior que check-out.");
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
	
	public void updateDates (Date checkIn, Date checkOut) throws DomainException{
		Date dateNow = new Date();
		
		if ( checkIn.before(dateNow) )
			throw new DomainException("Data de check-in inferior a data atual.");
		if(checkIn.after(checkOut))
			throw new DomainException("Data de check-in superior a data de check-out.");
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reserva [checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + ", numQuarto=" + numQuarto + ", " + String.format("%.2f", duration()) + "]";
	}
	
	

}