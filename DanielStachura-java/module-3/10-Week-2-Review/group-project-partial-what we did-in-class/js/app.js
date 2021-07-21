
    const PROBLEMS_PER_SET  = 10;  // maximum number of problems in the problem set displayed to the user
    let currentProblem = 0;        // this is the current problem being displayed
    let problemSet = [];           // hold the problem set
    let userScore = 0;             // current problem set score

    /* after the DOM is loaded we can add the stuff we need for a problem                            */
    document.addEventListener('DOMContentLoaded', () => {
        // Add event listeners for each answer for when its clicked before we do anything else
        // Get a reference to each <li> that represents an answer in an array
        let answerListItems = document.querySelectorAll('#answers ul li');
        // Add an event lister for a click to each <li>
        answerListItems.forEach((aListItem) => {
            aListItem.addEventListener('click', (eventObject) => {
                // get the answer text that was clicked as a number (int)
                // eventObject.currentTarget is a reference to what was click 
                // .innerText is the content of the element
                let userAnswer = parseInt(eventObject.currentTarget.innerText)

                // get the correct answer for the current problem
                let correctAnswer = parseInt(problemSet[currentProblem].problem.answer)

                // Does the user's answer match the correct answer
                if (userAnswer === correctAnswer){
                  userScore++;
                  // Update the score on the screen
                  const theDisplayScore = document.querySelector('.currentScore');
                  theDisplayScore.innerText = userScore;
                }
                // move to next problem
                currentProblem++;   // increment the problem counter
                document.querySelector('.currentProblem').innerText = currentProblem+1;
                displayProblem();
                displayAnswers();
            })

        })





        generateProblems();   // Call the function to generate the problem set
        displayProblem();     // Display a problem
        displayAnswers();     // Display the set of answers for a problem
    })

    /* come up with the problems  
        generate random numbers for the problem   */

    /* since we may need to generate the problem set multiple times (start, if they want to start over)
             it's a good idea to make it a function that we call whenever we need                      */
    function generateProblems() {
        // populate the problemSet array with the problems
        for(let i=0; i < PROBLEMS_PER_SET; i++) {
            // Define a problem object to hold the components (problem and answer) of a problem
            // Generate a random number between 0 and 9 for each side of the problem (3 * 5)
            const problem = {
                left:  getRandomNumber(10) ,    // the value to the left of the arithmetic operator
                right: getRandomNumber(10) ,    // the value to the right of the arithmetic operator
                answer: null                    // answer to the problem null for now
                                                //     since the values are random we don't know what they are yet
            }
            // calculate the answer using the random values
            const correctAnswer = problem.left * problem.right
            // store the correct answer in the problem
            problem.answer = correctAnswer
        
            /* generate the four possible answers one correct and 3 random other answers        */
            /* call getRandomNumber(82) to receive a random number between 0 and 81             */
            /*      for now we don't care if a random answer happens to match correctAnswer     */
            /*                           or if we get the same random value more than once      */
            let answers =[correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)]
            /* shuffle the possible answers so the correct one is a different place each time */
            shuffleArray(answers)
            // let answer = shuffleArray([correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)])
            // Finally, someone told us we need to add the problem and its answers to problemSet array
            // since we need to add two things to the array element - we need to put them in an object
            problemSet.push({problem, answers})
        }   // end of for-loop
    }
/* Display a problem                          */
function displayProblem() {
    // we need to change the element in the DOM (displayable html) to have a problem 
    // Get a reference to where the problem is display in the DOM
    const theProblem = document.getElementById('problem')  // this is the <section> with the problem

    // format the expression for the problem (left-value * right-value)
    // the problems are stored in an array called problemSet
    // we need the problem in the problemSet for the current problem
    //                                                                           
    const problemExpression = `${problemSet[currentProblem].problem.left} * ${problemSet[currentProblem].problem.right}`
    
    // assign the problemExpression to the DOM element
    theProblem.querySelector('div.expression').innerText = problemExpression;
}

/* display four possible answers              */
function displayAnswers() {
    // Get a reference to the place in the DOM the answers should be displayed
    const theAnswers = document.getElementById('answers');
    const theAnswerSet = theAnswers.querySelector('ul');   // reference to the list of answers
    const eachAnswer = theAnswerSet.querySelectorAll('li') // array of references to <li> for answers

    const problemAnswers = problemSet[currentProblem].answers; // get the array of answers for the current problem

    // loop through the array of <li> to hold answers and assign the corresponding answer from problemAnswers
    for(let i=0; i < eachAnswer.length; i++) {
        eachAnswer[i].innerText = problemAnswers[i];
    }

}



/* make the answers displayed clickable       */ 

/* increase the score when a correct answer is given */

/* increase the problem number after each problem 
   is answered up to the maximum number of problem   */

/* display a new problem once a problem is answered 
    if it wasn't the last one based on max problems  */
    
/* display the problems one at a time        */

/* hide the question after last problem (based on max) is answered */

/* start over option should rest to the beginning of the process */

/**************************************************************************
 * Utility code provided to us by the previous developer
 *************************************************************************/
/*
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

