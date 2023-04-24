<template>
  <div>
    <h1>{{ $t("addMark") }}</h1>
    <q-form @submit.prevent="addMark({ id, mark })">
      <q-input
        v-model="mark"
        type="number"
        :rules="[
          (val) => (val >= 0 && val <= 10) || 'A nota deve ser entre 0 e 10',
        ]"
        required
        label="Mark"
        no-error-icon
        class="input q-field--auto-width"
      />
      <q-btn type="submit" label="Adicionar" />
    </q-form>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { QInput, QForm, QBtn } from "quasar";

export default {
  components: {
    QInput,
    QForm,
    QBtn,
  },
  props: {
    id: {
      type: Number,
    },
  },
  data() {
    return {
      mark: null,
    };
  },
  methods: {
    ...mapActions(["addMark"]),
  },
};
</script>

<style scoped>
.input {
  max-width: 300px;
  width: 100%;
  margin: 0 auto;
}
</style>
