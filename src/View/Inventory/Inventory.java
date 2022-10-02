package View.Inventory;

import javax.swing.*;

public class Inventory {
    private InventoryView view;
    private InventoryModel model;

    private boolean isActivated = false;
    public Inventory(JPanel viewPanel){
       view = new InventoryView(viewPanel);
        model = new InventoryModel();
        initInv();
    }

    public boolean isActivated(){ return isActivated;}

    public void setActivated(boolean act){ isActivated = act; }

    public void initInv(){
        if(isActivated == true){
            model.showInv();
        }
    }
}
