
package LoginForm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SecondPageFXMLController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void introButton(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPageFXML.fxml"));
            root = loader.load();
         
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
    public void toStudentLogin(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThirdPageStudentFXML.fxml"));
            root = loader.load();
         
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
    public void toLibrarianLogin(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThirdPageLibrarianLoginFXML.fxml"));
            root = loader.load();
         
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
