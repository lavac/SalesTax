import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void taxShouldBeZeroForFoodAndNonImportedItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("chocalate", false, 10);
        TaxCalculatorForAnItem taxCalculation = new TaxCalculatorForAnItem(item);
        double expectedTax = 0.0;
        assertEquals(expectedTax,taxCalculation.calculateTax());
    }
    @Test
    public void taxShouldBeTenPercentOfThePriceForNonImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("dress", false, 2000);
        TaxCalculatorForAnItem taxCalculation = new TaxCalculatorForAnItem(item);
        double expectedTax = 200.0;
        assertEquals(expectedTax,taxCalculation.calculateTax());
    }

    @Test
    public void taxShouldBeFivePerceentOfThePriceForAnImportedbook() {
        Inventory inventory = new Inventory();
        Item item = new Item("book", true, 500);
        TaxCalculatorForAnItem taxCalculation = new TaxCalculatorForAnItem(item);
        double expectedTax = 25.0;
        assertEquals(expectedTax,taxCalculation.calculateTax());
    }

    @Test
    public void taxShouldBeFifteenPerceentOfThePriceForAnImportedAndTaxableItem() {
        Inventory inventory = new Inventory();
        Item item = new Item("iphone", true, 50000);
        TaxCalculatorForAnItem taxCalculation = new TaxCalculatorForAnItem(item);
        double expectedTax = 7500.0;
        assertEquals(expectedTax,taxCalculation.calculateTax());
    }


}
