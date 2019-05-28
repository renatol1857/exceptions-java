package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Room number: ");
		int numQuarto = sc.nextInt();
		
		System.out.print("check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); 
		
		System.out.print("check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); 
		
		if (checkOut.after(checkIn)) {
			Reserva reserva = new Reserva(checkIn,checkOut,numQuarto);
			System.out.println(reserva);
			System.out.println();

			Date now = new Date();
			System.out.print("Enter new check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Enter new check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next()); 
			System.out.println(reserva.updateDates(checkIn, checkOut));
		}
		else {
			System.out.println("Data Check-out menor que data check-in.");
		}

		sc.close();		
	}

}
