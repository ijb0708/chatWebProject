/**
 * plugins/index.js
 *
 * Automatically included in `./src/main.js`
 */

// Plugins
import { loadFonts } from './webfontloader'
import vuetify from './vuetify'
import router from '../router'
import api from '../api'
import store from '../store'

export const registerPlugins = (app) => {
  loadFonts()
  app
    .use(vuetify)
    .use(router)
    .use(api)
    .use(store)
}
