package data;

import java.io.Serializable;

public class Product extends Offer implements Serializable {

	private static final long serialVersionUID = 7257056321333282809L;


	private String barcode;

	public Product(String name, double price, String barcode) {
		super(name, price);
		this.barcode = barcode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(50);
		sb.append("Barcode=");
		sb.append(getBarcode());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Price=");
		sb.append(getPrice());
		return sb.toString();
	}

}
