package listt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class listComboController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private ListView<String> listt;

    
    @FXML
    private Label lblSelected;

    @FXML
    private ImageView prev;
    
    
    @FXML
    void doSelectPic(ActionEvent event) 
    {
    	FileChooser fc=new FileChooser();
    	fc.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
                );
    		File file=fc.showOpenDialog(null);
    		lblSelected.setText(file.getAbsolutePath());
    		try {
				prev.setImage(new Image(new FileInputStream(file)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    }
    @FXML
    void doDelete(ActionEvent event) 
    {
    	ObservableList<String>lst= listt.getSelectionModel().getSelectedItems();
    	listt.getItems().removeAll(lst);
    }

    @FXML
    void doDelOnClick(MouseEvent event) {
    		int c=event.getClickCount();
    		if(c==2)
    		{
    			int indx= listt.getSelectionModel().getSelectedIndex();
    	    	listt.getItems().remove(indx);
    		}
    }

    @FXML
    void doShow(ActionEvent event) 
    {
    	ObservableList<String>lst= listt.getSelectionModel().getSelectedItems();
    	String all="";
    	for (String string : lst) 
    	{
			all=all+string+",";
		}
    	lblSelected.setText(all.substring(0,all.length()-1));

    }

    @FXML
    void doFill(ActionEvent event) 
    {
    	String item=combo.getSelectionModel().getSelectedItem();
    	int index=combo.getSelectionModel().getSelectedIndex();
    	if(item.equals("Burger"))
    	{
    		listt.getItems().clear();
    		listt.getItems().add("Allo Tikki");
    		listt.getItems().add("Veg Burger");
    		listt.getItems().add("Non-Veg Burger");
    	}
    	else
    	{
    		listt.getItems().clear();
    		listt.getItems().add("Onion Cap.");
    		listt.getItems().add("Farm House");
    		listt.getItems().add("Non-Veg Pizzzzzaa");
    	}
    	
    	
    }
    
    @FXML
    void initialize() 
    {
    	ArrayList<String>items=new ArrayList<>(Arrays.asList("select","Burger","Pizza"));
    	combo.getItems().addAll(items);
    	combo.getSelectionModel().select(0);
    	listt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    }
}
