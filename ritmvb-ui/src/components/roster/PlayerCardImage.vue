<!--
  File:         PlayerCardImage.vue
  Author:       Michael Barton
  Description:  The image for the player card that appears for each player on the Roster page
-->

<template>
  <div class="playerCardImage">
    <v-img :src="image" contain></v-img>
  </div>
</template>

<script>
export default {
  name: "PlayerCardImage",
  props: {
    image: String
  }
};
</script>

<style scoped>
.playerCardImage {
  height: 150px;
  padding: 2px 0;
}

.v-image {
  height: 146px;
}
</style>