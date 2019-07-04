package sample;
        import backend.ImageAsset;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuButton;
        import javafx.scene.image.ImageView;

        import javafx.event.ActionEvent;
        import javafx.scene.control.MenuItem;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

        import backend.DAMController;
        import backend.Asset;

        import java.net.URL;
        import java.util.ResourceBundle;


public class MainScreenController implements Initializable {

    ViewAssetScreenController assetScreen = new ViewAssetScreenController();

    MenuItem menuItem1 = new MenuItem("Tag");
    MenuItem menuItem2 = new MenuItem ("View");
    MenuButton menuButton = new MenuButton("options",null ,menuItem1,menuItem2);
    DAMController dam = new DAMController();

    @FXML
    private Button uploadBtn;

    @FXML
    private MenuButton hammer_menu_button;

    @FXML
    private ImageView main_screen_hammer;

    @FXML
    private MenuButton saw_menu_btn;

    @FXML
    private MenuButton hammering_nail_menu_btn;

    @FXML
    private MenuButton screwdriver_menu_btn;

    @FXML
    private MenuButton wrench_menu_btn;

    public void openViewAssetPage(Image pic, String name){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("viewAssetScreen.fxml")));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Hello World");
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
                stage.setTitle("Hello World");
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
                stage.setTitle("Hello World");
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

    void tagClickedImage(ImageAsset imageAsset){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tagImageScreen.fxml"));
        try{
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root,650,500));
            stage.show();

        }catch(Exception e){

        }
        ImageAsset asset = imageAsset;
        TagImageScreenController tagImage = loader.getController();
        tagImage.initData(asset,dam);
    }


    @FXML
    void viewHammerClicked(ActionEvent event)  {
        String name = "hammer.jpg";
        Asset asset = dam.findAsset(name);
        Image pic = asset.getImg();
        openViewAssetPage(pic,name);

    }

    @FXML
    void viewScrewDriverClicked(ActionEvent event) {
        String name = "screwdriver.jpg";
        Asset asset = dam.findAsset(name);
        Image pic = asset.getImg();
        openViewAssetPage(pic,name);
    }

    @FXML
    void viewWrenchClicked(ActionEvent event) {
        String name = "wrench.jpg";
        Asset asset = dam.findAsset(name);
        Image pic = asset.getImg();
        openViewAssetPage(pic,name);
    }

    @FXML
    void viewSawClicked(ActionEvent event) {
        String name = "saw.jpg";
        Asset asset = dam.findAsset(name);
        Image pic = asset.getImg();
        openViewAssetPage(pic,name);
    }

    @FXML
    void viewHammeringNailClicked(ActionEvent event) {
        String name = "hammering_nail.jpg";
        Asset asset = dam.findAsset(name);
        Image pic = asset.getImg();
        openViewAssetPage(pic,name);
    }

    @FXML
    void tagHammerClicked(ActionEvent event) {
        Asset asset = dam.findAsset("hammer.jpg");
        tagClicked(asset);

    }

    @FXML
    void tagScrewDriverClicked(ActionEvent event) {
        Asset asset = dam.findAsset("screwdriver.jpg");
        tagClicked(asset);
    }

    @FXML
    void tagWrenchClicked(ActionEvent event) {
        Asset asset = dam.findAsset("wrench.jpg");
        tagClicked(asset);
    }

    @FXML
    void tagSawClicked(ActionEvent event) {
        Asset asset = dam.findAsset("saw.jpg");
        tagClicked(asset);
    }

    @FXML
    void tagHammeringNailClicked(ActionEvent event) {
        Asset asset = dam.findAsset("hammering_nail.jpg");
        tagClicked(asset);
    }

    @FXML
    void uploadClicked(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            Image hammer = new Image("sample/hammer.jpg");
            Image screwDriver = new Image ("sample/screwdriver.jpg");
            Image wrench = new Image("sample/wrench.jpg");
            Image saw = new Image("sample/saw.jpg");
            Image hammeringNail = new Image ("sample/hammering_nail.jpg");

            dam.uploadAsset(hammer,"hammer.jpg");
            dam.uploadAsset(screwDriver,"screwdriver.jpg");
            dam.uploadAsset(wrench,"wrench.jpg");
            dam.uploadAsset(saw,"saw.jpg");
            dam.uploadAsset(hammeringNail,"hammering_nail.jpg");

    }

    public void initData(DAMController dam){
        this.dam = dam;
    }

}
