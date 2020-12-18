<!--
  File:         HomeCard.vue
  Author:       Michael Barton
  Description:  The home card that appears for each tab on the Home page
-->

<template>
  <v-btn class="homeCard" :to="tab.route">
    <h3 class="homeCardTitle">{{ tab.title }}</h3>
    <v-img class="homeCardImage" :src="tab.imageURL"></v-img>
  </v-btn>
</template>

<script>
export default {
  name: "HomeCard",
  props: {
    tab: Object
  }
};
</script>

<style scoped>
.homeCard {
  display: inline-block;
  width: 300px;
  height: 250px !important;
  border-radius: 10px;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.25);
  padding: 0 !important;
  margin: 0 10px 20px 10px;
}

.homeCardTitle {
  position: absolute;
  top: 10px;
  z-index: 1;
  border-radius: 10px;
  background-color: darkorange;
  padding: 10px 15px;
  color: white;
}

.homeCardImage {
  height: 250px;
  border-radius: 10px;
}

@media only screen and (max-width: 600px) {
  .homeCard {
    margin: 0 0 20px 0;
  }
}

@media only screen and (min-width: 600px) {
  .homeCard {
    margin: 0 10px 20px 10px;
  }
}

@media only screen and (min-width: 1200px) {
  .homeCard {
    margin: 30px;
  }
}

@media only screen and (min-width: 1400px) {
  .homeCard {
    margin: 50px 30px;
  }
}
</style>