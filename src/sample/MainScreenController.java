package sample;

import backend.ImageAsset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import backend.DAMController;
import backend.Asset;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable{

    DAMController dam = new DAMController();

    @FXML
    private Button uploadBtn;

    @FXML
    private ListView assetList;

    @FXML
    void uploadClicked(ActionEvent event) {
        FileChooser fc = new FileChooser();
        //fc.setInitialDirectory("");
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null){
            Image img = new Image(selectedFile.toURI().toString());
            String name = selectedFile.getName();
            addItem(name, img);
        }else{
            System.out.print("File is not valid");
        }
    }

    public void addItem(String string, Image pic){
        Image img = pic;
        String name = string;
        Asset asset = new Asset(img,name);
        ImageView imgView = new ImageView(img);
        Text text = new Text(name);
        dam.uploadAsset2(asset);
        imgView.setFitWidth(70);
        imgView.setFitHeight(50);
        MenuButton mb = new MenuButton();
        ContextMenu contextMenu = new ContextMenu();
        mb.setText("Select option");
        MenuItem view = new MenuItem();
        view.setText("View");
        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openViewAssetPage(img,name);
            }
        });
        MenuItem tag = new MenuItem();
        tag.setText("Tag");
        tag.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Asset foundAsset = dam.findAsset(name);
                tagClicked(foundAsset);
            }
        });
        mb.getItems().addAll(view,tag);
        Pane pane1 = new Pane();
        pane1.setPrefSize(100,50);
        Pane pane2 = new Pane();
        pane2.setPrefSize(100,50);
        HBox hbox = new HBox(imgView,pane1, text,pane2,mb);
        assetList.getItems().add(hbox);


    }

    public void openViewAssetPage(Image pic, String name){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("viewAssetScreen.fxml")));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Fisher");
            stage.setScene(new Scene(root, 600, 500));
            stage.show();

        }catch(Exception e){
            System.out.println("can't load new window");
        }

        ViewAssetScreenController viewAsset = loader.getController();
        viewAsset.initData(pic,name);

    }

    void tagClicked(Asset tagAsset) {

        if(tagAsset instanceof ImageAsset){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("tagImageScreen.fxml"));
            try{
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Fisher");
                stage.setScene(new Scene(root,650,500));
                stage.show();

            }catch(Exception e){

            }
            ImageAsset asset = (ImageAsset) dam.findAsset(tagAsset.getName());
            TagImageScreenController tagImage = loader.getController();
            tagImage.initData(asset,dam);
        }else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation((getClass().getResource("setFileTypeScreen.fxml")));
            try {
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Fisher");
                stage.setScene(new Scene(root, 650, 500));
                stage.show();

            } catch (Exception e) {
                System.out.println("can't load new window");
            }
            Asset asset = tagAsset;
            setFileTypeScreenController setFileType = loader.getController();
            setFileType.setAsset(asset);
            setFileType.setDam(dam);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

