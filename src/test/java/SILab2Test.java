import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void everyBranchTest() {

        //RuntimeException("allItems list can't be null!");
        //List<Item> allItems=null
        RuntimeException exc;
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 120));
        assertTrue(exc.getMessage().contains("allItems list can't be null!"));

        //RuntimeException("Invalid character in item barcode!");
        //allItems = [Item("item", "012A", 150, 0)], payment = 120
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item", "012A", 150, 0));
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 120));
        assertTrue(exc.getMessage().contains("Invalid character in item barcode!"));

        //RuntimeException("No barcode!");
        //allItems = [Item("item", null, 150, 0)], payment = 120
        allItems.clear();
        allItems.add(new Item("item", null, 150, 0));
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 120));
        assertTrue(exc.getMessage().contains("No barcode!"));

        //allitems=[Item(null,046,450, 10)], payment 120
        //return false
        allItems.clear();
        allItems.add(new Item(null, "046", 450, 0.5F));
        assertFalse(SILab2.checkCart(allItems, 120));

        //return true
        //allitems=[Item(null,046,95, 10)], payment 120
        allItems.clear();
        allItems.add(new Item(null, "046", 95, 0));
        assertTrue(SILab2.checkCart(allItems, 120));
            }

    @Test
    void multipleConditionTest() {

        ArrayList<Item> allItems = new ArrayList<>();

        //if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')

        //TTT
        allItems.add(new Item("item", "046", 350, 0.1F));
        assertTrue(SILab2.checkCart(allItems, 500));

        //TTF
        allItems.clear();
        allItems.add(new Item("item", "146", 350, 0.1F));
        assertTrue(SILab2.checkCart(allItems, 500));

        //TFX
        allItems.clear();
        allItems.add(new Item("item", "046", 350, 0));
        assertTrue(SILab2.checkCart(allItems, 500));

        //FXX
        allItems.clear();
        allItems.add(new Item("item", "046", 100, 0.1F));
        assertTrue(SILab2.checkCart(allItems, 500));

    }
}
