import Vue from "vue";
import VueI18n from "vue-i18n";
import en from "@/languages/en";
import ptBR from "@/languages/pt-br";

Vue.use(VueI18n);

const i18n = new VueI18n({
  locale: "en",
  fallbackLocale: "pt_BR",
  messages: {
    en: en,
    pt_BR: ptBR,
  },
});

export default i18n;
