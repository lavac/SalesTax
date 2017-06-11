class BillGenerator {
    private static double salesTax;
    private static double grandTotal;
    private Item item;
    private double quantity;
    private TaxCalculatorForAnItem taxCalculatorForAnItem;

    void initiallize() {
        salesTax = 0.0;
        grandTotal = 0.0;
    }

    BillGenerator(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        taxCalculatorForAnItem = new TaxCalculatorForAnItem(item);
        taxCalculatorForAnItem.calculateTax();
    }

    void calculateTotalTaxAndTotalBill() {
        salesTax += (item.getTax() * quantity);
        grandTotal += item.getTotal() * quantity;
    }

    static double getSalesTax() {
        return Math.round(salesTax * 100.0) / 100.0;
    }

    static double getGrandTotal() {
        return Math.round(grandTotal * 100.0) / 100.0;
    }
}
