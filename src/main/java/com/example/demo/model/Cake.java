/**
 * 
 */
package com.example.demo.model;

/**
 * @author prajw
 *
 */
public class Cake {
	private int cakeId;
	private String cakeName;
	private int pound;
	private double pricePerPound;
	private boolean eggless;
	
	
	public Cake(int cakeId, String cakeName, int pound, double pricePerPound, boolean eggless) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.pound = pound;
		this.pricePerPound = pricePerPound;
		this.eggless = eggless;
	}
	public int getCakeId() {
		return cakeId;
	}
	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public int getPound() {
		return pound;
	}
	public void setPound(int pound) {
		this.pound = pound;
	}
	public double getPricePerPound() {
		return pricePerPound;
	}
	public void setPricePerPound(double pricePerPound) {
		this.pricePerPound = pricePerPound;
	}
	public boolean isEggless() {
		return eggless;
	}
	public void setEggless(boolean eggless) {
		this.eggless = eggless;
	}
	
	

}
