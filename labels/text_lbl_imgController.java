package labels;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class text_lbl_imgController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnNew;

    @FXML
    void doInput(ActionEvent event) 
    {
    	TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("OTP");
		
		dialog.setContentText("Please enter your OTP:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()==true){
		    showAlert("Your name: " + result.get());
		}
		else
			 showAlert("action Canceled" );

    }
    
    @FXML
    void doClose(ActionEvent event)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		
		alert.setHeaderText("Look, a Confirmation Dialog");
		
		alert.setContentText("Are you ok with this?");
				
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == ButtonType.OK)
		{
			System.exit(0);
		} 
		else 
		{
			showAlert("Its Ok...");
		}
    		
    }

    @FXML
    void doMulti(ActionEvent event) {
    	String vas=txtA.getText();
		float va=Float.parseFloat(vas);
		float vb=Float.parseFloat(txtB.getText());
		float multi=va*vb;
		txtResult.setText(String.valueOf(multi));
    }

    @FXML
    void doNew(ActionEvent event) {
    		txtA.setText("");
    		txtB.setText("");
    		
    }

    @FXML
    void doSum(ActionEvent event) {
    		String vas=txtA.getText();
    		if(txtA.getText().equals("")||txtB.getText().equals(""))
    			showAlert("Fill Data plz...");
    		else
    		{
    		float va=Float.parseFloat(vas);
    		float vb=Float.parseFloat(txtB.getText());
    		float sum=va+vb;
    		txtResult.setText(String.valueOf(sum));
    		//txtResult.setText(sum+"");
    		}
    }
	void showAlert(String msg)
	{
		Alert alert=new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Data Error");
		alert.setContentText(msg);
		alert.show();
		
	}
    @FXML
    void initialize() {
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'text_lbl_img.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'text_lbl_img.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'text_lbl_img.fxml'.";
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'text_lbl_img.fxml'.";

    }
}
