package com.techelevator;

import javax.naming.InsufficientResourcesException;
import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.EmptyStackException;

public class VendingMachine {
    private double balance;   // money in the machine
    // key is a slot number, value is a slot
    private Map<String, Slot> products;

    //Change
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;

    //getters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Slot getSlot(String slotNumber) {
        return products.get(slotNumber); // return the slot requested
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    //ctor
    public VendingMachine() throws IOException {
        this.products = new TreeMap();
        balance = 0.00;
        loadingVendingMachine(); // calling the method to load file into Vending Machine


    }

    // Need to load file into Products
    public void loadingVendingMachine() throws FileNotFoundException {
        File inventory = new File("vendingmachine.csv");
        Scanner inventoryList = new Scanner(inventory);
        String aLine = "";      // hold line for file
        int numberItems = 5;    // this number of products for each slot

        while (inventoryList.hasNextLine()) { //loop while there's a next line in file
            aLine = inventoryList.nextLine(); // next line in file
            String[] productDetails = aLine.split("\\|"); // split line at the pipe
            //Have to load parts of the line into products Map <String, Slot>
            //The String is the slot number-- productDetail[0]
            //The Slot we have to create
            //To create a slot, we need to know the price - in productDetails[2]
            Slot newSlot = new Slot(Double.parseDouble(productDetails[2]));

            //We need to add product to the stack in slot to make Daniel happy
            //We need to create a product to add to stack
            Products newProduct = new Products(productDetails[3], productDetails[1]);
            for (int i = 0; i < numberItems; i++) {
                newSlot.addAProduct(newProduct);// Added a product to the stack to the slot
            }
            // now we have everything we need to add data to map
            products.put(productDetails[0], newSlot);
        }
    }// Ending of loading vending machine

    // Display products - **update to show SOLD OUt for 0 left
    public void displayProducts() {
        // this is where we write the code to display the products
        //display the inventory list of items PLUS the Stack
        //our Map is products
        // key is index 0 , value is Slot- price, and products in the stack - name and type with stack value
        Set<String> theKeys = products.keySet();
        for (String aKey : theKeys) {
            //                                    this is a slot. this is a product. get the product
            System.out.println(aKey         //Map key value
                    + " | " + products.get(aKey).peekProducts().getName()   //product name
                    + " | " + products.get(aKey).getPrice()                 // price
                    + " | " + products.get(aKey).peekProducts().getType()   //product type
                    + " | " + products.get(aKey).getProductSlot().size() + "  left");  //inventory in stock
        }
    }//End of displayProducts method

    // Need to feed money - **need to have invalid inputs not add to balance
    public void feedTheMoney() throws IOException {
        //per ctor balance starts at 0.00
        //need to loop this so the user can continuously add more money
        Scanner moneyInput = new Scanner(System.in);

        System.out.println("Current Money Provided: $" + balance); //show user current balance

        System.out.println("Please input your Money: 1.00, 5.00, 10.00, 20.00");
        Double money = moneyInput.nextDouble(); //only allow 1.00, 5.00, 10.00, 20.00
        // if money is of the specified amounts allow the input
        // if money is NOT if the specified amounts, return error message
        if ((money == 1.00) || (money == 5.00) || (money == 10.00) || (money == 20.00)) {
            this.balance = balance + money; // if money is in above amounts adds to this.balance
            System.out.println("Current Money Provided: $" + this.balance);
        } else {
            //triggers message if amount is not in 1.00, 5.00, 10.00 or 20.00
            System.out.println("Invalid money input");
            return;
        }

        File auditLog = new File("log.txt");
        auditLog.createNewFile();
        FileWriter fileWriter = new FileWriter(auditLog, true);
        BufferedWriter aBufferWriter = new BufferedWriter(fileWriter);
        PrintWriter aPrintwriter = new PrintWriter(aBufferWriter);

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        aPrintwriter.println(timestampNow + " FEED MONEY:" + " $" + money + " $" + this.balance);

        aPrintwriter.close();



    }//End of feedTheMoney method

