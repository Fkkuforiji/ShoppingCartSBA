

package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

    private HashMap<String, Item> ItemCollection;


    public TheSystem() {
        ItemCollection = new HashMap<>();
        if (getClass().getSimpleName().equals("AppSystem")) {
            try {
                File myItems = new File("resources/sample.txt");
                Scanner myReader = new Scanner(myItems);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] itemInfo = data.split("\\s ");
                    System.out.println(data);
                    Item item = new Item(itemInfo[0], itemInfo[1],
                            Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]));
                    ItemCollection.put(itemInfo[0], item);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }


    public HashMap<String, Item> getItemCollection() {
        return ItemCollection;
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.ItemCollection = itemCollection;
    }

    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add " + item.getItemName() + " to the cart." +
                    "System only has" + item.getAvailableQuantity() + " of " + item.getItemName() + ".");
            //Should it be check availablity or getavailabilityquanity? error with getAvailability
            return false;
        } else {
            return true;
        }
    }


    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (ItemCollection.containsKey(item.getItemName())) {
            item.setQuantity(item.getQuantity() + 1);
            return true;
        } else if (!ItemCollection.containsKey(item.getItemName())) {
            ItemCollection.put(item.getItemName(), item);
            return true;
        } else {
            return false;
        }
    }


    public Item remove(String ItemName) {
        if (ItemCollection.containsKey(ItemName)) {
            return ItemCollection.remove(ItemName);
        } else {
            return null;
        }
    }

    public abstract void display();
}
