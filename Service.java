package data;

import java.io.Serializable;

public class Service extends Offer implements Serializable {

	private static final long serialVersionUID = -7397691163227650920L;

	private String description;
	private String serviceCode;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Service(String name, double price, String description, String serviceCode) {
		super(name, price);
		this.description = description;
		this.serviceCode = serviceCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(50);
		sb.append("ServiceCode=");
		sb.append(getServiceCode());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Price=");
		sb.append(getPrice());
		sb.append(", Description=");
		sb.append(getDescription());
		return sb.toString();
	}

}
