<!--
  File:         PageContent.vue
  Author:       Michael Barton
  Description:  A basic container with a title located in the orange "header" of the component and expects another component 
                which is displayed in the bottom, white part.
                Meant to be used within a Page component and to be the only child component within that Page component.
                Has some CSS to make orange header look good and a shadow to make it pop up from the page.
-->

<template>
  <div class="pageContent">
    <h1>{{ title }}</h1>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: "PageContent",
  props: {
    title: String
  }
};
</script>

<style scoped>
.pageContent {
  width: 100%;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
}

h1 {
  margin: 0;
  background: linear-gradient(100deg, whitesmoke -150%, darkorange);
  padding: 30px;
  border-radius: 20px 20px 0 0;
  border-top-style: solid;
  border-right-style: solid;
  border-left-style: solid;
  border-width: thin;
  border-color: darkorange;
}

@media only screen and (max-width: 600px) {
  h1 {
    font-size: 23px;
    padding: 20px;
  }
}
</style>