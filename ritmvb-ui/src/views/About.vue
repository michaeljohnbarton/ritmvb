<!--
  File:         About.vue
  Author:       Auto-generated, Michael Barton
  Description:  The About view which displays information about the team
-->

<template>
  <div class="about">
    <Page>
      <PageContent :title="title">
        <TextParagraph :listOfText="text"></TextParagraph>
      </PageContent>
    </Page>
  </div>
</template>

<script>
import axios from "axios";
import { serverURL } from "@/main.js";

export default {
  name: "About",
  components: {
    Page: () => import("@/components/general/Page.vue"),
    PageContent: () => import("@/components/general/PageContent.vue"),
    TextParagraph: () => import("@/components/general/TextParagraph.vue")
  },
  data: function() {
    return {
      title: null,
      text: null
    };
  },
  mounted: function() {
    this.getAndSetTitle();
    this.getAndSetText();
  },
  methods: {
    getAndSetTitle: function() {
      axios.get(serverURL + "/about/title").then(response => {
        this.title = response.data;
      });
    },
    getAndSetText: function() {
      axios.get(serverURL + "/about/text").then(response => {
        this.text = response.data;
      });
    }
  }
};
</script>
