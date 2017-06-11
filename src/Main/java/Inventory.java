import java.util.HashMap;
import java.util.Map;

public class Inventory {
    static final Map<String, String> taxExemptedItems = new HashMap<>();

    Inventory() {
        createInventoryList();
    }

    void createInventoryList() {
        taxExemptedItems.put("chocolate", "Food");
        taxExemptedItems.put("pills", "Medicine");
        taxExemptedItems.put("book", "Book");
    }

    public boolean isTaxExempted(String item_name) {
        for (String item : taxExemptedItems.keySet()) {
            if (item_name.toLowerCase().contains(item.toLowerCase()))
                return true;
        }
        return false;
    }
}