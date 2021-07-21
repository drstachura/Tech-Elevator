package com.techelevator;

public abstract class Wall {

    private String color;
    private String name;

    public Wall(String name, String color){
        this.name = name;
        this.color = color;
    }

    public abstract int getArea();


    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }



}

