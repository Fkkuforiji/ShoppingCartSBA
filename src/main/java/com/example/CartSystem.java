package com.example;

import java.util.HashMap;
public class CartSystem extends com.example.TheSystem {


    CartSystem() {
        super();

    }

    @Override
    public void display() {
        HashMap<String,Item> hashMap = this.getItemCollection();
        double subtotal = 0.0;
        double tax = 0.00;
        double total = 0.00;
        subtotal = getItemCollection().get(hashMap).getItemPrice()
                * getItemCollection().get(hashMap).getQuantity();
        tax = subtotal * 0.05;
        total = tax + subtotal;

//String Name = getItemCollection().get()
        //should i define the values within a for loop???
        // should i define Item item as Item item; with no for or curly braces? results in 8 errors vs 10 with for loop
        //Item item;
        String Name = getItemCollection().get(hashMap).getItemName();
        //hashMap is probably not right here, but it removed an error????
        String Desc = getItemCollection().get(hashMap).getItemDesc();
        Double Price = getItemCollection().get(hashMap).getItemPrice();
        Integer Quantity = getItemCollection().get(hashMap).getQuantity();
        String cartitems = String.format("%-20$s, %-20$s, %-10$f, %-10$f",
                Name, Desc, Price, Quantity);
        System.out.println(cartitems);


//              System.out.println("Cart: );

        //APPLY VALUES FOR THE ITEM INFO(name, desc, price, avail, sub)
//        System.out.println(hashMap);

        //HOW TO MAKE COLUMNS????? HOW TO DISPLAY:
        // AppSystem Inventory:
        ////Name                 Description          Price      Available Quantity
        ////pizza                very cheesy          12.30      3
        ////salad                cobb salad           15.50      12
        ////hunger burger        huge patty           9.49       10
        ////fried chicken        so crispy            18.99      5
    }

}
