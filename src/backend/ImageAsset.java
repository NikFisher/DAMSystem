package backend;

import backend.Asset;
import javafx.scene.image.Image;

public class ImageAsset extends Asset {

   boolean mpi = false;

   public ImageAsset(Image img, String name){
        super(img, name);
    }

    public boolean getMpi() {
        return mpi;
    }

    public void setMpi(boolean mpi) {
        this.mpi = mpi;
    }
}
