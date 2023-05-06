import Vue from "vue";
import Quasar from "quasar/dist/quasar.umd.min.js";
import "quasar/dist/quasar.min.css";

Vue.use(Quasar, {
  plugins: {
    Dialog: {},
    Notify: {},
  },
});
