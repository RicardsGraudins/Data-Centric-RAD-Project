package mypackage;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ModelController {

	private ArrayList<Model> models;
	private DAO dao;

	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getModels() {
		return models;
	}

	public void loadModels() throws Exception {
		models = dao.getModelDetails();
	}

	public String addModel(Model p) throws Exception {
		try {
			dao.addModel(p);
			return "add_model";
		} catch (Exception e) {
			return e.toString();
		}
	}
}