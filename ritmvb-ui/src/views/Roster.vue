<!--
  File:         Roster.vue
  Author:       Michael Barton
  Description:  The Roster view which displays the roster of the current players
-->

<template>
  <div class="roster">
    <Page>
      <PlayerCard v-for="player in players" :key="player.name" :player="player"></PlayerCard>
    </Page>
  </div>
</template>

<script>
import axios from "axios";
import { serverURL } from "@/main.js";

export default {
  name: "Roster",
  components: {
    Page: () => import("@/components/general/Page.vue"),
    PlayerCard: () => import("@/components/roster/PlayerCard.vue")
  },
  data: function() {
    return {
      players: null
    };
  },
  mounted: function() {
    this.getAndSetPlayers();
  },
  methods: {
    getAndSetPlayers: function() {
      axios.get(serverURL + "/roster/players").then(response => {
        this.players = response.data;
      });
    }
  }
};
</script>
