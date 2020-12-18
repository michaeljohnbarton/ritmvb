<!--
  File:         ContactUsContent.vue
  Author:       Michael Barton
  Description:  The content of the Contact Us page, displays team's and officers' contact information
-->

<template>
  <div class="contactUsContent">
    <div id="teamContact">
      <p>{{ content.text1 }}</p>
      <a id="teamEmail" :href="mailToLink">{{ content.email }}</a>
      <p>{{ content.text2 }}</p>
    </div>
    <div id="officerContacts">
      <ContactUsOfficer v-for="officer in officers" :key="officer.email" :officer="officer"></ContactUsOfficer>
    </div>
  </div>
</template>

<script>
export default {
  name: "ContactUsContent",
  components: {
    ContactUsOfficer: () =>
      import("@/components/contactUs/ContactUsOfficer.vue")
  },
  props: {
    content: Object,
    officers: Array
  },
  computed: {
    mailToLink: function() {
      return "mailto:" + this.content.email;
    }
  }
};
</script>

<style scoped>
.contactUsContent {
  padding: 40px;
}

a#teamEmail {
  font-weight: bold;
  display: inline-block;
  margin: 20px;
}

#officerContacts {
  margin-top: 30px;
}

@media only screen and (max-width: 600px) {
  .contactUsContent {
    padding: 15px;
  }

  #officerContacts {
    margin-top: 15px;
  }
}
</style>