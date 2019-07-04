package backend;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class DAMController {

    public ArrayList<Asset> assetList;

    public DAMController(){
        assetList = new ArrayList<Asset>();
    }

    public void uploadAsset(Image img, String name){
        Asset newAsset = new Asset(img, name);
        assetList.add(newAsset);
    }
    public Asset findAsset(String name){
        for(int i =0; i<assetList.size();i++){
            Asset currentAsset = assetList.get(i);
            if(currentAsset.getName()==name){
                return currentAsset;
            }
        }
        return null;
    }


    public void addImageAsset(String name){
        Asset asset = findAsset(name);
        Image assetImg = asset.getImg();
        String assetName = asset.getName();
        assetList.remove(asset);
        ImageAsset imageAsset = new ImageAsset(assetImg, assetName);
        assetList.add(imageAsset);
    }
    public void tagAsset (Image img, String name, String type, ArrayList<String> products, String description){
        ImageAsset asset = (ImageAsset) findAsset(name);
        asset.setType(type);
        asset.setProduct(products);
        asset.setDescription(description);
    }

}
