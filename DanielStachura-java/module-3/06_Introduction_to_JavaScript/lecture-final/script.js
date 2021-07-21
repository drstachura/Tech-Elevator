/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed (a constant)
  const daysPerWeek = 7;   // const defines a a variable whose value cannot be changed
                           // Normally a const name would be all UPPERCASE
    
  // console.log() is the JavaScript equivalent of System.out.println() in Java - display a line on the screen
  // If what you want console.log() to display contains a variable 
  //             you must code the string in `` (tick marks - usually the key to the left of the 1-key)
  //             and the variable as ${variable-name}

  console.log(`There are ${daysPerWeek} days in a week`)  // semi-colons are usually optional in JavaScript

  // Declares a variable those value can be changed
  let daysPerMonth = 30; // let defines a variable that may be changed 
  console.log(`There are ${daysPerMonth} in a month`)

  // There is another way to define a variable using the var keyword - NOT RECOMMENDED!
  // Avoid defining variables with var as it can lead to var confusing and hard to debug code
  //       more about why you should avoid var later in class

  // Declares a variable that will always be an array
  const WEEKDAYS = [  // a JavaScript array is defined inside []
                    "Monday",  // separate multiple values with , (just like Java)
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    100,    // JavaScript doesn't care
                    1.34,   //         if datatypes
                    true,   //               are mixed together (JAVA DOES!)
                    "Saturday",
                    "Sunday"
                    ]
  console.table(WEEKDAYS)  // Display the array as a table
  console.log(WEEKDAYS)   // No `` nor ${} if all you want to display is the variable
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 * 
 * Data types for parameters is not coded like it is in Java
 * 
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * ==  is loose equality  - compares the value only
 * === is strict equality - compares the value and datatype
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy (true) or falsy (false).
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * 
 * anything used in conditional expression will evaluate to true or false
 * if an expression used in a conditional evaluates to "nothing" - 0,"", null, NaN, undefined === false
 *                                         everything else is true
 * 
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs (like Maps in Java)
    - values can be primitive data types
    - values can be arrays
    - or they can be functions

    JSON stands for JavaScript Object Notation 
         if understand JSON format, you understand JavaScript objects
    
    JavaScript objects are NOT the same as Object-Oriented objects
                                        no Class, nor Inheritance, nor Polymorphism, nor Interfaces
*/
function objects() {
  const person = {          // JavaScript object is enclosed {}
    firstName: "Bill",      // Attribute of a JavaScript object are key-vale pairs (attribute : value)
    lastName: "Lumbergh",   // Separate attributes in a JavaScript object with ,
    age: 42,                // Data types may be mixed in a JavScript object
    employees: [            // Array defined as an attribute of a JavaScript object   
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],                      // End of the array attribute in this JavaScript object
    // define a toString() for this object - return the object as a string
    toString : function() { // attribute (function name : function())
      return `${this.firstName},  ${this.lastName},  (${this.age})`
    }
  };                        // End of the JavaScript Object

  // call a function defined for an object
  console.log(person.toString())


  // Log the object
  console.log(person);  // display the entire object
  console.table(person) 

  // Log the first and last name (object.attribute to access an individual attribute in an object)
  console.log(`The person's first name: ${person.firstName} last name: ${person.lastName}`)

  // Log each employee
  // Loop through the array of employees in the object
  // JavaScript has a for-loop similar to Java's
  //
  //    for (let i=0; i < arrayname.length; i++) {}

  for (let i=0; i < person.employees.length; i++){
    console.log(`Employee #: ${i+1}: ${person.employees[i]}`)
  }
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  console.log(`in the 2-arg Add`)
  return num1 + num2;
}
// Since this function has the same name as an existing function
// it REPLACES the existing (in Java this would have been an overload)
function Add(num1, num2, num3) {
  console.log(`in the 3-arg Add`)
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.

Like most languages JavaScript has libraries of frequently used functions

*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  console.log(`value.substr(4,3)    - ${value.substr(4,3)}`)   // .substr(start-index, length)
  console.log(`value.substring(4,7) - ${value.substring(4,7)}`)// .substring(start-index, end-index)
                                                               //     Starts at the start index up to but including the ending index
                                                               //               (just like Java substring)

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
} // end of the stringFunction() examples
    /*
    ########################
     Array Methods
    ########################

    Methods to manipulate arrays - a lot more flexibility than arrays in Java
    */
 function arrayFunction() {
  let stooges = [
                 "Moe",
                 "Larry",
                 "Curly"
                ]
  console.table(stooges)      // display the array as a table

  stooges.push("Shemp")       // add an element to end of the array
  console.table(stooges)      // display the array as a table

  stooges.unshift("Curly Joe") // add an element to the start of the array
  console.table(stooges)       // display the array as a table

// .splice(start-index,#-elems-to-remove, any additional elements)

  stooges.splice(3,0,"Groucho", "Chico", "Harpo")  // add elements starting at index 3 and remove none
  console.table(stooges)      // display the array as a table

  stooges.splice(3,1)         // remove 1 element at index 3 and don't add any elements
  console.table(stooges)      // display the array as a table

  stooges.splice(3,2)         // remove 2 element at index 3 and don't add any elements
  console.table(stooges)      // display the array as a table

  stooges.shift()             // remove the first element and shift all elems up 1 position
  console.table(stooges)      // display the array as a table

  stooges.pop()               // remove one element at the end of the array (last element)
  console.table(stooges)      // display the array as a table
 
 // Remove an element based on it's value (remove "Larry")
  stooges.splice(stooges.indexOf("Larry"),1) // Find the index of Larry and remove him
  console.table(stooges)      // display the array as a table

  let dan = [
          "Groucho",
          "Chico",
          "Harpo"
  ]

   let oldFunnyGuys = stooges.concat(dan) // concatenate the array Dan to the array stooges
   console.table(oldFunnyGuys)
}


