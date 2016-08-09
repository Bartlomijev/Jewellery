package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Employee;
import data.Product;
import data.Service;
import data.Shop;

public class Reader {
	Scanner sc;
	Shop shop;


	public Reader() {
		sc = new Scanner(System.in);
		shop = new Shop();
	}

	public void close() {
		sc.close();
	}

	public int getInt() throws NumberFormatException {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			throw new NumberFormatException("Nie wprowadzono liczby");
		}
		sc.nextLine();
		return number;
	}

	public Product CreateProduct() throws InputMismatchException {
		System.out.println("Nazwa produktu");
		String name = sc.nextLine();
		System.out.println("Cena nabycia/Koszt wytworzenia");
		double price = 0;
		try {
			price = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}


		System.out.println("Kod kreskowy");
		String barcode = sc.nextLine();

		return new Product(name, price, barcode);

	}

	public Product SellProduct() throws InputMismatchException {

		String name = "  ";
		System.out.println("Kod kreskowy");
		String barcode = sc.nextLine();
		System.out.println("Cena sprzedaży");
		double price = 0;
		try {
			price = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		return new Product(name, price, barcode);

	}

	public Service CreateService() throws InputMismatchException {
		System.out.println("Nazwa usługi");
		String name = sc.nextLine();
		System.out.println("Koszt wykonania usługi");
		double price = 0;
		try {
			price = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		System.out.println("Opis usługi:");
		String description = sc.nextLine();
		System.out.println("Kod usługi");
		String serviceCode = sc.nextLine();

		return new Service(name, price, description, serviceCode);

	}
	public Service  SellService() throws InputMismatchException {

		String name = "  ";
		String description = "  ";
		System.out.println("Kod usługi");
		String serviceCode = sc.nextLine();
		System.out.println("Cena wykonania usługi");
		double price = 0;
		try {
			price = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		return new Service(name, price, description, serviceCode);

	}

	public Employee createEmployee() {
		System.out.println("Imię pracownika ");
		String firstName = sc.nextLine();
		System.out.println("Nazwisko");
		String lastName = sc.nextLine();
		System.out.println("Numer id");
		String id = sc.nextLine();

		return new Employee(firstName, lastName, id);
	}

	/*public String removeOneOffer() {
		System.out.println("Podaj nazwę produktu do usunięcia");
		String name = sc.nextLine();
		return name;

	}*/

	public String removeOneEmployee() {
		System.out.println("Podaj numer id pracownika");
		String id = sc.nextLine();
		return id;

	}
}
