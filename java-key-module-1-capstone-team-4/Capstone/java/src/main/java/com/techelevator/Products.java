package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Products {
// attribute variables
   private String type;
   private String name;
   private String returnMsg;

// Ctor
    public Products(String type, String name) {
        this.name = name;
        this.type = type;
        this.returnMsg = "Uh-Oh";
        if (type.equals("Chip")) {
            this.returnMsg = "Crunch Crunch, Yum!";
        }
        if (type.equals("Gum")) {
            this.returnMsg = "Chew Chew, Yum!";
        }
        if (type.equals("Candy")) {
            this.returnMsg = "Munch Munch, Yum!";
        }
        if (type.equals("Drink")) {
            this.returnMsg = "Glug Glug, Yum!";
        }
    }

// getters
    public String getName() {
        return name;
    }
    public String getReturnMsg() {
        return returnMsg;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return null;
    }

}