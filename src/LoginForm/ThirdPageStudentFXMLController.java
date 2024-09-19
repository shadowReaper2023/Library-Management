
package LoginForm;

import JDBC.DatabaseConnection;
import java.sql.Connection;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ThirdPageStudentFXMLController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button studentLoginButton;

    @FXML
    private PasswordField studentPassword;

    @FXML
    private TextField studentUsername;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    } 
    public void loginStudent(ActionEvent event){
        String username = studentUsername.getText();
        String password = studentPassword.getText();
        
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.connect();

        // Check if the connection was successful
        String checkStudentAccount = "SELECT * FROM login WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(checkStudentAccount);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // Load the new scene only if the login is successful
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FourthPageStudentLoginFXML.fxml"));
                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Student Account");
                alert.setHeaderText(null);
                alert.setContentText("No account found!");

                alert.showAndWait();
                
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ThirdPageStudentFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
