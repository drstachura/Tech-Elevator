package com.techelevator;


    public class TriangleWall extends SquareWall {
        private int base;
        private int height;


        public TriangleWall(String name, String color, int base, int height){
            super(name, color, base, height);
            this.base = base;
            this.height = height;
            System.out.println(name + color + base + height);
        }



        @Override
        public int getArea() {
            return height * base / 2;
        }

        public int getBase() {
            return base;
        }

        @Override
        public int getHeight() {
            return height;
        }

        public String toString(){
            return (getName() + " (" + base + "x" + height + ") triangle");
        }

    }

