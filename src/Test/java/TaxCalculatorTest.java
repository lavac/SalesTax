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
    public void taxShouldBeFivePerceentOfThePriceForAnImportedbook() {
        Inventory inventory = new Inventory();
        Item item = new Item("book", true, 500);
        TaxCalculatorForAnItem taxCalculation = new TaxCalculatorForAnItem(item);
        double expectedTax = 25.0;
        assertEquals(expectedTax,taxCalculation.calculateTax());
    }

    

}
