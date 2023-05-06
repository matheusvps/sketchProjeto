<template>
  <div>
    <h1>{{ $t("createStd") }}</h1>
    <h3>{{ $t("name") }}:</h3>
    <q-input v-model="name" class="input q-field--auto-width" />
    <q-btn type="submit" class="button" @click="criar">{{
      $t("create")
    }}</q-btn>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      name: "",
    };
  },
  computed: {
    ...mapState(["students"]),
    proximoId() {
      if (this.students) return this.students.length + 1;
      return 1;
    },
  },
  methods: {
    ...mapActions(["createStudent"]),
    async criar() {
      const student = {
        id: this.proximoId,
        name: this.name,
        biggestMark: 0,
        average: 0,
        lowestMark: 0,
        marks: [],
      };
      await this.$store.dispatch("createStudent", student);
      this.$q.notify({
        message: this.$t("studentCreated"),
        color: "positive",
        timeout: 3000,
      });
      setTimeout(() => {
        this.$router.push(`/students/${student.id}`);
      }, 2000);
    },
  },
};
</script>

<style scoped>
.input {
  max-width: 300px;
  width: 100%;
  margin: 0 auto;
}
.button {
  margin-top: 20px;
  margin-bottom: 40px;
}
.name-custom {
  font-weight: bold;
  color: #333;
}
</style>
