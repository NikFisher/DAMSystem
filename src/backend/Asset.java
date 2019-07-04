package backend;

import javafx.scene.image.Image;

import java.util.ArrayList;



public class Asset {
    private String name;
    private String type = "";
    private ArrayList <String> products;
    private String description;
    private Image img;

    public Asset(Image img, String name){
        this.description = "";
        this.products = new ArrayList<>();
        this.img = img;
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String newType){
        this.type = newType;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProduct(ArrayList<String> products) {

        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImg(){
        return img;
    }

    public String getName(){
        return this.name;
    }

}
