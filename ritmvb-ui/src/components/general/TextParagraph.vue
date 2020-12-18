<!--
  File:         TextParagraph.vue
  Author:       Michael Barton
  Description:  A basic container to display an array of paragraphs, for use within PageContent
-->

<template>
  <div class="textParagraph">
    <p v-for="text in listOfText" :key="text">{{ text }}</p>
  </div>
</template>

<script>
export default {
  name: "TextParagraph",
  props: {
    listOfText: Array
  }
};
</script>

<style scoped>
.textParagraph {
  margin-top: 30px;
}

p {
  margin: 0;
  padding: 0 50px 30px 50px;
  text-align: left;
}

@media only screen and (max-width: 600px) {
  p {
    padding: 0 20px 20px 20px;
  }
}
</style>