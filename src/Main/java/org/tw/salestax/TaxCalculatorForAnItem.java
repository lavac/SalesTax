package org.tw.salestax;
class TaxCalculatorForAnItem {
    private Item item;
    private double tax = 0;

    TaxCalculatorForAnItem(Item item) {
        this.item = item;
    }

    void calculateTax() {
        if (item.isImported())
            tax += item.price * 0.05;
        if (!item.isTaxExempted()) {
            System.out.print("tax expeted");
            tax += item.price * 0.1;
        }
        item.setTax(Math.round(tax * 20.0) / 20.0);
    }
}
