package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner (System.in);
		
		try {
			System.out.print("Room number: ");
			int numQuarto = sc.nextInt();
			
			System.out.print("check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); 
			
			System.out.print("check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next()); 
			
			Reserva reserva = new Reserva(checkIn,checkOut,numQuarto);
			System.out.println(reserva);
			System.out.println();
	
			System.out.print("Enter new check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Enter new check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next()); 
			reserva.updateDates(checkIn, checkOut);
			System.out.println(reserva);
		}
		catch(ParseException e) {
			System.out.println("Erro na reserva: " + e.getMessage() );
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Erro nao entradao do quarto.");
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");

		}
		sc.close();		
	}

}
