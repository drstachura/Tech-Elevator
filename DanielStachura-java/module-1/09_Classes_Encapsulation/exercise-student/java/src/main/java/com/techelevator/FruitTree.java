package com.techelevator;

public class FruitTree {

    private String typeOfFruit;                                               //instance variables
    private int piecesOfFruitLeft;

    public FruitTree() {                                                      //default ctor
        typeOfFruit = "Apple";                                                //  set the instance variable to default variable
        piecesOfFruitLeft = 10;
    }


    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {         //2 arg ctor

        this.typeOfFruit = typeOfFruit;                                    //because parameter is same name as instance var - ned this.
        //object type of fruit  = parameter type of fruit
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //ensure variable names are correct before setting getter
    public String getTypeOfFruit() {                                            //type of fruit on the tree
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {                                             //number of remaining fruit pieces on
        return piecesOfFruitLeft;                                                   //  the tree
    }


    @Override
    public String toString() {
        return "FruitTree{" +
                "typeOfFruit='" + typeOfFruit + '\'' +
                ", piecesOfFruit=" + piecesOfFruitLeft +
                '}';
    }

    //write the code for the method to accept an int called numberOfPiecesToRemove and return a boolean
    //if i want to pick that many pieces of fruit, can i

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }
        return false;
    }
}

//create pickFruit() method