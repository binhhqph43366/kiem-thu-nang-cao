package com.example.lab4_advance_testing_binhhqph43366.service;

import com.example.lab4_advance_testing_binhhqph43366.model.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {
    private ItemManager itemManager = new ItemManager();
    private List<Item> items = new ArrayList<>();

    //bài 1
    @Test
    public void testValidIdAndName() {
        assertTrue(itemManager.addItem(new Item(1, "Bình Quốc xinh đẹp")));
    }

    @Test
    public void testValidIdAndOneCharName() {
        assertTrue(itemManager.addItem(new Item(1, "B")));
    }

    @Test
    public void testValidIdAndTwoCharName() {
        assertTrue(itemManager.addItem(new Item(1, "Bì")));
    }

    @Test
    public void testValidIdAnd48CharName() {
        assertTrue(itemManager.addItem(new Item(1, "Christopherson McAllister Vanderburg St. James")));
    }

    @Test
    public void testValidIdAnd49CharName() {
        assertTrue(itemManager.addItem(new Item(1, "Christopherson McAllister Vanderburg St. Jamess")));
    }

    @Test
    public void testValidIdAnd50CharName() {
        assertFalse(itemManager.addItem(new Item(1, "Christopherson McAllister Vanderburg St. Jamesss")));
    }

    @Test
    public void testValidIdAnd51CharName() {
        assertFalse(itemManager.addItem(new Item(1, "Christopherson McAllister Vanderburg St. Jamessss")));
    }

    @Test
    public void testValidIdAnd75CharName() {
        assertFalse(itemManager.addItem(new Item(1, "Alexander Bartholomew Fitzwilliam Montgomery Wellington III")));
    }

    @Test
    public void testInvalidSpecialCharName() {
        assertFalse(itemManager.addItem(new Item(1, "@@^^^$")));
    }

    @Test
    public void testInvalidNumericName() {
        assertFalse(itemManager.addItem(new Item(1, "12345")));
    }



    //Bài 2:
    @Test
    public void testUpdateValidItemWithValidName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "New Name");
        assertEquals("New Name", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWithOneCharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "B");
        assertEquals("B", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWithTwoCharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Bì");
        assertEquals("Bì", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWith48CharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Christopherson McAllister Vanderburg St. James");
        assertEquals("Christopherson McAllister Vanderburg St. James", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWith49CharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Christopherson McAllister Vanderburg St. Jamess");
        assertEquals("Christopherson McAllister Vanderburg St. Jamess", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWith50CharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Christopherson McAllister Vanderburg St. Jamesss");
        assertEquals("Initial Name", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWith51CharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Christopherson McAllister Vanderburg St. Jamessss");
        assertEquals("Initial Name", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWith75CharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "Alexander Bartholomew Fitzwilliam Montgomery Wellington III");
        assertEquals("Initial Name", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWithSpecialCharName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "@@^^^$");
        assertEquals("Initial Name", itemManager.getAllItems().get(0).getName());
    }

    @Test
    public void testUpdateValidItemWithNumericName() {
        itemManager.addItem(new Item(1, "Initial Name"));
        itemManager.updateItem(1, "12345");
        assertEquals("Initial Name", itemManager.getAllItems().get(0).getName());
    }

    //bài 3:
    @Test
    public void testDeleteItemWithNegativeId() {
        assertFalse(itemManager.deleteItem(-1));
    }

    @Test
    public void testDeleteItemWithZeroId() {
        itemManager.addItem(new Item(0, "Item 1"));
        assertTrue(itemManager.deleteItem(0));
    }

    @Test
    public void testDeleteItemWithValidId1() {
        itemManager.addItem(new Item(1, "Item 1"));
        assertTrue(itemManager.deleteItem(1));
        assertEquals(0, itemManager.getAllItems().size());
    }

    @Test
    public void testDeleteItemWithValidId2() {
        itemManager.addItem(new Item(2, "Item 2"));
        assertTrue(itemManager.deleteItem(2));
        assertEquals(0, items.size());
    }

    @Test
    public void testDeleteItemWithValidId5() {
        itemManager.addItem(new Item(5, "Item 5"));
        assertTrue(itemManager.deleteItem(5));
        assertEquals(0, items.size());
    }

    @Test
    public void testDeleteItemWithValidId9() {
        itemManager.addItem(new Item(9, "Item 9"));
        assertTrue(itemManager.deleteItem(9));
        assertEquals(0, items.size());
    }

    @Test
    public void testDeleteItemWithValidId10() {
        itemManager.addItem(new Item(10, "Item 10"));
        assertTrue(itemManager.deleteItem(10));
        assertEquals(0, items.size());
    }

    @Test
    public void testDeleteItemWithIdOutOfRange1() {
        assertFalse(itemManager.deleteItem(11));
    }

    @Test
    public void testDeleteItemWithNegativeOutOfRangeId() {
        assertFalse(itemManager.deleteItem(-50));
    }

    @Test
    public void testDeleteItemWithPositiveOutOfRangeId() {
        assertFalse(itemManager.deleteItem(50));
    }


}