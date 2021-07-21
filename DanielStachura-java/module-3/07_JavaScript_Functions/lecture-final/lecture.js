/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * no return type on JavaScript functions - loosely typed
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 * No return statement is required in a JavaScript function
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together.
 *  But  what happens if we don't pass a value in? - result is NaN
 *  What happens if the value is not a number? - result is NaN
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
 function multiplyNoUndefined(firstParameter=0, secondParameter=0) {
  return firstParameter * secondParameter;
}


/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  // Variables defined outside a block {} is available from the point in the function down
  //           including any blocks defined from there to end of function
  let inScopeInScopeTest = true;

  // using a variable that appears to have not yet been defined 
  //   we don't see before this line of code
  console.log(`Baddy McBadBad contains: ${baddyMcBadBad}`)
  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    // variables defined inside a black are only available inside that block or blocks within it
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
    var baddyMcBadBad = "Don't ever use var!"; // defined inside a block
                                               //     but it can be used anywhere
  }
}
/** This is the start of a JavaDoc Comment - notice the ** after the / 
 * 
 *  JavaDoc is tool to format comments to be desriptive for function
 * 
 * it will automatically document parts of teh function lik parameters, return value etc
 */
/**
 * Create a string from the parameters and elements in an array passed as arguments
 * 
 * .join() will create a string from an array with separater specified
 *               (or , if no separators)
 * 
 * @param {*} name 
 * @param {*} age 
 * @param {*} listOfQuirks 
 * @param {*} separator 
 * @returns 
 */
//                                         receive an array
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);  // Create a string from listOfQuirks
                                                      // separator specified
}

/**
 * Takes an array and, using an anonymou functions, generates their sum.
 * 
 * Convert the values in an to a sum
 * Produce the sum of all the values in teh array
 * Reduce the array to the sum of the values
 * 
 * A single value out the array - This is job for reduce()!
 * 
 * .reduce() - takes an anon-func which receives two parameters
 *             receives a parameter to hold the result of each anon-func call (reducer)
 *                      a parameter that is the current element in the array
 * 
 * general syntax: array.reduce(anon-func)  
 * 
 * more specific syntax: array.reduce((reducer, anElem) => { })          
 * 
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  // in this anon-func we will call the reducer sum since it will hold the sum of the array elems
  //                   we will call the current element of the array aNumber
  // when .reduce() is done, it returns the final value in reducer (sum)
  //      which we will return from this function
  return numbersToSum.reduce((sum, aNumber) => {
                                                 sum += aNumber;  // add the current elem to sum
                                                 return sum;
                                                });

  /* alternate solutions
      return numbersToSum.reduce((sum, aNumber) => { return sum += aNumber; });
  */
  /* to accomplish the same thing with a for-loop  
        let sum = 0;
        for(let i=0; i < numbersToSum.length; i++){
          sum += numbersToSum[i]
        }
        return sum;
  */
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 * 
 * Create a new array from selected elements in another array
 * (this is what .filter() does!)
 * 
 * .filter() uses an anon-func that takes the current element as a parameter
 * the anon-func determines if the element it is sent meets the conditions to be included in new array
 *     it returns true if it does, false it it doesn't
 * 
 * .filter() will add the current element to the new array if the anon-func returns true
 * 
 * when all elements in the array are processed, .filter() returns the new array
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter((currElem) => {
                                              if (currElem % 3 == 0) { // is currElem a multiple of 3
                                                 return true;          // it should be in new array
                                              }
                                              return false; // if not a multiple of 3 return false
                                              })
/* alternate solutions 
  return numbersToFilter.filter((currElem) => {return currElem % 3 == 0)})

  return numbersToFilter.filter((currElem) => {return !currElem % 3})  // Uses truthy/falsy concept
                                                          3     % 3
                                                               0 - false
                                                              !0 - true 
                                                          7     % 3                                                     3     % 3
                                                               1 - true
                                                              !1 - false
*/
}

/**
 * This example was added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 *  A Create a new array containing the squares of the corresponding elements in an array
 * 
 *  Create a new array from all the elements in another array 
 *  (.map() does this)
 * 
 * 
 * The map function will return an array created from the elements passed to it
 * 
 * @param - None
 * @returns {array created from values passed to it}
 */

function mapArrayFunctionExampleFromBook() {
let numbersToSquare = [1, 2, 3, 4];
console.log(`Array calling map to create new array with values squared: `)
console.table(numbersToSquare);

/*
   .map() takes an anon-func that receives the current element
   the anon-func performs a process on the current element and returns it
   .map() adds the value returned from teh anon-func to the new array
*/

let squaredNumbers = numbersToSquare.map( (number) => {
    return number * number;  // square the current element and return it
});

console.log(`Array returned from map with values in passed array squared: `)
console.table(squaredNumbers);
}

/**
 * Another example added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * The forEach() is the JavaScript version of the for-each loop in Java
 * 
 * @param - An array generated as a parameter
 * @returns {array created from values passed to it}
 */
function forEachExample(anArray=["John"   ,"Alex"    ,"Jared"  ,"Agnes","Brian","Josh"  , "Nia",
                                 "JC"     ,"Daniel"  ,"Amber"  ,"Dana" ,"Jess" ,"Vanese", "Ruben",
                                 "Lindsay", "Anthony","Lorenzo","Array McRayRay"])
{
  // forEach() is the JavaScript version of the for-each look in Java
  anArray.forEach((anElement) => { 
    console.log(anElement)
    }) 

    anArray.sort(); // sort function sorts an array and replace original
    console.table(anArray);

    anArray.reverse(); // reverse elements in an array and replace original
    console.table(anArray);
}
