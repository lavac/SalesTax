/**
 * Created by lavanya on 6/10/17.
 */
public class BillGenerator {
    static double salesTax;
    static double grandTotal;
    Item item;
    double quantity;
    TaxCalculatorForAnItem taxCalculatorForAnItem;
    BillGenerator(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        taxCalculatorForAnItem = new TaxCalculatorForAnItem(item);
        taxCalculatorForAnItem.calculateTax();
    }
    void calculateTotalTaxAndTotalBill() {
        System.out.print("quantity is" + quantity);
        salesTax += (item.getTax()*quantity);
        grandTotal += item.getTotal()*quantity;
    }

    double getSalesTax() {
        return salesTax;
    }
    double getGrandTotal() {
        return grandTotal;
    }

    public void initiallize() {
        salesTax = 0.0;
        grandTotal = 0.0;
    }
}
