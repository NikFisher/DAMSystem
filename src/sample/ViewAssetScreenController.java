package sample;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ViewAssetScreenController{


    @FXML
    private Button backBtn;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Text assetName;

    /*public void setImage (Image img){
        image.setImage(img);
    }*/

    @FXML
    void backBtnClicked(ActionEvent event) {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }

    public void initData (Image img, String name){

        image.setImage(img);
        assetName.setText(name);
    }


}
