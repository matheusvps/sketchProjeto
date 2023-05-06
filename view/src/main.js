import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store/index";
import axios from "axios";
import "./quasar";
import "animate.css/animate.min.css";
import i18n from "@/languages/i18n";

axios.defaults.baseURL = "http://localhost:8080";

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  i18n,
  render: (h) => h(App),
}).$mount("#app");
