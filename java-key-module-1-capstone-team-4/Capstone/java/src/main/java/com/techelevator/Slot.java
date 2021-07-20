package com.techelevator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Slot {
//define set of products
    private Stack<Products> productSlot; // Define a reference stack
    double price;

//getters
    public Stack<Products> getProductSlot() {
        return productSlot;
    }
    public void addAProduct(Products newProduct) {
        productSlot.add(newProduct);
    }
    public Products returnProduct() {
        if (productSlot.size()== 0){
            return null;
        }
        return productSlot.pop(); // return one item
    }
    public Products peekProducts() {    //want took at a product in the stack without removing it
        if (productSlot.size() == 0) {
            return null;
        }
            return productSlot.peek();
        }

        public double getPrice () {
            return price;
        }

    //ctor
    public Slot(double price) {
       this.productSlot = new Stack();
       this.price = price;
    }
    public String toString() {

        return null;
    }





}