    // Need to dispense product
    public Slot dispenseProduct() throws EmptyStackException, IOException {
        //show the products available - use displayProducts to select the product
        Scanner selectProduct = new Scanner(System.in);
        System.out.println("Please make your selection:");

        //we want user to input the Key from the Map called products
        String slotSelection = selectProduct.nextLine();
        //our selection didn't actually do anything yet

        if (products.containsKey(slotSelection)) { // slotSelection appears on Product map
            if (!products.get(slotSelection).getProductSlot().isEmpty()) { // checks to see if slotSelection has stock and is not empty
                products.get(slotSelection).getProductSlot();//  locates slot based on slotSelection, pulls product
                if (this.balance > products.get(slotSelection).getPrice()) { // if this.balance is above product price and can cover transaction
                    this.balance = (balance - products.get(slotSelection).getPrice()); // updates balance to subtract product price

                    System.out.println( // prints out summary of transaction
                            products.get(slotSelection).returnProduct().getName()
                                    + " | " + products.get(slotSelection).getPrice()
                                    + " | " + "Balance remaining " + this.balance
                                    + " | " + products.get(slotSelection).peekProducts().getReturnMsg());   //cant peek at 0 items
                } else { // Not enough funds in in balance, triggers error message, cancels transaction
                    System.out.println("Insufficient funds. Please feed the machine money!");
                }
            }
             else if (products.get(slotSelection).getProductSlot().size() == 0) {// triggering an EmptyStackException error
                try {
                    products.get(slotSelection).getProductSlot();
                } catch (EmptyStackException emptyStack) { // tried to catch exception,but still causes exception and closes program
                }
            } else if (products.get(slotSelection).getProductSlot().isEmpty()) { // not triggered due to EmptyStackException
                System.out.println("Item out of Stock");
            }
        }


        File auditLog = new File("log.txt");
        auditLog.createNewFile();
        FileWriter fileWriter = new FileWriter(auditLog, true);
        BufferedWriter aBufferWriter = new BufferedWriter(fileWriter);
        PrintWriter aPrintwriter = new PrintWriter(aBufferWriter);

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        aPrintwriter.println(timestampNow + " " + products.get(slotSelection).returnProduct().getName()
                + " " + slotSelection                                               //this is returning null
                +  " $" + (balance + products.get(slotSelection).getPrice())      //need this to carry from money fed in to the machine
                + " $" + (this.balance));

        aPrintwriter.close();

        return null;
    }// End of Dispense Product

    public void dispenseChange() throws IOException {
        // Change
        double change = this.balance; // made this.balance into change variable. easier to write out than this.balance

        //Quarters - in while loop
        while (change >= .25) { // If change is above .25 issue quarters
            change = change - .25; // keeps subtracting change by .25
            quarters += 1; // Add a quarter each time until change is below .25
        }
        //Dimes
        while (change >= .10) { // If change is below .25 and above .10 issue dimes
            change = change - .10; // keeps subtracting change by .10
            dimes += 1; // Add a dime each time until change is below .10
        }
        //Nickels
        while (change >= .05) { // If change is below .10 and above .05 issue nickels
            change = change - .05; // keeps subtracting change by .05
            nickels += 1; // Add a nickel each time until change is below 0.05
        }
        System.out.println("Change returned: $" + this.balance + " Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels); //message to show that change has been returned

        // brings balance to 0.00, resets quarters, dimes and nickels to 0

        File auditLog = new File("log.txt");
        auditLog.createNewFile();
        FileWriter fileWriter = new FileWriter(auditLog, true);
        BufferedWriter aBufferWriter = new BufferedWriter(fileWriter);
        PrintWriter aPrintwriter = new PrintWriter(aBufferWriter);

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        aPrintwriter.println(timestampNow + " GIVE CHANGE: $"
                + (this.balance)    // this is returning 0.00
                + " $" + (this.balance - this.balance));

        aPrintwriter.close();

        this.balance = 0.00;
        quarters = 0;
        dimes = 0;
        nickels = 0;
    } // End of Dispense Change


        //product code doesn't exist - inform the customer, return to purchase menu **first run it did this for us
        //product sold out, inform the customer, return to purchase menu

    // Need to generate audit log - feed money, dispense, give change,
    // Need to generate sales report

} // End of Vending Machine Class
