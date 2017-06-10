/**
 * Created by lavanya on 6/10/17.
 */
public class Item {
    String item_name;
    boolean isImported;
    boolean isTaxExempted;
    double price;
    double tax;
    Inventory inventory;

    Item(String item_name, boolean isImported, int price) {
        inventory = new Inventory();
        this.item_name = item_name;
        this.isImported = isImported;
        this.price = price;
        isTaxExempted = Inventory.taxExemptedItems.containsKey(item_name);
    }

    boolean isTaxExempted() {
        System.out.print("tax exempted" + isTaxExempted);
        return isTaxExempted;
    }

    boolean isImported() {
        return isImported;
    }

    void setTax(double tax) {
        System.out.print("tax is" + tax);
        this.tax = tax;
    }

    double getTax() {
        System.out.print(" getting tax is" + tax);
        return tax;
    }

    public double getTotal() {
        return (price + tax);
    }
}
