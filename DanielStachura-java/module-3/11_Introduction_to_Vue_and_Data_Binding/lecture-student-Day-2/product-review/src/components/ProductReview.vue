<template>     <!-- contains the HTML for our component  -->
   <div class="main">  <!-- a Vue template must have a single div -->
      <!-- use a value from data in the JavaScript code in the html                  -->
      <!-- code name of the variable/attribute in a mustache expression              -->
      <!--      a mustache expression is enclosed in {{ }}                           -->
      <!-- use of mustache expression is referred to as one-way data binding         -->
      <!-- one-way data binding means data can flow from the JavaScript code to html -->
      <!-- two-way data binding means data can flow from the JavaScript code to html -->
      <!--                                      and from the html to the JavaScript  -->
      <h2> Product Reviews for {{title}}</h2>  <!-- substitute the value in title -->
      <p class='author'>(by {{author}})</p>    <!-- substitute the value in author -->
      <p class='description'>{{words}}</p>     <!-- substitute the value in words -->
      
      <!-- add the summary for average rating and count of each number of stars -->
      <div class="well-display"> <!-- holds all the rating boxes -->
        
        <div class="well">  <!-- hold the number of average reviews -->
          <span class="amount"> {{averageRating}} </span>
          Average Rating
        </div>

        <div class="well">  <!-- hold the number of 1-star reviews -->
          <span class="amount"> {{numberOfOneStarReviews}} </span>
          1 Star Rating
        </div>

        <div class="well">  <!-- hold the number of 2-star reviews -->
          <span class="amount"> {{numberOfTwoStarReviews}} </span>
          2 Star Rating
        </div>

        <div class="well">  <!-- hold the number of 2-star reviews -->
          <span class="amount"> {{numberOfThreeStarReviews}} </span>
          3 Star Rating
        </div>

        <div class="well">  <!-- hold the number of 2-star reviews -->
          <span class="amount"> {{numberOfFourStarReviews}} </span>
          4 Star Rating
        </div>

        <div class="well">  <!-- hold the number of 2-star reviews -->
          <span class="amount"> {{numberOfFiveStarReviews}} </span>
          5 Star Rating
        </div>

      </div>

      <!-- add an element to our page for each element in the reviews array -->
        <!-- define <div> to hold all the review elements on the page -->
        <!-- add class="rating" to the <div> so it is styled as a rating defined <style> -->
        <!-- add a class="favorited" depending on the value in the reviews.favorited variable -->
        <!--    if reviews.favorited is true, the class="favorited" is added to the <div> -->
        <!--    if reviews.favorited is false, the class="favorited" is removed from the <div> -->
      
      <div class="review"
           v-bind:class="{ favorited: aReview.favorited }"
           v-for="aReview in reviews" v-bind:key="aReview.id"
      > <!-- end of div tag -->
      <h4>{{aReview.reviewer}}</h4>
      <!-- generate a star img based on the value of the rating -->
      <div class="rating">
        <img src="../assets/star.png"
            class="ratingStar"
             v-for="n in aReview.rating" v-bind:key="n"
        /> <!-- end of img tag -->
      </div>
      <h3>{{aReview.title}}</h3>
      <p>{{aReview.review}}</p>
      <p>
        Favorite?
        <input type="checkbox" v-model="aReview.favorited"/>
        </p>
      </div>
    </div>

</template>

