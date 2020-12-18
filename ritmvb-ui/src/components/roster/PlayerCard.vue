<!--
  File:         PlayerCard.vue
  Author:       Michael Barton
  Description:  The player card that appears for each player on the Roster page
-->

<template>
  <div class="playerCard">
    <PlayerCardHeader :number="player.number" :name="player.name"></PlayerCardHeader>
    <PlayerCardImage :image="player.imageURL"></PlayerCardImage>
    <PlayerCardContent
      :position="player.position"
      :year="player.year"
      :height="player.height"
      :major="player.major"
      :hometown="player.hometown"
    ></PlayerCardContent>
  </div>
</template>

<script>
export default {
  name: "PlayerCard",
  components: {
    PlayerCardHeader: () => import("@/components/roster/PlayerCardHeader.vue"),
    PlayerCardImage: () => import("@/components/roster/PlayerCardImage.vue"),
    PlayerCardContent: () => import("@/components/roster/PlayerCardContent.vue")
  },
  props: {
    player: Object
  }
};
</script>

<style scoped>
.playerCard {
  display: inline-block;
  margin: 0 10px 20px 10px;
  width: 300px;
  height: 320px;
  border-radius: 10px;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.25);
}

@media only screen and (max-width: 600px) {
  .playerCard {
    margin: 10px 0 10px 0;
  }
}
</style>