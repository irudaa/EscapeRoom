package Game.Inventory;

import javax.swing.*;
import java.util.ArrayList;

public class Inventory {
    private InventoryView view;
    private InventoryModel model;

    private boolean isActivated = false;

    private ArrayList<Object> isAquired = new ArrayList<>();
    public Inventory(JPanel viewPanel){
       view = new InventoryView(viewPanel);
        model = new InventoryModel();
        initInv();
    }

    public boolean isActivated(){ return isActivated;}

    public ArrayList<Object> getIsAquired(){ return isAquired; }

    public void addIsAquired(Object obj){ isAquired.add(obj); }

    public void setActivated(boolean act){ isActivated = act; }

    public void initInv(){
        if(isActivated == true){
            model.showItem();
        }
    }
}
