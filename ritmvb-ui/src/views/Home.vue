<!--
  File:         Home.vue
  Author:       Auto-generated, Michael Barton
  Description:  The home page for this website
-->

<template>
  <div class="home">
    <Page>
      <PageContent :title="titleText">
        <div id="homeContent">
          <HomeCard v-for="homeCard in homeCards" :key="homeCard.title" :tab="homeCard"></HomeCard>
        </div>
      </PageContent>
    </Page>
  </div>
</template>

<script>
import axios from "axios";
import { serverURL } from "@/main.js";

export default {
  name: "Home",
  components: {
    Page: () => import("@/components/general/Page.vue"),
    PageContent: () => import("@/components/general/PageContent.vue"),
    HomeCard: () => import("@/components/home/HomeCard.vue")
  },
  data: function() {
    return {
      titleText: null,
      homeCards: null
    };
  },
  mounted: function() {
    this.getAndSetTitle();
    this.getAndSetHomeCards();
  },
  methods: {
    getAndSetTitle: function() {
      axios.get(serverURL + "/home/title").then(response => {
        this.titleText = response.data;
      });
    },
    getAndSetHomeCards: function() {
      axios.get(serverURL + "/home/homeCards").then(response => {
        this.homeCards = response.data;
      });
    }
  }
};
</script>

<style scoped>
#homeContent {
  padding: 20px 0 10px 0;
}
</style>
