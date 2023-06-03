/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;


/**
 *
 * @author user
 */
import com.example.model.ExpItem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpItemManager {
    private List<ExpItem> explostItems;
    private List<ExpItem> expfoundItems;

    public ExpItemManager() {
        explostItems = new ArrayList<>();
        expfoundItems = new ArrayList<>();
        
        explostItems.add(new ExpItem(15, "Wallet", "brown leather wallet containing identification cards", "0345674567"));
        explostItems.add(new ExpItem(16, "Laptop", "silver laptop with a skateboard sticker on the back", "0128542312"));
        explostItems.add(new ExpItem(17, "Wallet", "black leather wallet with multiple compartments", "0679988658"));
        explostItems.add(new ExpItem(18, "Sunglasses", "designer sunglasses with round polarized lenses", "0345674567"));
        explostItems.add(new ExpItem(19, "Bracelet", "silver bracelet with intricate engravings", "0679904779"));
        explostItems.add(new ExpItem(20, "Briefcase", "rainbow multi-compartment briefcase with 'Anna' signature notebook inside", "0679909478"));
        explostItems.add(new ExpItem(21, "Headphones", "black wireless headphones with noise-cancelling feature", "0679904072"));
        
        expfoundItems.add(new ExpItem(22, "Watch", "silver wristwatch with a black leather strap", "0268532750"));
        expfoundItems.add(new ExpItem(23, "Camera", "digital camera 'Nikon' with a detachable lens", "0981234563"));
        expfoundItems.add(new ExpItem(24, "Phone", "black smartphone 'Samsung' with a bit cracked screen", "0765432109"));
        expfoundItems.add(new ExpItem(25, "Earrings", "diamond earrings with a white gold setting", "0643592134"));
        expfoundItems.add(new ExpItem(26, "Guitar", "acoustic guitar with a natural wood finish and a soft case", "0865381124"));
        expfoundItems.add(new ExpItem(27, "Watch", "rose gold wristwatch with a brown leather strap", "0869955246"));
        expfoundItems.add(new ExpItem(28, "Handbag", "designer handbag in black leather with gold hardware", "0982276515"));
    }

    public List<ExpItem> getExpLostItems() {
        return explostItems;
    }

    public List<ExpItem> getExpFoundItems() {
        return expfoundItems;
    }
    
    public void addExpLostItem(ExpItem expitem) {
        explostItems.add(expitem);
    }

    public void addExpFoundItem(ExpItem expitem) {
        expfoundItems.add(expitem);
    }
    
    public void deleteExpItem(Integer expitemId) {
        for (ExpItem expitem : explostItems) {
            if (expitem.getId().equals(expitemId)) {
                explostItems.remove(expitem);
                return;
            }
        }

        for (ExpItem expitem : expfoundItems) {
            if (expitem.getId().equals(expitemId)) {
                expfoundItems.remove(expitem);
                return;
            }
        }
    }
    
    public int getLargestId() {
        int largestId = 0;
        for (ExpItem expItem : explostItems) {
            largestId = Math.max(largestId, expItem.getId());
        }
        for (ExpItem expItem : expfoundItems) {
            largestId = Math.max(largestId, expItem.getId());
        }
        return largestId;
    }

    public ExpItem getExpItemById(Integer expitemId) {
        for (ExpItem expitem : explostItems) {
            if (expitem.getId().equals(expitemId)) {
                return expitem;
            }
        }

        for (ExpItem expitem : expfoundItems) {
            if (expitem.getId().equals(expitemId)) {
                return expitem;
            }
        }
        return null;
    }

    public List<ExpItem> searchExpLostItems(String searchText) {
    List<ExpItem> searchResults = new ArrayList<>();
    
    searchResults.addAll(explostItems.stream()
            .filter(item -> item.getName().contains(searchText) || item.getDescription().contains(searchText))
            .collect(Collectors.toList()));

    return searchResults;
}

public List<ExpItem> searchExpFoundItems(String searchText) {
    List<ExpItem> searchResults = new ArrayList<>();
    
    searchResults.addAll(expfoundItems.stream()
            .filter(item -> item.getName().contains(searchText) || item.getDescription().contains(searchText))
            .collect(Collectors.toList()));

    return searchResults;
}

}

