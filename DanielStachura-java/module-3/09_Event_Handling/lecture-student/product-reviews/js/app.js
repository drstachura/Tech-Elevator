const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  /*
  Using a html template to create the elements rather than document.createElement()
  */
 // if the html content contains a template, use it
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => { // loop for each element in reviews array
      displayReview(review);      // call the displayReview function with the current element
    });
  } else {  // if the html does not contain a template, issue an error message
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {    //display one review which is passed to it 
  const main = document.getElementById('main'); //get reference to the element with id='main'
  //generate an instance (content.cloneNode(true)) of the template called 'review-template' in the html
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;

  // there will always be 1 star because it is a part of the template
  //  so we start at i=1 for less than rating rather than i=0 for less than rating
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode(); //find the <img> in the template and copy it
    tmpl.querySelector('.rating').appendChild(img);    //find the parent(class='rating') and append it
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

// when the page is loaded, call all the functions to load the content

//********************* BEST PRACTICE FOR BELOW ************************************************* */
// if your functions to initialize the page content might take a "little" while to run
// they may not complete the page initialization before the browser shows the browser creates the DOM
// It's a good practice to NOT initialize the page until the DOM has been created
// if you try to manipulate the DOM, like initialization before it's created, the changes are ignored
//
// the DOMContentLoaded event triggers/happens when the DOM has been fully created

// add an event handler to the document to wait until the DOM is full created to do anything

document.addEventListener('DOMContentLoaded', () => {
  setPageTitle(); // set the product reviews page title
  setPageDescription(); // set the product reviews page description
  displayReviews(); // display all of the product reviews on our page
})


/**
 * Add an event listener to the add review button to add a review using helper function
 * 
 * Add review button has id="btnToggleForm"
 */
const theAddReviewButton = document.getElementById('btnToggleForm');
theAddReviewButton.addEventListener('click', (eventObject) => {
  showHideForm()  // call the helper function to show the form
})

/**
 * Add an event listener to the save review button to save a review to the array using helper functions
 * 
 * Save review button has id="btnSaveReview"
 */
const theSaveReviewButton = document.getElementById('btnSaveReview')  //get a reference tot save review button
theSaveReviewButton.addEventListener('click', (eventObject) => {        // if saveReview is clicked, call the helper method to save it
  // the default action for a form is to do an HTTP Request to a URL
  // we don't want this form to do that because (1) we don' have an API to handle the request
//                                              (2) WE are handling the data in the form
  eventObject.preventDefault()  //****** disable the default processing of a form
  saveReview()

})


// These are the Event Handlers and helper functions for the page
/**
 * Take an event on the description and swap out the description for a text box.
 *  using the helper function toggleDescriptionEdit() amd exidDescriptionEdit()
 * 
 *  Every event handler is passed an Event object containing information about the event
 * @param {Event} event the event object
 */


 // as the document to add an Event listener to the description on the page (class="description")
 const theDescription = document.querySelector('.description'); // get a reference to the description
 //   .addEventListener add an event handler to an html element
 //   .addEventListener 2 parameters(event-to-listen-for, function-to-handle-the-event) - the function is frequently an anon-func 
 // add event handler for the 'click' even on the description and run the anon-func when it happens
 theDescription.addEventListener('click', (eventObject) => {
        toggleDescriptionEdit(eventObject.target)   //call the helper function with what was clicked
                                                    //.target in the Even is a reference to what had the Event
                                                    // here .target is the description on the page
 });
// Add an Event Handler to the input box to save the new text when the user presses
const theTextBox = document.getElementById('inputDesc') //get reference to text box (id='inputDesc')
theTextBox.addEventListener('keyup', (eventObject) => { //when keyup happens in the text box, call the anon-func
        if (eventObject.key === 'Enter') {
          exitDescriptionEdit(event.target, true)
        }
        else {
          if ( eventObject.key === 'Escape'){ // only want to exit and discard if the Escape key was pressed
            exitDescriptionEdit(eventObject.target, false)  // call the helper function with theText reference box
                                                            // and false content will be discarded

        }
      }
});




 //********** Helper Function to toggle whether the input box for a new description is displayed or not ************

function toggleDescriptionEdit(desc) {      //receive a reference to the description on the page
  const textBox = desc.nextElementSibling;  // get a reference to the next sibling of desc - go to desc element, give me next sibling element
  textBox.value = description;              // set the input element to the original initial value in this code
  // .classList represents all the class currently assigned to an element
  textBox.classList.remove('d-none');       //un-hide the input element(textBox ->desc.nextElementSibling -> html <input>) - remove the 'd-none' class from it
  desc.classList.add('d-none');             // hide the current description - add the 'd-none' class to it
  textBox.focus();                          // put the cursor in the text box(give it focus)
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */

 // helper function to save any new description and un-hide the description
 // it has two parameters: the inputbox with the new text and boolean if true saves the new text and if false doesn't
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;  // get a reference to the description element - previous sibling to the text box
  if (save) {                                 // if we're supposed to save the new text
    desc.innerText = textBox.value;           // set the description to the new text
}                                             // otherwise do nothing
  textBox.classList.add('d-none');            // hide the input text box
  desc.classList.remove('d-none');            // un-hide the description
}



//******************* */ Helper Functions to handle adding a review **********************************************
/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form');          // get a reference to the form
  const btn = document.getElementById('btnToggleForm'); // get a reference to the add review button

  if (form.classList.contains('d-none')) {  // if the form is hidden
    form.classList.remove('d-none');        // un-hide it
    btn.innerText = 'Hide Form';            // change the button text in the add reviews
  document.getElementById('name').focus();  // set the focus tot he add review (now Hide form) button
  } else {                                  // if the form is not hidden
    resetFormValues();                      // reset the values using helper function
    form.classList.add('d-none');           // hide the form
    btn.innerText = 'Add Review';           // change the button text to AddReview
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {
  // We need to save the data in the form to an object and add the object to the reviews array

  // we need to get references to the data in the form
  
    const newName = document.getElementById('name');
    const newTitle = document.getElementById('title');
    const newRating = document.getElementById('rating');
    const newReview = document.getElementById('review');

  // we need to have an object to store the form data into
  // copy the data from the form into the properties of the object
  const aReview = {
    reviewer: newName.value, //copy the value from the name field in the form to the object
    title: newTitle.value,
    rating: newRating,
    review: newReview
  }
  
  // Add the object to the reviews array
reviews.push(aReview) // add the new review object to the end of the reviews array

// we have the new review in the JavaScript array, but we need to add it to the DOM to be displayed
// the helper function displayReview() which will add a review to the DOM
displayReview(aReview)
showHideForm();       // Hid the form since we are done with it
}
