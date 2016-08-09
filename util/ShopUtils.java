package util;

import data.Product;
import data.Service;
import data.Shop;

public class ShopUtils {

	@SuppressWarnings("rawtypes")
	public static void printOffers(Shop s,  Class c) {

		long count = s.getOffer().values().stream().filter(c::isInstance).sorted(new Shop.NameComparator())
				.peek(System.out::println).count();

		if (count == 0) {
			System.out.println("brak");
		}
	}

	public static void printProducts(Shop s) {
		printOffers(s, Product.class);
	}

	public static void printServices(Shop s) {
		printOffers(s, Service.class);
	}
	public static void printHistory(Shop s){
		s.getTransactionHistory().stream().forEach(System.out::println);
	}

	public static void printEmployees(Shop s) {

		s.getEmployees().values().stream().sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
				.forEach(System.out::println);

	}

}
