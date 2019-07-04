package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import backend.ImageAsset;
import backend.DAMController;

import backend.ImageAsset;

public class TagImageScreenController implements Initializable {

    private String assetType = "";
    private boolean mpi = false;
    private ImageAsset imageAsset;
    private DAMController dam;
    private ArrayList<String> assetProducts = new ArrayList<>();
    ObservableList list = FXCollections.observableArrayList();
    private int selectedIndex = -1;
    private String description = "";

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ListView<?> productList;

    @FXML
    private MenuButton productBtn;

    @FXML
    private CheckBox mpiCheckBox;

    @FXML
    private MenuButton typeBtn;

    @FXML
    private Button changeFileTypeBtn;

    @FXML
    private Text type;

    @FXML
    private ImageView picture;

    @FXML
    private Button removeProductBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Text assetName;

    @FXML
    private TextArea descriptionBox;


//Image type menu button
    @FXML
    void productClicked(ActionEvent event) {
        assetType = "Product";
        typeBtn.setText("Product");
    }

    @FXML
    void illustrationClicked(ActionEvent event) {
        assetType = "Illustration";
        typeBtn.setText("Illustration");
    }

    @FXML
    void usageClicked(ActionEvent event) {
        assetType = "Usage";
        typeBtn.setText("Usage");
    }

    @FXML
    void packagingClicked(ActionEvent event) {
        assetType = "Packaging";
        typeBtn.setText("Packaging");
    }

    @FXML
    void logoClicked(ActionEvent event) {
        assetType = "Logo";
        typeBtn.setText("Logo");
    }

    @FXML
    void noneClicked(ActionEvent event) {
        assetType = "";
        typeBtn.setText("Type:");
    }
//Product menu button
    @FXML
    void hammerClicked(ActionEvent event) {
        if (!list.contains("Hammer")) {
            list.add("Hammer");
            assetProducts.add("Hammer");
        }

    }

    @FXML
    void screwDriverClicked(ActionEvent event) {
        if(!list.contains("Screw Driver")) {
            list.add("Screw Driver");
            assetProducts.add("Screw Driver");
        }
    }

    @FXML
    void wrenchClicked(ActionEvent event) {
        if(!list.contains("Wrench")){
            list.add("Wrench");
            assetProducts.add("Wrench");
        }
    }

    @FXML
    void drillClicked(ActionEvent event) {
        if(!list.contains("Drill")){
            list.add("Drill");
            assetProducts.add("Drill");
        }
    }

    @FXML
    void pliersClicked(ActionEvent event) {
        if(!list.contains("Pliers")){
            list.add("Pliers");
            assetProducts.add("Pliers");
        }
    }

    @FXML
    void sawClicked(ActionEvent event) {
        if (!list.contains("Saw")){
            list.add("Saw");
            assetProducts.add("Saw");
        }
    }

    @FXML
    void mpiChecked(ActionEvent event) {
        if(mpiCheckBox.isSelected()){
            mpi = true;
        }else{
            mpi = false;
        }

    }

    @FXML
    void changeFileTypeBtnClicked(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("setFileTypeScreen.fxml"));
        AnchorPane pane = loader.load();
        rootPane.getChildren().setAll(pane);

        setFileTypeScreenController setFileType = loader.getController();
        setFileType.setAsset(imageAsset);
        setFileType.setDam(dam);
    }

    @FXML
    void saveBtnClicked(ActionEvent event) {
        imageAsset.setType(assetType);
        imageAsset.setProduct(assetProducts);
        imageAsset.setMpi(mpi);
        description = descriptionBox.getText();
        imageAsset.setDescription(description);
    }

    @FXML
    void removeProductBtnClicked(ActionEvent event) {
        if(!list.isEmpty()) {
            selectedIndex = productList.getSelectionModel().getSelectedIndex();
            if(selectedIndex>-1) {
                list.remove(selectedIndex);
                assetProducts.remove(selectedIndex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productList.setItems(list);

    }

    public void initData(ImageAsset imageAsset, DAMController dam){
        this.imageAsset = imageAsset;
        this.dam = dam;
        picture.setImage(this.imageAsset.getImg());
        if(imageAsset.getType()==""){
            typeBtn.setText("Type:");
        }else {
            typeBtn.setText(imageAsset.getType());
        }

        for (int i = 0; i < imageAsset.getProducts().size(); i++) {
            String product = imageAsset.getProducts().get(i);
            list.add(product);
            assetProducts.add(product);
        }
        assetName.setText(imageAsset.getName());
        mpiCheckBox.setSelected(imageAsset.getMpi());
        descriptionBox.setText(imageAsset.getDescription());
    }

}
