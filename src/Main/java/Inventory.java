import java.util.HashMap;
import java.util.Map;

/**
 * Created by lavanya on 6/10/17.
 */
public class Inventory {
    static final Map<String, String> taxExemptedItems = new HashMap<>();
    Inventory() {
        createInventoryList();
    }
     void createInventoryList() {
        taxExemptedItems.put("chocolate", "Food");
        taxExemptedItems.put("Rice", "Food");
        taxExemptedItems.put("Tablet", "Medicine");
        taxExemptedItems.put("book", "Book");
    }


}
