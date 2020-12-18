<!--
  File:         ContactUs.vue
  Author:       Michael Barton
  Description:  The Contact Us view which displays contact information for the club
-->

<template>
  <div class="contactUs">
    <Page>
      <PageContent :title="title">
        <ContactUsContent :content="content" :officers="officers"></ContactUsContent>
      </PageContent>
    </Page>
  </div>
</template>

<script>
import axios from "axios";
import { serverURL } from "@/main.js";

export default {
  name: "ContactUs",
  components: {
    Page: () => import("@/components/general/Page.vue"),
    PageContent: () => import("@/components/general/PageContent.vue"),
    ContactUsContent: () =>
      import("@/components/contactUs/ContactUsContent.vue")
  },
  data: function() {
    return {
      title: null,
      content: null,
      officers: null
    };
  },
  mounted: function() {
    this.getAndSetTitle();
    this.getAndSetContent();
    this.getAndSetOfficers();
  },
  methods: {
    getAndSetTitle: function() {
      axios.get(serverURL + "/contactUs/title").then(response => {
        this.title = response.data;
      });
    },
    getAndSetContent: function() {
      axios.get(serverURL + "/contactUs/content").then(response => {
        this.content = response.data;
      });
    },
    getAndSetOfficers: function() {
      axios.get(serverURL + "/contactUs/officers").then(response => {
        this.officers = response.data;
      });
    }
  }
};
</script>
