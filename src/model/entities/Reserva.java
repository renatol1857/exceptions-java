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
		//duracao /= (1000 * 60 * 60 * 24);
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates (Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reserva [checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + ", numQuarto=" + numQuarto + ", " + String.format("%.2f", duration()) + "]";
	}
	
	

}