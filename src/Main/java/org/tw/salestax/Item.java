package org.tw.salestax;
class Item {
    private String item_name;
    private boolean isImported;
    private boolean isTaxExempted;
    double price;
    private double tax;
    private Inventory inventory;

    Item(String item_name, boolean isImported, double price) {
        inventory = new Inventory();
        this.item_name = item_name;
        this.isImported = isImported;
        this.price = price;
        isTaxExempted = inventory.isTaxExempted(this.item_name);
    }

    boolean isTaxExempted() {
        return isTaxExempted;
    }

    boolean isImported() {
        return isImported;
    }

    void setTax(double tax) {
        this.tax = tax;
    }

    double getTax() {
        return tax;
    }

    double getTotal() {
        return Math.round((price + tax) * 20.0) / 20.0;
    }
}
