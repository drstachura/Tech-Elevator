<template>     <!-- contains the HTML for our component  -->
   <div class="main">  <!-- a Vue template MUST have a single div -->
      <!-- use a value from data in the JavaScript code in the html                  -->
      <!-- code name of the variable/attribute in a mustache expression              -->
      <!--      a mustache expression is enclosed in {{ }}                           -->
      <!-- use of mustache expression is referred to as one-way data binding         -->
      <!-- one-way data binding means data can flow from the JavaScript code to html -->
      <!-- two-way data binding means data can flow from the JavaScript code to html -->
      <!--                                      and from the html to the JavaScript  -->
      <h2> Product Reviews for {{title}}</h2>  <!-- we will add data to this tag in a minute -->
      <p class='description'>{{words}}</p>     <!-- we will add data to this tag in a minute  -->
   </div> 

</template>

<script>          // contains the JavaScript for our component
export default {  // expose the data in this JavaScript to Vue - allow Vue access to this data
    name: 'product-review',  // name of the component in kabob-case (matches name in html tag)
    data() {                 // data to be shared with Vue needs to be in a function called data()
        return {             // the data() function returns an object with the data to be shared with Vue
           title : 'Cigar Parties for Dummies',                                       // variable/attribute to share with Vue
           words : 'Host and plan the perfect cigar party for your squirelly friends' // variable/attribute to share with Vue
        }  // end of return
    } // end of data()
} // end of export

</script>

<style scoped> /* contains the CSS for our component */

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
</style>
