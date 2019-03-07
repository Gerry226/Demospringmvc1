package org.fkit.controller;

public class ContactInfo {
	private String phone;
	private String adress;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "ContactInfo [phone=" + phone + ", adress=" + adress + "]";
	}
	
}
