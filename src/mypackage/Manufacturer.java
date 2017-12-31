package mypackage;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Manufacturer {

	private String manu_code;
	private String manu_name;
	private String manu_details;

	public Manufacturer() {
	}

	public Manufacturer(String manu_code, String manu_name, String manu_details) {
		super();
		this.manu_code = manu_code;
		this.manu_name = manu_name;
		this.manu_details = manu_details;
	}

	public String getManu_code() {
		return manu_code;
	}

	public void setManu_code(String manu_code) {
		this.manu_code = manu_code;
	}

	public String getManu_name() {
		return manu_name;
	}

	public void setManu_name(String manu_name) {
		this.manu_name = manu_name;
	}

	public String getManu_details() {
		return manu_details;
	}

	public void setManu_details(String manu_details) {
		this.manu_details = manu_details;
	}
}