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
}
