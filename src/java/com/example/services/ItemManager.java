/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

/**
 *
 * @author user
 */


import com.example.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ItemManager {
    private List<Item> lostItems;
    private List<Item> foundItems;

    public ItemManager() {
        lostItems = new ArrayList<>();
        foundItems = new ArrayList<>();
        
        lostItems.add(new Item(1, "Mouse", "Plush toy mouse with a name 'Squish' on the medallion", "0968856456"));
        lostItems.add(new Item(2, "Hat", "blue-green striped knitted hat with a tassel", "067544876"));
        lostItems.add(new Item(3, "Mouse", "computer office mouse", "067990478"));
        lostItems.add(new Item(4, "Keychain", "silver keychain with a miniature Eiffel Tower pendant", "0987654321"));
        lostItems.add(new Item(5, "Book", "book novel with a red cover titled 'Warriors' by Erin Hunter", "0123456789"));
        lostItems.add(new Item(6, "Water Bottle","a stainless steel water bottle with a blue cap and a small dent on the bottom", "0765888409"));
        lostItems.add(new Item(7, "Keys", "set of keys with a keychain shaped like a dolphin", "0268532750"));

        
        foundItems.add(new Item(8, "Phone Charger","a black USB phone charger with a frayed cable near the connector", "0398007667"));
        foundItems.add(new Item(9, "Jacket", "red waterproof jacket with a hood and a fleece lining","056435295"));
        foundItems.add(new Item(10, "Sunglasses", "aviator-style red sunglasses with mirrored lenses", "0356742399"));
        foundItems.add(new Item(11, "Backpack", "black backpack with multiple compartments", "0986432675"));
        foundItems.add(new Item(12, "Umbrella", "large blue umbrella with a wooden handle", "0345678901"));
        foundItems.add(new Item(13, "Book", "hardcover book novel titled 'My Policeman' by Bethan Roberts", "0965439995"));
        foundItems.add(new Item(14, "Notebook", "spiral-bound notebook with doodles on the cover", "0128500872"));

    }

    public void addLostItem(Item item) {
        lostItems.add(item);
    }

    public void addFoundItem(Item item) {
        foundItems.add(item);
    }

    public List<Item> getLostItems() {
        return lostItems;
    }

    public List<Item> getFoundItems() {
        return foundItems;
    }
    
    public int getLargestId() {
        int largestId = 0;
        for (Item item : lostItems) {
            largestId = Math.max(largestId, item.getId());
        }
        for (Item item : foundItems) {
            largestId = Math.max(largestId, item.getId());
        }
        return largestId;
    }

    public Item getItemById(Integer itemId) {
        for (Item item : lostItems) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        
        for (Item item : foundItems) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
    
    public List<Item> searchLostItems(String searchText) {
        List<Item> searchResults = new ArrayList<>();

        searchResults.addAll(lostItems.stream()
                .filter(item -> item.getName().contains(searchText) || item.getDescription().contains(searchText))
                .collect(Collectors.toList()));

        return searchResults;
    }

    public List<Item> searchFoundItems(String searchText) {
        List<Item> searchResults = new ArrayList<>();

        searchResults.addAll(foundItems.stream()
                .filter(item -> item.getName().contains(searchText) || item.getDescription().contains(searchText))
                .collect(Collectors.toList()));

        return searchResults;
    }
}
