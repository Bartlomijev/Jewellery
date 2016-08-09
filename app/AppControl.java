package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import data.Employee;
import data.Product;
import data.Service;
import data.Shop;
import util.FileManager;
import util.Reader;
import util.ShopUtils;

public class AppControl {

	private Reader reader;
	private Shop shop;
	private FileManager fileManager;

	public AppControl() {
		reader = new Reader();
		fileManager = new FileManager();

		try {
			shop = fileManager.ReadFromFile();
			System.out.println("Wczytano dane");
		} catch (ClassNotFoundException | IOException e) {
			shop = new Shop();
			System.out.println("Utworzono baze");
		}

	}

	public void chooseOption() {
		Option option = null;
		while (option != Option.EXIT) {
			try {
				printOptions();
				option = Option.createOption(reader.getInt());
				switch (option) {
				case ADD_PRODUCT:
					addProduct();
					break;
				case PRINT_PRODUCT:
					printProduct();
					break;
				case REMOVE_PRODUCT:
					removeProduct();
					break;
				case ADD_SERVICE:
					addService();
					break;
				case PRINT_SERVICE:
					printService();
					break;
				case REMOVE_SERVICE:
					removeService();
					break;
				case ADD_EMPLOYEE:
					addEmployee();
					break;
				case PRINT_EMPLOYEE:
					printEmployee();
					break;
				case REMOVE_EMPLOYEE:
					removeEmployee();
					break;
				case PRINT_HISTORY:
					printHistory();
					break;
				case EXIT:
					exit();
				}
			} catch (NumberFormatException e) {
				System.out.println("dokonano niepoprawnego wyboru opcji");
			} catch (InputMismatchException e) {
				System.out.println("nie dodano produktu, ze względu na błędnie wprowadzone dane");
			}

		}
		reader.close();
	}

	private void printOptions() {
		System.out.println("dostępne opcje:");
		for (Option o : Option.values())
			System.out.println(o);
	}

	private void addProduct() {
		Product product = reader.CreateProduct();
		shop.addProduct(product);

	}

	private void printProduct() {
		ShopUtils.printProducts(shop);
	}

	private void addService() {
		Service service = reader.CreateService();
		shop.addService(service);
	}

	private void printService() {
		ShopUtils.printServices(shop);
	}

	private void removeProduct(){
		Product product = reader.SellProduct();
		shop.removeProduct(product);
	}
	private void removeService(){
		Service service = reader.SellService();
		shop.removeService(service);
	}

	private void addEmployee() {
		Employee employee = reader.createEmployee();
		shop.addEmployee(employee);
	}

	private void printEmployee() {
		ShopUtils.printEmployees(shop);
	}

	private void removeEmployee() {
		String key = reader.removeOneEmployee();
		shop.removeOneEmployee(key);
	}

	private void printHistory() {
		ShopUtils.printHistory(shop);

	}

	private void exit() {
		fileManager.WriteToFile(shop);
	}

	private enum Option {

		EXIT(0, "Wyjście z programu"),
		ADD_PRODUCT(1, "Dodaj produkt do sklepu"),
		PRINT_PRODUCT(2,"Wyświetl dostępne produkty"),
		REMOVE_PRODUCT(3, "Sprzedaj produkt"),
		ADD_SERVICE(4, "Dodaj usługę"),
		PRINT_SERVICE(5, "Wyświetl dostępne usługi"),
		REMOVE_SERVICE(6, "Sprzedaj usługę"),
		ADD_EMPLOYEE(7, "Dodaj pracownika"),
		PRINT_EMPLOYEE(8, "Wyświetl pracowników"),
		REMOVE_EMPLOYEE(9, "Usuń pracownika"),
		PRINT_HISTORY(10, "Wyświetl historię transakcji");

		private int option;
		private String desc;

		Option(int option, String desc) {
			this.option = option;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return option + " " + desc;
		}

		public static Option createOption(int option) throws NoSuchElementException {
			Option result = null;
			try {
				result = Option.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Nie odnaleziono elementu");
			}
			return result;
		}
	}

}
