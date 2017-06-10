/**
 * Created by lavanya on 6/10/17.
 */
public class Item {
    String item_name;
    boolean isImported;
    boolean isTaxExempted;
    double price;

    Item(String item_name, boolean isImported, int price) {
        this.item_name = item_name;
        this.isImported = isImported;
        this.price = price;
        isTaxExempted = Inventory.taxExemptedItems.containsKey(item_name);
    }
    Inventory inventory = new Inventory();

    boolean isTaxExempted() {
        return isTaxExempted;
    }

    boolean isImported() {
        return isImported;
    }

}
