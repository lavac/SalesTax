package org.tw.salestax;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Init {
    public static void main(String args[]) throws java.lang.Exception {
        {
            org.tw.salestax.Inventory inventory = new org.tw.salestax.Inventory();
            double salesTax = 0.0;
            double total = 0.0;
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            int noOfInputs = Integer.parseInt(inp.readLine());
            for (int i = 0; i < noOfInputs; i++) {
                String itemInfo = inp.readLine();
                String[] lastPart = itemInfo.split(" at ");
                String[] remainingParts = lastPart[0].split(" ");
                double price = Double.parseDouble(lastPart[1]);
                int quantity = Integer.parseInt(remainingParts[0]);
                String itemName = lastPart[0];
                boolean isimported = (itemName.toLowerCase().contains("imported"));
                Item item = new Item(itemName, isimported, price);
                RecieptGenerator generateBill = new RecieptGenerator(item, quantity);
                generateBill.calculateTotalTaxAndTotalBill();
                salesTax = RecieptGenerator.getSalesTax();
                total = RecieptGenerator.getGrandTotal();
                System.out.println(itemInfo + " - " + item.getTotal());
            }
            System.out.println("Salestax -  " + salesTax);
            System.out.println("Total -  " + total);

        }
    }
}
