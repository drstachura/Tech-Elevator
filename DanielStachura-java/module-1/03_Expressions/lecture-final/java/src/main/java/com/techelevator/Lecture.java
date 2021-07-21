package com.techelevator;

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
//  access return
//   type   type  function-name(parameters) - no parameters
    public int    returnNotOne() {
        return 2;
    }  // 2.0 is an error because it's a double not an int

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
//  access return
//   type   type  function-name(parameters) - no parameters
    public double returnNotHalf() {
        return 0.6;  // Josh wanted return 0.5 * 0.5 which would have been OK too
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
//  access return
//   type   type  function-name(parameters) - no parameters
    public String returnName() {
        return "Josh in Colorado wakes up early just for us";
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
//  access return
//   type   type  function-name(parameters) - no parameters
    public double returnDoubleOfTwo() {
        return 2;
    }  // 2 is an int, Java will convert to double to return the value
//                                      return 2.0; is OK too
    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
//  access return
//   type   type  function-name(parameters) - no parameters
    public String returnNameOfLanguage() {
        return "Java";
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.

    The if statement allows you to execute statements conditionally

    syntax-1:   if (condition) {
                   what-to-do-if-the-condition-is-true
                }   // end of if statement

    syntax-2:  if (condition) {
                   what-to-do-if-the-condition-is-true
               }    // end of true-processing
                else {
                   what-to-do-if-condition-is-false
               }    // end of false process and end of if

    syntax-3:  if (condition) {
                   what-to-do-if-the-condition-is-true
               }    // end of true-processing
                else if (condition) {
                        what-to-do-if-nested-if- condition-is-true
                     }        // end of nested if true process
                     else {
                         what-to-do-if-nexted-if-condition-is-false
                     }  // end of nested id and nested false
  \
    */

    public boolean returnTrueFromIf() {
        if (true) {  // always true
            return true;   // terminate the function and return true
        }
        return false;  // we only get here if the if was false - terminate function and return false
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.

    Note: equals in Java is == NOT just =
          code two equals to indicate and equal condition

          =   means assignment
          == equal condition

    */

//  access return
//   type   type  function-name(parameters) - no parameters
    public boolean returnTrueWhenOneEqualsOne() {
        if (1 == 1) {
            return true;  // terminate function and return true
        }
        return false;  // Only way we get here is if the condition from if is false
                       // We need to code this return statement even though it is not needed
                       //    the condition we are testing can never be false
                       //    but the compiler/IntelliJ doesn't know that
                       //    so it forces you to code a return statement
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
//  access return
//   type   type                   function-name(parameters) - one parameter that is int we gonna number in the function
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if (number > 5) {  // Check the parameter passed to the function for being > 5
            return true;   //       if it is greater thab 5 - return true
        } else {           //       if it is not greater than 5
            return false;  //             return false
        }
     //   return false;  // IntelliJ is saying this is unreachable code
                         // because we have all possible conditions covered in the if
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
        // you can code an expression that returns the type you want
        // since this if function is returning a boolean and a condition results in a boolean
        //      we can simply code the condition on return
        // IF THIS IS CONFUSING TO YOU - USE THE IF ABOVE - only use code you understand
        // Don't use shortcut coding techniques unless you fully understand what they do
        // YOU need to understand what you code is doing
        // If you don't know what you are doing, don't do it!
        return (number > 5); // What can we put here that returns a boolean that we want?
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
    //  if (addThree == true) {  - that's OK top
        if (addThree) {      // since addThree is boolean we don't have to say addThree == true
            number = number + 3;  // if addThree is true add 3 to number
        }
        // We don't else here because we need to check addFive regardless of the value in addThree
        // If had coded else-if here, we would only check addFive if addThree was false
        //                            (NOT the requirement)
        if (addFive == true) {     // addFive parameter is == true
            number = number + 5;   // add 5 to number - number += 5; is OK too
        }
        return number;  // terminate function and return the value in number
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3
        and returns an empty String for anything else.
    */
//  access return
//   type   type      function-name(parameters) - one int parameter we're calling number
    public String returnFizzIfThree(int number) {
        if (number == 3) {
          return "Fizz";
        }
        return "";   // terminate function return an empty string
    }
    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.

        ternary operator - shorthand for an if-else coding - only three operand operator

        syntax:  condition ? result-if-true : result-if-false
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return (number == 3) ? "Fizz" : "";   // if number == 4, result is "Fizz" otherwise result is ""
    }

    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3,
                                                "Buzz" if the parameter is 5
                                            and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
        if (number == 3) {
            return "Fizz";
        }  // else (number == 5) {
           //                     return "Buzz";
           //                    }
        if (number == 5) {
            return "Buzz";
        }
        return "";
        // return (number==3) ? "Fizz" : (number==5) ? "Buzz" : "";  // OK too
    }

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18.
        Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if (number >= 18 ) {   // if (number == 18 || number > 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean opeation.
    */
    public String returnAdultOrMinorAgain(int number) {
        if (number == 18 || number > 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    16. Return as above, but also return "Teen" if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {
        if (number >= 18) {
            return "Adult";
        } else if (number >= 13 && number <= 17) {
            return "Teen";
        } else {
            return "Minor";  // we only get here is the previous two conditions are false
        }
    }

}