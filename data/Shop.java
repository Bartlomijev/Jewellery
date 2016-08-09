package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop implements Serializable {

	private static final long serialVersionUID = -1012624846724948081L;

	private Map<String, Offer> offer;
	private Map<String, Employee> employees;
	private List<Offer> transactionHistory;

	public Map<String, Offer> getOffer() {
		return offer;
	}

	public Map<String, Employee> getEmployees() {
		return employees;
	}

	public List<Offer> getTransactionHistory() {
		return transactionHistory;
	}

	public Shop() {
		offer = new HashMap<>();
		employees = new HashMap<>();
		transactionHistory = new ArrayList<>();

	}
/*dodanie do historii transakcji*/
	public void AddToHistory(Offer o) {
		transactionHistory.add(o);
	}
/*dodanie ofert z ujemną ceną*/
	private void addOffer(Offer o) {
		o.setPrice(o.getPrice() * (-1));

	}
/*dodanie usługi, bez dodania do histori*/
	public void addService(Service s) {
		offer.put(s.getServiceCode(), s);
		addOffer(s);
	}
/*dodanie produktu do sklepu i do historii*/
	public void addProduct(Product p) {
		offer.put(p.getBarcode(), p);
		addOffer(p);
		AddToHistory(p);

	}

	public void addEmployee(Employee e) {
		employees.put(e.getId(), e);
	}
/*sprzedaż produktu i usunięcie go z mapy offer oraz dodanie sprzedaży do historii*/
	public void removeProduct(Product p) {
		AddToHistory(p);
		p.setName(offer.get(p.getBarcode()).getName());

		offer.remove(p.getBarcode());
	}
/*sprzedaż usługi, dodanie do historii kosztu oraz przychodu z usługi, bez usuwania z mapy offer*/
	public void removeService(Service s) {

		transactionHistory.add(offer.get(s.getServiceCode()));
		transactionHistory.add(s);
		s.setName(offer.get(s.getServiceCode()).getName());
		s.setDescription(((Service) offer.get(s.getServiceCode())).getDescription());

	}

	public void removeOneEmployee(String id) {
		if (getEmployees().containsKey(id)) {
			employees.remove(id);
		}
	}

	public static class NameComparator implements Comparator<Offer> {

		@Override
		public int compare(Offer o1, Offer o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			o1.getName().compareTo(o2.getName());
			return o1.getName().compareTo(o2.getName());

		}

	}
}
