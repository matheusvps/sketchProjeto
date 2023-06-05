<template>
  <div class="container">
    <h1 class="title">{{ $t("student.create") }}</h1>

    <div class="form-field">
      <label class="label">{{ $t("name") }}:</label>
      <q-input v-model="name" class="input" dense outlined />
    </div>

    <div class="form-field">
      <label class="label">{{ $t("email") }}:</label>
      <q-input v-model="email" class="input" dense outlined />
    </div>

    <div class="form-field">
      <label class="label">{{ $t("age") }}:</label>
      <q-input v-model.number="age" class="input" type="number" dense outlined />
    </div>

    <div class="form-field">
      <label class="label">{{ $t("class") }}:</label>
      <q-input v-model.number="grade" class="input" type="number" dense outlined />
    </div>

    <q-btn type="submit" class="button" @click="create">{{ $t("create") }}</q-btn>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      name: "",
      age: 0,
      grade: 0,
      email: ""
    };
  },
  computed: {
    ...mapState(["students"]),
    proximoId() {
      if (this.students) return this.students.length + 1;
      return 1;
    }
  },
  methods: {
    ...mapActions(["createStudent"]),
    async create() {
      const student = {
        id: this.proximoId,
        name: this.name,
        email: this.email,
        age: this.age,
        grade: this.grade,
        biggestMark: 0,
        average: 0,
        lowestMark: 0,
        marks: []
      };
      await this.$store.dispatch("createStudent", student);
      this.$q.notify({
        message: this.$t("studentCreated"),
        color: "positive",
        timeout: 3000
      });
      setTimeout(() => {
        this.$router.push(`/students/${student.id}`);
      }, 2000);
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 400px;
  margin: 0 auto;
}

.title {
  font-size: 24px;
  margin-bottom: 20px;
  text-align: center;
}

.form-field {
  margin-bottom: 15px;
}

.label {
  font-size: 14px;
  font-weight: bold;
  margin-bottom: 5px;
}

.input {
  width: 100%;
}

.button {
  margin-top: 30px;
  width: 100%;
}
</style>
