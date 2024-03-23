package com.example.lab4_advance_testing_binhhqph43366.service;

import com.example.lab4_advance_testing_binhhqph43366.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public List<Item> getAllItems() {
        return items;
    }

    public void updateItem(int id, String newName) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(newName);
                break;
            }
        }
    }

    public boolean deleteItem(int id) {
        if (id >= 0 && id <= 10) {
            items.removeIf(item -> item.getId() == id);
            return true;
        }
        return false;
    }
}