<script>          // contains the JavaScript for our component
export default {  // expose the data in this JavaScript to Vue - allow Vue access to this data
    name: 'product-review',  // name of the component in kabob-case (matches name in html tag)
    data() {                 // data to be shared with Vue needs to be in a function called data()
        return {             // the data() function returns an object with the data to be shared with Vue
           title : 'Cigar Parties for Squirrels',                                       // variable/attribute to share with Vue
           words : 'Host and plan the perfect cigar party for your squirrely friends',  // variable/attribute to share with Vue
           author: 'Nutley McNutNut, Esquirrel',                                        // variable/attribute to share with Vue
           reviews: [
                      {
                      reviewer: "Rocky D'Flying Squirrel",
                      title: "What a book!",
                      review: "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
                      rating: 3,
                      favorited: false
                      },
                      {
                      reviewer: "Bullwinkle J. Moose",
                      title:  "Had a cigar party started in less than 4 hours.",
                      review: "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                      rating: 4,
                      favorited: false
                      },
                      {
                      reviewer: "Boris Badenov",
                      title:  "What every new entrepreneurs needs. A door stop.",
                      review:" When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                      rating: 1,
                      favorited: false
                      },
                      {
                      reviewer: "Natasha Fatale",
                      title: "And I thought I could write",
                      review:"There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                      rating: 3,
                      favorited: false
                      }
           ]
        }  // end of return
    }, // end of data()
    // computed section will compute/generate properties when data on the page changes
    computed:{

      averageRating(){   //calculate the average rating of all the reviews
        // sum all the rating values in the reviews array and divide them by the number of reviews

        let sum = this.reviews.reduce( (totalRating, aReview) => {
          return totalRating += aReview.rating  //add the current rating totalRating
        } // end of anon-func
        , 0) // end of .reduce() - ,0 initializes reducer(totalRating) and makes it a number
          return sum / this.reviews.length  // return the average as the sum / number of reviews
      }, // end of averageRating

      numberOfOneStarReviews(){ //a property that will be calculated everytime something on the page changes
      //go through the array one element at a time and count the number of 1-star reviews
      //we need to reduce the array to the number of one star reviews
      // use the array .reduce() function to accomplish this
      //.reduce() takes one parameter which is the variable to hold the result (reducer)
      //    and another parameter which is a function that takes the current element and modify the reducer
      //the return for the property is the value represented by the property
      //this.reviews is the array we want to reduce - this. indicates it is in this component
      
        return this.reviews.reduce( (currentCount, aReview)  => {
          if (aReview.rating === 1) { // if the current review has a rating of 1
            currentCount++            // count it
          }
          return currentCount         //return the currentCount
        }, 0) // end of anon-func and .reduce() - ,0 initializes reducer(currentCount) and makes it a number
      },      // end of numberOfOneStarReviews()

      numberOfTwoStarReviews(){
        return this.reviews.reduce( (currentCount, aReview) => {
          if (aReview.rating === 2) {
            currentCount++
          }
          return currentCount
        }, 0)
      }, // end of numberOfTwoStarReviews()

      numberOfThreeStarReviews(){
        return this.reviews.reduce( (currentCount, aReview) => {
          if (aReview.rating === 3) {
            currentCount++
          }
          return currentCount
        }, 0)
      },

      numberOfFourStarReviews(){
        return this.reviews.reduce( (currentCount, aReview) => {
          if (aReview.rating === 4) {
            currentCount++
          }
          return currentCount
        }, 0)
      },

      numberOfFiveStarReviews(){
        return this.reviews.reduce( (currentCount, aReview) => {
          if (aReview.rating === 5) {
            currentCount++
          }
          return currentCount
        }, 0)
      }
    }// end of computed:
} // end of export

</script>

<style scoped> /* contains the CSS for our component 
                  scoped on the <style> says this css only applies to this specific component 
                  if scoped is ommited the css will be applied to all components on the page
                  which may lead to weird, confusing and undesirable styling 
                  
                  Rule of thumb: ALWAYS use scoped in the <style> in a Vue component */

  div.main {
   margin: 1rem 0;
  }
  div.main div.well-display {
    display: flex;
    justify-content: space-around;
  }
  div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
  }
  div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
  }
  div.main div.review {
   border: 1px black solid;
   border-radius: 6px;
   padding: 1rem;
   margin: 10px;
  }
  div.main div.review.favorited {
   background-color: lightyellow;
  }
  div.main div.review div.rating {
   height: 2rem;
   display: inline-block;
   vertical-align: top;
   margin: 0 0.5rem;
  }
  div.main div.review div.rating img {
   height: 100%;
  }
  div.main div.review p {
    margin: 20px;
  }
  div.main div.review h3 {
   display: inline-block;
  }
  div.main div.review h4 {
    font-size: 1rem;
  }
  p.author {
   font-size: .75rem;
   font-style: italic;
  }
</style>
