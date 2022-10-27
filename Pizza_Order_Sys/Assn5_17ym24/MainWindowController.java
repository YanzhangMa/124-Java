package application;

import java.awt.Label;
import java.awt.TextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;

public class MainWindowController {
	/*
	 * Settings of the label and elements for pizza ordering.
	 */
	@FXML private Label label_1;
	@FXML private Label label_2;
	@FXML private Label label_3;
	@FXML private Label label_4;
	@FXML private ChoiceBox size;
	@FXML private ChoiceBox cheese;
	@FXML private ChoiceBox pineapple;
	@FXML private ChoiceBox greenpepper;
	@FXML private ChoiceBox ham;
	@FXML private TextField pizza;
	@FXML private TextField cost;
	ObservableList<String> sizelist = (ObservableList<String>)FXCollections.observableArrayList("small","meidum","large");
	ObservableList<String> cheeselist = (ObservableList<String>)FXCollections.observableArrayList("single","double","triple");
	ObservableList<Object> toppings = (ObservableList<Object>)FXCollections.observableArrayList("single",new Separator(),"none");
	
	/*
	 * Set main function. 
	 */
	private Main main;
	public void setMain(Main main) {
		this.main = main;
	}
	
	/*
	 * Set the elements.
	 */
	@SuppressWarnings("unchecked")
	public void initialize() {
		size.setItems(sizelist);
		cheese.setValue("single");
		cheese.setItems(cheeselist);
		pineapple.setValue("none");
		pineapple.setItems(toppings);
		greenpepper.setValue("none");
		greenpepper.setItems(toppings);
		ham.setValue("none");
		ham.setItems(toppings);
	}

	/*
	 * Get the value of each element and make choices.
	 */
	public void button(){
		String Size = (String)size.getValue();
		String Cheese = (String)cheese.getValue();
		String Pineapple = (String)pineapple.getValue();
		String Greenpepper = (String)greenpepper.getValue();
		String Ham = (String)ham.getValue();
		String output = Size + "pizza" + Cheese +"cheese";
		
		if(Ham.equals("none")&&(!Pineapple.equals("none")||!Greenpepper.equals("none"))) {
			pizza.setText("Invalid choice.");
		}else {
			if(Pineapple.equals("single")) {
				output += "pineapple";
			}
			if(Greenpepper.equals("single")){
				output+="greenpepper";
			}
			if(Ham.equals("single")){
				output+="greenpepper";
			}pizza.setText(output);
		}
	}
}
