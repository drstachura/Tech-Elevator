package com.techelevator;

public class Television {
//Instance variable
    //isOn
    //currentChannel
    //currentVolume
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

//ctor default values
    //new tv is off
    //channel = 3
    //volume = 2
    public Television() {
        isOn = false;
        currentChannel = 3;
        currentVolume = 2;
    }

//Getters
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

//Method
    //turnOff - isOn = false - tv is off
    public void turnOff(){
        this.isOn = false;
    }

    //turnOn - !isOn = true - tv is on
    public void turnOn(){
        this.isOn = true;
    }

    //tv has to be on, newChannel between 3 -18
    public void changeChannel(int newChannel){
        if (this.isOn = isOn && (newChannel >= 3 && newChannel <=18)){
            currentChannel = newChannel;
        }
   }

   //tv has to be on, increase current channel by 1(++), if channel > 18 revert channel to 3
   public void channelUp(){
        if (this.isOn = isOn) {
            currentChannel++;
            if (currentChannel > 18) {
                currentChannel = 3;
            }
        }
   }

   //tv has to be on, decrease current channel --, if channel <3 revert channel to 18
   public void channelDown(){
       if (this.isOn = isOn){
           currentChannel--;
           if(currentChannel < 3){
               currentChannel = 18;
           }
       }
   }

   //tv has to be on, increase volume ++, limit is 10
   public void raiseVolume() {
       if (this.isOn = isOn && currentVolume < 10) {
           currentVolume++;
       }
   }


   public void lowerVolume() {
           if (this.isOn = isOn && currentVolume > 0) {
               currentVolume--;
           }
       }

}
