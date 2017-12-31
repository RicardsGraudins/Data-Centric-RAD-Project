package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {

	private static final String NULL = null;
	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public void addManufacturer(Manufacturer p) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("INSERT INTO manufacturer values(?, ?, ?)");
	
			myStmt.setString(1, p.getManu_code());
			myStmt.setString(2, p.getManu_name());
			myStmt.setString(3, p.getManu_details());
	
			myStmt.executeUpdate();
		} catch (SQLException e){
			while (e != null){
				String errorMessage = e.getMessage();
				System.err.println("Error: " + errorMessage);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", errorMessage));
				e = null;
			}
		}
	}

	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception {

		ArrayList<Manufacturer> manufacturers = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from manufacturer");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			String id = rs.getString("manu_code");
			String mname = rs.getString("manu_name");
			String mdetails = rs.getString("manu_details");

			manufacturers.add(new Manufacturer(id, mname, mdetails));
		}

		return manufacturers;
	}

	public ArrayList<Model> getModelDetails() throws Exception {

		ArrayList<Model> models = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from model");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			String id = rs.getString("manu_code");
			String mcode = rs.getString("model_code");
			String mname = rs.getString("model_name");
			String mdesc = rs.getString("model_desc");

			models.add(new Model(id, mcode, mname, mdesc));
		}

		return models;
	}

	public void addModel(Model p) throws SQLException {
		
		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?)");
	
			myStmt.setString(1, p.getManu_code());
			myStmt.setString(2, p.getModel_code());
			myStmt.setString(3, p.getModel_name());
			myStmt.setString(4, p.getModel_desc());
	
			myStmt.executeUpdate();
		} catch(SQLException e){
			while(e != null){
				String errorMessage = e.getMessage();
				System.err.println("Error: " + errorMessage);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", errorMessage));
				e = null;
			}
		}
	}
	
	public ArrayList<Vehicle> getVehicleDetails() throws Exception {

		ArrayList<Vehicle> vehicles = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from vehicle");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			String reg = rs.getString("reg");
			String manuCode = rs.getString("manu_code");
			String modelCode = rs.getString("model_code");
			int mil = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");

			vehicles.add(new Vehicle(reg, manuCode, modelCode, mil, price, colour, fuel));
		}

		return vehicles;
	}
	
	public void addVehicle(Vehicle p) throws SQLException {

		try {
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("INSERT INTO vehicle values(?, ?, ?, ?, ?, ?, ?)");
	
			myStmt.setString(1, p.getReg());
			myStmt.setString(2, p.getManu_code());
			myStmt.setString(3, p.getModel_code());
			myStmt.setInt(4, p.getMileage());
			myStmt.setDouble(5, p.getPrice());
			myStmt.setString(6, p.getColour());
			myStmt.setString(7, p.getFuel());
	
			myStmt.executeUpdate();
		} catch(SQLException e){
			while(e != null){
				String errorMessage = e.getMessage();
				System.err.println("Error: " + errorMessage);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", errorMessage));
				e = null;
			}
		}
	}
	
	public void deleteManufacturer(Manufacturer p) throws SQLException {
		
		try {	
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("delete from manufacturer where manu_code like '" + p.getManu_code() + "'");
	
			myStmt.executeUpdate();
		} catch (SQLException e){
			while (e != null){
				String errorMessage = e.getMessage();
				System.err.println("Error: " + errorMessage);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", errorMessage));
				e = null;
			}
		}
	}
	
	public void updateManufacturer(Manufacturer p) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("update manufacturer set manu_name = '" + p.getManu_name() + "', manu_details = '" + p.getManu_details() + "' where manu_code = '" + p.getManu_code() + "'");
		
		myStmt.executeUpdate();
	}
	
	public void searchCar(Vehicle p) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from vehicle where price < '" + p.getPrice() + "'");
		PreparedStatement myStmt1 = conn.prepareStatement(" and colour = '" + p.getColour() + "'");
		PreparedStatement myStmt2 = conn.prepareStatement(" and fuel = '" + p.getFuel() + "'");
		
		myStmt.executeUpdate();
		
		if (p.getColour() == NULL){
			if (p.getPrice() == 0){
				myStmt2.executeUpdate();
			}
		}
		
		if (p.getColour() == NULL){
			myStmt2.executeUpdate();
		}
		
		
		if (p.getColour() != NULL){
			myStmt1.executeUpdate();
		}
	}
}