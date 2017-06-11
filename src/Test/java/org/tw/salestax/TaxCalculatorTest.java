package org.tw.salestax;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void taxShouldBeZeroForFoodAndNonImportedItem() {
        Inventory inventory = new Inventory();
        String input = "2 chocolate at 10.0";
        String[] lastPart = input.split(" at ");
        String[] remainingParts = input.split(" ");
        System.out.println("double is " + lastPart[0]);
        double price = Double.parseDouble(lastPart[1]);
        int quantity = Integer.parseInt(remainingParts[0]);
        String itemName = remainingParts[1];
        System.out.println("namr is  " + itemName + "price is  " + price + " quantity is " + quantity);
        Item item = new Item(itemName, false, price);
        RecieptGenerator generateBill = new RecieptGenerator(item, quantity);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 0.0;
        double grandTotal = 20.0;
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }

    @Test
    public void taxShouldBeTenPercentOfThePriceForNonImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("dress", false, 2000);
        RecieptGenerator generateBill = new RecieptGenerator(item, 2);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 400.0;
        double grandTotal = 4400.0;
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }

    @Test
    public void taxShouldBeFivePerceentOfThePriceForAnImportedbook() {
        Inventory inventory = new Inventory();
        Item item = new Item("book", true, 500);
        RecieptGenerator generateBill = new RecieptGenerator(item, 3);
        generateBill.initiallize();
        double expectedTax = 75.0;
        double grandTotal = 1575.0;
        generateBill.calculateTotalTaxAndTotalBill();
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }

    @Test
    public void taxShouldBeFifteenPerceentOfThePriceForAnImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("iphone", true, 50000);
        RecieptGenerator generateBill = new RecieptGenerator(item, 1);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 7500.0;
        double grandTotal = 57500.0;
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }

    @Test
    public void taxAndTotalValueShouldBeIncreasedByThreeForthreeSameItems() {
        Inventory inventory = new Inventory();
        Item item = new Item("iphone", true, 50000);
        RecieptGenerator generateBill = new RecieptGenerator(item, 3);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        double expectedTax = 22500.0;
        double grandTotal = 172500.0;
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }

    @Test
    public void totalTaxOfdiffrentItemsShouldBeSumOfTaxOfAllTheItems() {
        Inventory inventory = new Inventory();
        Item itemOne = new Item("iphone", true, 50000);
        Item itemTwo = new Item("chocolate", true, 500);
        RecieptGenerator generateBill = new RecieptGenerator(itemOne, 3);
        generateBill.initiallize();
        generateBill.calculateTotalTaxAndTotalBill();
        RecieptGenerator generateBillTwo = new RecieptGenerator(itemTwo, 3);
        generateBillTwo.calculateTotalTaxAndTotalBill();
        double expectedTax = 22575.0;
        double grandTotal = 174075.0;
        assertEquals(expectedTax, RecieptGenerator.getSalesTax());
        assertEquals(grandTotal, RecieptGenerator.getGrandTotal());
    }
}
