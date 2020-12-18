<!--
  File:         PlayerCardHeader.vue
  Author:       Michael Barton
  Description:  The header (number and name) of the player card that appears for each player on the Roster page
-->

<template>
  <div class="playerCardHeader">
    <div class="playerCardHeaderNumber">{{ number }}</div>
    <div class="playerCardHeaderName">{{ name }}</div>
  </div>
</template>

<script>
export default {
  name: "PlayerCardHeader",
  props: {
    number: Number,
    name: String
  }
};
</script>

<style scoped>
.playerCardHeader {
  height: 40px;
  width: 100%;
  background-color: lightgray;
  border-radius: 10px 10px 0 0;
}

.playerCardHeaderName,
.playerCardHeaderNumber {
  display: inline-block;
  padding: 10px 0;
  height: 100%;
}

.playerCardHeaderNumber {
  background-color: darkorange;
  width: 16%;
  border-radius: 10px 0 0 0;
}

.playerCardHeaderName {
  width: 84%;
  text-align: right;
  padding-right: 15px;
}
</style>