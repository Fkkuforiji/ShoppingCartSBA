package com.example;

public class AppSystem extends com.example.TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory");
        String N = "Name:";
        String D = "Description:";
        String P = "Price";
        String AQ = "Available Quantity:";
        String ST = "Sub Total";

        String columnname = String.format("%-20$s, %-20$s, %-10$f, %-10$f, %-10$f", N, D, P, AQ, ST);
        System.out.println(columnname);


    }

    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (getItemCollection().containsKey(item.getItemName())) {
            System.out.println(item.getItemName() + " is already in the App System");
            return false;
        } else {
            getItemCollection().put(item.getItemName(), item);
            return true;
        }
    }


    public Item reduceAvailableQuantity(String item_name) {
        if (getItemCollection().containsKey(item_name)) {
            Item item = new Item();
            item.setQuantity(item.getQuantity() - 1);
            return (getItemCollection().get(item_name));
        } else {
            return null;
        }

    }
}
