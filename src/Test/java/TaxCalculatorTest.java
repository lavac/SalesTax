import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void taxShouldBeZeroForFoodAndNonImportedItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("chocolate", false, 10);
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
        BillGenerator generateBill = new BillGenerator(item, 1);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 7500.0;
        double grandTotal = 57500.0;
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());
    }

    @Test
    public void taxAndTotalValueShouldBeIncreasedByThreeForthreeSameItems() {
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

    @Test
    public void totalTaxOfdiffrentItemsShouldBeSumOfTaxOfAllTheItems() {
        Inventory inventory = new Inventory();
        Item itemOne = new Item("iphone", true, 50000);
        Item itemTwo = new Item("chocolate", true, 500);
        BillGenerator generateBill = new BillGenerator(itemOne, 3);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        BillGenerator generateBillTwo = new BillGenerator(itemTwo,3);
        generateBillTwo.calculateTotalTaxAndTotalBill();
        double expectedTax = 22575.0;
        double grandTotal = 174075.0;
        assertEquals(expectedTax,generateBill.getSalesTax());
        assertEquals(grandTotal,generateBill.getGrandTotal());

    }
}
