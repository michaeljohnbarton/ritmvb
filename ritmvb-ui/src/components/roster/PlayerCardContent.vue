<!--
  File:         PlayerCardContent.vue
  Author:       Michael Barton
  Description:  The content (position, year, height, major and hometown) of the player card 
                that appears for each player on the Roster page
-->

<template>
  <div class="playerCardContent">
    <div>
      <div class="playerCardContentHeader">Position:</div>
      <div class="playerCardContentItem">{{ position }}</div>
    </div>
    <div>
      <div class="playerCardContentHeader">Year:</div>
      <div class="playerCardContentItem">{{ year }}</div>
    </div>
    <div>
      <div class="playerCardContentHeader">Height:</div>
      <div class="playerCardContentItem">{{ height }}</div>
    </div>
    <div>
      <div class="playerCardContentHeader">Major:</div>
      <div class="playerCardContentItem">{{ major }}</div>
    </div>
    <div>
      <div class="playerCardContentHeader">Hometown:</div>
      <div class="playerCardContentItem">{{ hometown }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PlayerCardContent",
  props: {
    position: String,
    year: Number,
    height: String,
    major: String,
    hometown: String
  }
};
</script>

<style scoped>
.playerCardContent {
  width: 100%;
  border-radius: 0 0 10px 10px;
  margin-top: 4px;
}

.playerCardContentHeader,
.playerCardContentItem {
  display: inline-block;
  text-align: left;
  padding: 1px 0 1px 0;
}

.playerCardContentHeader {
  width: 100px;
  padding-left: 10px;
}

.playerCardContentItem {
  width: 200px;
}
</style>