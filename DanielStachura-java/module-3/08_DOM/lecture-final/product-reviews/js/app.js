const pageTitle = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];
/*********************************************************************************************
 * Functions to manipulate the DOM to add or change elements/nodes for display
 * 
 * One function for each DOM manipulation we want to do instead of a long string of JavaScript
 * the functions are called as they are needed (in this case at bottom of this file)
 *********************************************************************************************/
/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  // We need the pageTitle variable to the <span> tag in the html
 
  // get a pointer to the element with the id="page-title"
  const thePageTitle = document.getElementById('page-title');

  // find the <span> tag in the element with id="page-title"
  const theSpan = thePageTitle.querySelector('.name');  // Ask thePageTitle to tells what has class="name"
  
  // Assign the contents (innerText) of the variable title to the <span>
  theSpan.innerText = pageTitle; // set the content of  the span to the variable pageTitle

}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  // get a pointer to the <p> with the class='description'
  const theDescription = document.querySelector('.description');  // tell me where the tag with class='description'
  // set the content of the <p> to the variable description
  theDescription.innerText = description;  // set the content of theDescription to thr description variable
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 * 
 * Call helper functions to add each element of the review to the page (instead of a long stream of JavaScript)
 */
function displayReviews() {
// Get a pointer to where the reviews need to be in the document (as children of <div id='main'>)
const theDiv = document.getElementById('main');  // Find the element with id="main"
// Loop through the array of reviews adding them one at a time to the document
reviews.forEach( (aReview) => {  // use a anon-fund with the forEach sending each review to anon-func as aReview
              //    create a new <div> for the review
              const newElement = document.createElement('div');
              // add a class='review' to the new <div> so it is styled as a review (css given)
              newElement.setAttribute('class','review')  
              //    call each helper function (below) with the new <div> as the parent and data for element it's creating

              addReviewer(newElement, aReview.reviewer) // Call the function to add the reviewer to the DOM
              addRating(newElement, aReview.rating)     // Call the function to add the rating to the DOM
              addTitle(newElement,aReview.title)        // Call the function to add the title to the DOM
              addReview(newElement,aReview.review)      // Call the function to add the review to the DOM
              // Add the new element to the DOM tree at the end of the <div> with class='main'
              theDiv.insertAdjacentElement('beforeend', newElement)
              });  // end of our anon-func and the forEach
}



// These functions will be called by displayReviews to handle each new element needed
/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 * 
 * the first parameter (parent) is where to add the new element
 * the second parameter is the data to be included in the new element
 */
function addReviewer(parent, name) {
  const aReviewer = document.createElement('h4')  // create an <h4> element for review name
  aReviewer.innerText = name;                     // set the text in the <h4> to the name we got passed into us
  parent.appendChild(aReviewer);                  // connect the ne <h4> to the parent we received
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 * 
 * the first parameter (parent) is where to add the new element
 * the second parameter is the data to be included in the new element
 */
function addRating(parent, numberOfStars) {
  // numberOfStars is a numeric value telling us how many star to put in the review
  // we have the image for one star - we need as as many <img> tag as the value in rating
  // we need to set up a loop to add <img> tags using numberOfRatings to control loop
  // because we will have several <img> tags, lets group them in their own <div>
  //         also we have style for class='rating' for the rating element, so they need to be in a <div>

  const theRating = document.createElement('div')   // create a <div> to hold the rating
  theRating.setAttribute('class', 'rating')         // give a class='rating' to new <div>

  for(let i=0; i < numberOfStars; i++) {         // loop for the value in numberOfStars
    const aStar = document.createElement('img')  //    create an <img> tag for a star
    aStar.setAttribute('class', 'ratingStar')    //    assign class='ratingStar' to the new <img> tag
    aStar.src='img/star.png'                     //    set the src= of the <img> tag to the star image we have
    theRating.appendChild(aStar)                 //    connect the mew star to the new rating <div>
  }
  parent.appendChild(theRating)                // connect the newRating div to parent in the DOM
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 * 
 * the first parameter (parent) is where to add the new element
 * the second parameter is the data to be included in the new element
 */
function addTitle(parent, title) {
  const theTitle = document.createElement('h3')
  theTitle.innerText = title;
  parent.appendChild(theTitle);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 * 
 * the first parameter (parent) is where to add the new element
 * the second parameter is the data to be included in the new element
 */
function addReview(parent, review) {
  const theReview = document.createElement('p');
  theReview.innerText = review;
  parent.appendChild(theReview)
}


// These functions below are called when the page is loaded to run the DOM manipulation defined above

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
