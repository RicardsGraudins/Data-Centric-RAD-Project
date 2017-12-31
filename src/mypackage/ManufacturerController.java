package mypackage;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ManufacturerController {

	private ArrayList<Manufacturer> manufacturers;
	private DAO dao;

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void loadManufacturers() throws Exception {
		manufacturers = dao.getManufacturerDetails();
	}

	public String addManufacturer(Manufacturer p) throws Exception {
		try {
			dao.addManufacturer(p);
			return "add_manufacturer";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String deleteManufacturer(Manufacturer p) throws Exception {

		try {
			dao.deleteManufacturer(p);
			return "list_manufacturers";
		} catch (Exception e) {
			return e.toString();
		}

	}
	
	public String updateManufacturer(Manufacturer p) throws Exception {
		
		try {
			dao.updateManufacturer(p);
			return "list_manufacturers";
		} catch (Exception e) {
			return e.toString();
		}
	}
}