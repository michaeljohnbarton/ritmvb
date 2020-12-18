/*
  File:         vue.config.js
  Author:       Michael Barton
  Description:  Allows for instant prototyping when running "npm run serve"
*/

module.exports = {
  "devServer": {
    "host": "localhost"
  },
  "transpileDependencies": [
    "vuetify"
  ]
}