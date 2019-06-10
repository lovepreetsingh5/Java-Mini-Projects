package radios.checks;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class radiosChecksController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkDosa;

    @FXML
    private CheckBox chkMan;

    @FXML
    private CheckBox chkBur;

    @FXML
    private CheckBox chkAll;

    @FXML
    private ToggleGroup discount;

    @FXML
    private Label lblNet;

    @FXML
    private Label lblTotal;
    
    @FXML
    void doCheckAll(ActionEvent event) 
    {
    		boolean b=chkAll.isSelected();//to check W. it sel. or not.
    			chkDosa.setSelected(b);//to check or un-check the box
    			chkMan.setSelected(b);
    			chkBur.setSelected(b);
    			
    		

    }
    int bill,dis,net;
    
    @FXML
    void doChkDosa(ActionEvent event)
    {
    		if(chkDosa.isSelected()==false)
    			chkAll.setSelected(false);
    }
    
    @FXML
    void doBill(ActionEvent event)
    {
    	bill=0;
    	if(chkDosa.isSelected())
    		bill+=150;
    	
     	if(chkMan.isSelected())
    		bill+=200; 	
     	
     	if(chkBur.isSelected())
        		bill+=50;
     	
     	lblTotal.setText(String.valueOf(bill));
    }

    @FXML
    private RadioButton dis10;

    

    @FXML
    private RadioButton dis20;
    @FXML
    void doNetBill(ActionEvent event)
    {
    	float dis=0;
    		if(dis10.isSelected()==true)
    		{
    			dis=bill*10/100;
    		}
    		else
    			if(dis20.isSelected()==true)
    		    	
    		{
    			dis=bill*20/100;
    		}	
    		float net=bill-dis;
    		lblNet.setText("Net:"+net);
    }

    @FXML
    void initialize() 
    {
        

    }
}
