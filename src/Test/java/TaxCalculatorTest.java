import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void taxShouldBeZeroForFoodAndNonImportedItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("chocalate", false, 10);
        BillGenerator generateBill = new BillGenerator(item, 2);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 0.0;
        double grandTotal = 20.0;
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());
        
    }

    @Test
    public void taxShouldBeTenPercentOfThePriceForNonImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("dress", false, 2000);
        BillGenerator generateBill = new BillGenerator(item, 2);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 400.0;
        double grandTotal = 4400.0;
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());
    }

    @Test
    public void taxShouldBeFivePerceentOfThePriceForAnImportedbook() {
        Inventory inventory = new Inventory();
        Item item = new Item("book", true, 500);
        BillGenerator generateBill = new BillGenerator(item, 3);
        generateBill.initiallize();
        double expectedTax = 75.0;
        double grandTotal = 1575.0;
        generateBill.calculateTotalTaxAndTotalBill();
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());
    }

    @Test
    public void taxShouldBeFifteenPerceentOfThePriceForAnImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("iphone", true, 50000);
        BillGenerator generateBill = new BillGenerator(item, 3);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 22500.0;
        double grandTotal = 172500.0;
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());

    }
}
