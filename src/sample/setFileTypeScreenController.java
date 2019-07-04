package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import backend.Asset;
import backend.ImageAsset;
import backend.DAMController;

public class setFileTypeScreenController {

    String assetType = "";
    Image pic;
    Asset asset;
    DAMController dam;
    ImageAsset imageAsset;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private SplitMenuButton select_file_type_btn;

    @FXML
    private Button set_file_next_btn;

    @FXML
    private Button set_file_back_btn;

    @FXML
    void imageSelected(ActionEvent event) {
        select_file_type_btn.setText("Image");
        assetType = "image";
    }

    @FXML
    void documentSelected(ActionEvent event) {
        select_file_type_btn.setText("Document");
        assetType = "document";
    }

    @FXML
    void videoSelected(ActionEvent event) {
        select_file_type_btn.setText("Video");
        assetType = "video";
    }

    public void addImageAsset(){
        String assetName = asset.getName();
        dam.addImageAsset(assetName);
        imageAsset = (ImageAsset) dam.findAsset(assetName);
    }

    @FXML
    void nextClicked(ActionEvent event) throws Exception {

        if(assetType == "image") {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("tagImageScreen.fxml"));

            addImageAsset();

            AnchorPane pane = loader.load();
            rootPane.getChildren().setAll(pane);
            TagImageScreenController tagImage = loader.getController();
            tagImage.initData(imageAsset, dam);
        }
    }

    @FXML
    void backBtnClicked(ActionEvent event) {
        Stage stage = (Stage) set_file_back_btn.getScene().getWindow();
        stage.close();
    }

    public void setAsset(Asset asset){

        this.asset = asset;
    }

    public void setDam(DAMController dam){
        this.dam = dam;
    }

}
