package org.example.tesco;

import org.example.tesco.RuleEngine.cart.Cart;
import org.example.tesco.RuleEngine.cart.ProductItem;

public class Interview {
    public static void main(String[] args) {
        Cart cart = initCart();
        if(cart.validate())
            System.out.println("MET");
        else
            System.out.println("BREACHED");

    }
    public static Cart initCart() {
        Cart cart = new Cart(1);
        cart.addItems(new ProductItem(1, "Paracetamol", 3));
        cart.addItems(new ProductItem(2, "analgesic", 3));
        cart.addItems(new ProductItem(3, "chocolate", 11));
        cart.addItems(new ProductItem(4, "Paracetamol", 3));
        return cart;
    }
}



//Tesco gets millions of orders every day with an average basket size of 100 items. Tesco Business has got some regulations around selling products online and in stores.
// These regulations are mandatory from legal and business perspective to enforce for all order transactions.
//
//You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
//
//        Example:
//
//Ordered items in the shopping cart/basket
//
//Item-1 -> productid=1, category=Paracetamol, quantity=3
//
//Item-2 -> productid=2, category=analgesic, quantity=3
//
//Item-3 -> productid=3, category=chocolate, quantity=11
//
//Item-4 -> productid=4, category=Paracetamol, quantity=3
//
//Business Restriction rules:
//
//Cannot buy more than 10 Quantity of any products - BulkBuyLimit
//
//Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
//
//
//
//Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction status for the given restriction rules.
//
//For the above given example, the restriction status returned would be MET.
//has context menu
//has context menu
