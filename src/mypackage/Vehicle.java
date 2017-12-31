package mypackage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;
import java.util.ArrayList;

@ManagedBean
@ViewScoped

public class Vehicle {

	private String reg;
	private String manu_code;
	private String model_code;
	private int mileage;
	private double price;
	private String colour;
	private String fuel;
	
	List<String> fuelOptions;
	

	public Vehicle() {
	}

	public Vehicle(String reg, String manu_code, String model_code, int mileage, double price, String colour, String fuel) {
		super();
		this.reg = reg;
		this.manu_code = manu_code;
		this.model_code = model_code;
		this.mileage = mileage;
		this.price = price;
		this.colour = colour;
		this.fuel = fuel;
		
		fuelOptions = new ArrayList<>();
		fuelOptions.add("petrol");
		fuelOptions.add("diesel");
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getManu_code() {
		return manu_code;
	}

	public void setManu_code(String manu_code) {
		this.manu_code = manu_code;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public List<String> getFuelOptions(){
		return fuelOptions;
	}
}