<!--
  File:         App.vue
  Author:       Auto-generated, Michael Barton
  Description:  The main component of this entire website
-->

<template>
  <div id="app">
    <div id="nav">
      <router-link to="/"><img id="logo" src="./assets/ritLogo.png"></router-link>
      <p id="mobileTabTitle">{{ this.$route.name }}</p>
      <router-link class="routerTab" v-for="tab in tabs" :to="tab.route" :key="tab.title">{{ tab.title }}</router-link>
      <v-btn id="hamburgerMenu" dark icon @click.stop="drawer = !drawer">
        <v-icon>mdi-menu</v-icon>
      </v-btn>
    </div>
    <v-navigation-drawer v-model="drawer" temporary absolute right>
      <v-list>
        <v-list-item v-for="tab in tabs" :to="tab.route" :key="tab.title" link>
          <v-list-item-content class="v-list-item-content">
            <v-list-item-title class="v-list-item-title">{{ tab.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <router-view />
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      drawer: null,
      tabs: [
        { title: "Home", route: "/" },
        { title: "About", route: "/about" },
        // { title: "Schedule", route: "/schedule" },
        { title: "Roster", route: "/roster" },
        { title: "Contact Us", route: "/contactUs" }
      ]
    };
  }
};
</script>

<style>
html {
  overflow-y: auto !important;
}

html,
body {
  height: 100%;
  margin: 0;
  top: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  top: 0;
}

#logo {
  height: 50px;
  float: left;
  margin-left: 10px;
}

/* The navigation bar itself */
#nav {
  width: 100%;
  box-shadow: 0px 4px 2px -2px rgba(0, 0, 0, 0.2);
  padding: 10px 0 10px 0;
  text-align: right;
  background-color: darkorange;
  z-index: 2;
  position: fixed;
}

/* The navigation tabs in the header */
.routerTab {
  display: inline-block;
  padding: 8px 16px;
  margin: 9px 10px 0 0;
  font-weight: bold;
  color: white;
  text-decoration: none;
}

/* The active navigation tab in the header */
#nav a.router-link-exact-active {
  background-color: rgb(216, 111, 13);
  border-radius: 10px;
}

/* Hide the v-button by default */
#hamburgerMenu {
  display: none;
  margin-top: 8px;
}

.v-list-item-content {
  padding: 12px 0 !important;
}

.v-list-item-title {
  font-size: 20px !important;
  font-weight: bold !important;
}

/*  These class names were determined from the Chrome inspector, refers to the 
    container for the navigation tabs of the hamburger menu and the gray effect
    on the rest of the app when the menu is opened */
.v-navigation-drawer,
.v-overlay__scrim {
  position: fixed !important;
}

/*  Positions the tab title in the center of the nav bar
    Only show when hamburger menu is shown, see media query below */
#mobileTabTitle {
  display: none;
  color: white;
  font-weight: bold;
  font-size: 22px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

/* Display hamburger menu as new navigation */
@media only screen and (max-width: 750px) {
  .routerTab {
    display: none;
  }

  #hamburgerMenu {
    display: inline-flex;
  }

  #mobileTabTitle {
    display: inline-block;
  }
}

@media only screen and (max-width: 600px) {
  #logo {
    content:url("./assets/tiger.png")
  }
}
</style>
