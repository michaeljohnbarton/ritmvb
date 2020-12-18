<!--
  File:         ContactUsOfficer.vue
  Author:       Michael Barton
  Description:  The display for a specific officer's contact
-->

<template>
  <div class="contactUsOfficer">
    <h3>{{ officer.name }}</h3>
    <p>{{ officer.position }}</p>
    <a href="mailto:${officer.email}">{{ officer.email }}</a>
  </div>
</template>

<script>
export default {
  name: "contactUsOfficer",
  props: {
    officer: Object
  }
};
</script>

<style scoped>
.contactUsOfficer {
  display: inline-block;
  width: 250px;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  padding: 20px;
  margin: 15px;
}

a {
  font-weight: bold;
  display: inline-block;
}

a,
p {
  padding: 5px;
}

@media only screen and (max-width: 600px) {
  .contactUsOfficer {
    margin: 10px auto;
  }
}
</style>