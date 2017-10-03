package application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;


import application.ApiTool;


public class ViewController {
	
	@FXML
	private TextField searchEntityField;
	@FXML
	private TextField getEntityField;
	@FXML
	private Button searchEntityButton;
	@FXML
	private Button getEntityButton;
	@FXML
	private TextArea log;
	
	@FXML
	private void initialize() {
		
		searchEntityButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				String res = "champ searchEntity vide !";
				if(!searchEntityField.getText().isEmpty()){
					try {
						
						res = ApiTool.searchFromWikiData(searchEntityField.getText());
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				log.setText(res);
			}
	    });
		
		getEntityButton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	    	String res = "champ getEntity vide !";
    	    	if(!getEntityField.getText().isEmpty()){
    	    		try {
						res = ApiTool.getEntityFromWikiData(getEntityField.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	    	}
    	    	log.setText(res);
    	    }
		});
		
	}

}
