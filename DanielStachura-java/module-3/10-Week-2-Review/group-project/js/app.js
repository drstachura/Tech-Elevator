/* determine the max number of problems per session
    for flexibility in the future*/
const PROBLEMS_PER_SET = 10;     // max number of problems in the problem set displayed to the user
let currentProblem = 0;          // this is the current problem being displayed
let problemSet = [];             // hold the problem set
let userScore = 0;                   // current problem set score

/* after the DOM is loaded we can add the stuff we need for a problem */
document.addEventListener('DOMContentLoaded', () => {
//add event listeners for each answer for when it's clicked before we do anything else
//get a reference to each <li> that represents an answer in an array
let answerListItems = document.querySelectorAll('#answers ul li');  
// add an event listener for a click to each <li>
answerListItems.forEach( (aListItem) => {
    aListItem.addEventListener('click', (eventObject) => {
        // get the answer text that was clicked as a number (int)
        // eventObject.currentTarget is a reference to what was clicked 
        // .innerText is the content of the element
        let userAnswer = parseInt(eventObject.currentTarget.innerText)

        //get the correct answer for the current problem
        let correctAnswer = parseInt(problemSet[currentProblem].problem.answer)

        // does the user's answer match the correct answer
        if (userAnswer === correctAnswer) {
            userScore++;        // increment the score 
            // update the score on the screen
            const theDisplayScore = document.querySelector('.currentScore') 
            theDisplayScore.innerText = userScore;
        }
        // move to the next problem
        currentProblem++; // increment our problem counter
        document.querySelector('.currentProblem').innerText = currentProblem+1;
        displayProblem();
        displayAnswers();
    })
}) 

    generateProblems(); //call the function to generate the problem set
    displayProblem();   // display a problem
    displayAnswers();   // display the set of answers for a problem
})

/* come up with the problems
    generate random numbers for the problem */

/* since we may need to generate the problem set multiple times(start, if they want to start over)
    it's a good idea to make it a function that we call whenever we need */
function generateProblems() {
    // populate the problemSet[] with the problems
    for (let i=0; i < PROBLEMS_PER_SET; i++) {
        // define a problem object to hold the components (problem and the answer) of a problem
        // generate a random number between 0-9 for each side of the problem (3 * 5)
        const problem = {
            left:   getRandomNumber(10) ,   // the value to the left of the arithmetic operator (0->9.  need to use 10)
            right:  getRandomNumber(10) ,   // the value to the right of the arithmetic operator
            answer: null                    // the answer to the problem - since the values are random we don't know what they are yet
        } 
        // *** safest to set the answer AFTER the randomNumber is generated ***
            // calculate the answer using the random values
            const correctAnswer = problem.left * problem.right
            // store the correct answer in the problem
            problem.answer = correctAnswer

            /* generate the four possible answers one correct and 3 random other possible answers*/
            /* call getRandomNumber(82) to receive a random number between 0 and 81 */
            /*  for now we don't care if a random answer happens to match the correctAnswer */
            /*      or if we get the same random value twice */
            let answers = [correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)] //using 82 for numbers 0->81
            
            /* shuffle the possible answer so the correct one is a different each time */
            shuffleArray(answers)
            // let answers = shuffleArray([correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)]) // combine above array and then shuffle it
            // finally someone told us we need to add the problem and its answers to problemSet
            //  since we need to add 2 things to the array element - we need to put them in an object
            problemSet.push({problem, answers})
    } //END for-loop
} //END function


/* display a problem */
function displayProblem() {
    // we need to change the elements in the DOM (displayable html) to have a problem
    // get a reference to where the problem is displayed in the DOM
    const theProblem = document.getElementById('problem'); //this is the <section> with the problem
    
    // format the expression for the problem (left-value * right-value)
    // the problems are stored in an array called problemSet
    // we need the problem in the problemSet for the current problem
    const problemExpression = `${problemSet[currentProblem].problem.left} * ${problemSet[currentProblem].problem.right}`

    //assign the expression to the DOM element
    theProblem.querySelector('div.expression').innerText = problemExpression;

}//END function

/* display four possible answers */
function displayAnswers() {
    // get a reference to the place in the DOM theAnswers should be displayed
    const theAnswers = document.getElementById('answers');
    const theAnswerSet = theAnswers.querySelector('ul');    //a reference to the list of answers 
    const eachAnswer = theAnswerSet.querySelectorAll('li'); //array of references to the <li>

    const problemAnswers = problemSet[currentProblem].answers; //get the array of answers for the current problem
    
    //loop through the array of <li> to hold answers and assign the corresponding answer from the problemAnswer[]
    for (i=0; i < eachAnswer.length; i++) {
        eachAnswer[i].innerText = problemAnswers[i];
    }
}//END function



/* after last question hide any element with show-hide 
        - <header> > <p>
        - #problem
        - #answers                                          */


/**********************************************************************************************************
 *  Utility code provided to us by the previous developer
 **********************************************************************************************************/

/**
* Utility function to generate a random number based on max
* @param {number} max
*/
function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
    }

/**
* Utility function to shuffle the items in an array
* @param {object} arr
*/
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
    }


