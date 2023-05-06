<template>
  <div>
    <h1 class="animated animation animate__tada">{{ $t("school") }}</h1>
    <LanguageSelector />
  </div>
</template>

<script>
import LanguageSelector from "@/components/tools/LanguageSelector.vue";

export default {
  components: {
    LanguageSelector,
  },
};
</script>
