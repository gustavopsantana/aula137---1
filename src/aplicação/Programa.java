package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data Check-In: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data Check-Out: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro ao fazer a Reserva: Data do Check-Out anterior a data do Check-In!");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Informe a nova data da Reserva:");
			System.out.print("Data Check-In: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-Out: ");
			checkOut = sdf.parse(sc.next());

			String erro = reserva.atualizaData(checkIn, checkOut);
			if (erro != null) {
				System.out.println(erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();

	}

}
