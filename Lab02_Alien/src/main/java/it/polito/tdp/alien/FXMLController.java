package it.polito.tdp.alien;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLController {

	private AlienDictionary elenco;
	
	private Image image = new Image("Alien-512.png");
	  
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txtAlienText;

    @FXML
    private TextField txtTraduzione;

    @FXML
    private Button btnTranslate;

    @FXML
    private Button btnReset;
    
    @FXML
    private ImageView imgAlien;


    @FXML
    private TextArea txtResult;


    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	txtTraduzione.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String testo = txtTraduzione.getText().toLowerCase();
    	if(testo.matches("[0-9@#$%\s?]")) {
    		txtResult.setText("Il testo deve contenere solo lettere!");
    		return;
    	}
    	if(testo.matches("[a-zA-Z\s?]+") && testo.contains(" ")) {
    		String parole[] = testo.split(" ");
    		elenco.addWord(parole[0], parole[1]);
    	}
    	else if(!testo.contains(" ")) {
    		//txtResult.setText(elenco.translateWord(testo));
    		String parole[] = testo.split(" ");
    		txtResult.setText(elenco.translateWordEnhanced(parole[0]));
    	}
    	
    	txtTraduzione.setText("");
    }

    //fare esercizio 2
   
    @FXML
    void initialize() {
        assert txtAlienText != null : "fx:id=\"txtAlienText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert imgAlien != null : "fx:id=\"imgAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new AlienDictionary();
        imgAlien.setImage(image);
    }
}
