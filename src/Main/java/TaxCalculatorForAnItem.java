/**
 * Created by lavanya on 6/10/17.
 */
public class TaxCalculatorForAnItem {

    Item item;
    double tax = 0;
    TaxCalculatorForAnItem(Item item) {
        this.item = item;
    }

    void calculateTax() {
        if(item.isImported())
            tax += item.price*0.05;
        if(!item.isTaxExempted()) {
            tax += item.price*0.1;
        }
        item.setTax(tax);
    }

}
