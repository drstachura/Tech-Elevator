package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CigarPartyTest {

//if the cigar count is greater than the min = successful
    @Test
        public boolean test_do_you_have_the_minimum_amount_of_cigars(){
        //arrange
        int minimumCigarCount = 40;
        //act
        int cigars;
        //assert
        assertTrue(cigars >= minimumCigarCount , true);
    }






}
