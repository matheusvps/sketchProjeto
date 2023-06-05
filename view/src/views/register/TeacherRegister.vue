<template>
  <div class="container">
    <h1 class="title">{{ $t("teacher.create") }}</h1>

    <div class="form-group">
      <label class="label">{{ $t("name") }}:</label>
      <q-input v-model="name" class="input" />
    </div>

    <div class="form-group">
      <label class="label">{{ $t("email") }}:</label>
      <q-input v-model="email" class="input" />
    </div>

    <div class="form-group">
      <label class="label">{{ $t("age") }}:</label>
      <q-input v-model="age" type="number" class="input" />
    </div>

    <div class="form-group">
      <label class="label">{{ $t("teacher.subject") }}:</label>
      <q-input v-model="subject" class="input" />
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
      email: "",
      subject: "",
      yearsTeached: 0
    };
  },
  computed: {
    ...mapState(["teachers"]),
    proximoId() {
      if (this.teachers) return this.teachers.length + 1;
      return 1;
    },
  },
  methods: {
    ...mapActions(["createTeacher"]),
    async create() {
      const teacher = {
        id: this.proximoId,
        name: this.name,
        age: this.age,
        email: this.email,
        subject: this.subject,
        yearsTeached: []
      };
      await this.$store.dispatch("createTeacher", teacher);
      this.$q.notify({
        message: this.$t("teacherCreated"),
        color: "positive",
        timeout: 3000,
      });
      setTimeout(() => {
        this.$router.push(`/teachers/${teacher.id}`);
      }, 2000);
    },
  },
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
