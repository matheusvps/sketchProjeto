<template>
  <div>
    <q-btn @click="changeLanguage('en')" class="margem">English</q-btn>
    <q-btn @click="changeLanguage('pt')" class="margem">Português</q-btn>
  </div>
</template>

<script lang="ts">
export default {
  name: "LanguageSelector",
  methods: {
    changeLanguage(lang) {
      this.$i18n.locale = lang;
    },
  },
};
</script>

<style scoped>
.margem {
  margin: 10px;
}
</style>
