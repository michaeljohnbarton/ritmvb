<!--
  File:         Page.vue
  Author:       Michael Barton
  Description:  A wrapping container used solely to define the boundaries of the content on the page.
                Any content (not including the navigation bar) on a specific page should be wrapped in this component.
-->

<template>
  <div class="page">
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: "Page"
};
</script>

<style scoped>
.page {
  padding-top: 100px;
  margin: 0 auto 25px auto;
  width: 80%;
}

@media only screen and (max-width: 600px) {
  .page {
    padding-top: 85px;
    width: 95%;
  }
}
</style>