package mypackage;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VehicleController {

	private ArrayList<Vehicle> vehicles;
	private DAO dao;

	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void loadVehicles() throws Exception {
		vehicles = dao.getVehicleDetails();
	}
	

	public String addVehicle(Vehicle p) throws Exception {
		try {
			dao.addVehicle(p);
			return "add_vehicle";
		} catch (Exception e) {
			return e.toString();
		}

	}
	
	public String searchCar(Vehicle p) throws Exception {
		try {
			dao.searchCar(p);
			return "find_cars";
		} catch (Exception e){
			return e.toString();
		}
	}
}