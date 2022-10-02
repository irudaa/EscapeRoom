package View.Inventory;

public class Inventory {
    private InventoryView view;
    private InventoryModel model;

    private boolean isActivated = false;
    public Inventory(){
        view = new InventoryView();
        model = new InventoryModel();
        initInv();
    }

    public boolean isActivated(){ return isActivated;}

    public void initInv(){
        if(isActivated == true){

        }
    }
}
