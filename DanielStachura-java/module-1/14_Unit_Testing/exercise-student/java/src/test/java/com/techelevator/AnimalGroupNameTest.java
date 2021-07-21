package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalGroupNameTest {

// optional @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    //instantiate an object with the code to be tested
    AnimalGroupName theCode = new AnimalGroupName();

//copy method signature from the code
    //Testing - public String getHerd(String animalName)

//Given an animal in the Map, return the group name
    @Test
    public void test_animal_name_is_in_the_Map(){
        //Arrange - set up the data to test the method
        String anAnimal = "giraffe";

        //Act     - run the method with the test data and get the result
        String actualGroupName = theCode.getHerd(anAnimal);

        //Assert  - verify the result is what was expected
        assertEquals("Tower", actualGroupName);
    }

    @Test
    public void test_animal_name_is_NOT_in_the_Map(){
        //Arrange - set up the data to test the method
        String anAnimal = "Frank";

        //Act     - run the method with the test data and get the result
        String actualGroupName = theCode.getHerd(anAnimal);

        //Assert  - verify the result is what was expected
        assertEquals("unknown", actualGroupName);
    }

    //Given animal is null
    @Test
    public void test_animal_name_is_passed_is_null(){
        //Arrange and Act - run the method will null and get the result
        String actualGroupName = theCode.getHerd(null);

        //Assert  - verify the result is what was expected
        assertEquals("unknown", actualGroupName);
    }

    //Given an empty String
    @Test
    public void test_animal_name_is_empty_String() {
        //Arrange - set up the data to test the method
        String anAnimal = "";

        //Act     - run the method with the test data and get the result
        String actualGroupName = theCode.getHerd(anAnimal);

        //Assert  - verify the result is what was expected
        assertEquals("unknown", actualGroupName);
    }
}
