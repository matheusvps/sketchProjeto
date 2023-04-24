<template>
  <div>
    <div v-if="currentStudent">
      <h1>{{ currentStudent.name }}</h1>
      <p>{{ $t("average") }}: {{ currentStudent.average }}</p>
      <p>{{ $t("biggestMark") }}: {{ currentStudent.biggestMark }}</p>
      <p>{{ $t("lowestMark") }}:{{ currentStudent.lowestMark }}</p>
      <p>{{ $t("testsNumber") }}: {{ tests }}</p>
      <q-btn>
        <router-link
          :to="{
            name: 'addMark',
            params: { id: parseInt(currentStudent.id) },
          }"
        >
          {{ $t("addTest") }} {{ currentStudent.name }}
        </router-link>
      </q-btn>
      <q-btn @click="showDialog = true">{{ $t("deleteTest") }}</q-btn>
    </div>
    <div v-else>{{ $t("loadingStudent") }}</div>

    <delete-dialog v-if="showDialog" @confirmed="deleteConfirm" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import DeleteDialog from "@/components/DeleteDialog.vue";

export default {
  components: {
    DeleteDialog,
  },
  data() {
    return {
      showDialog: false,
    };
  },
  computed: {
    ...mapState([
      "currentStudent",
      "average",
      "biggestMark",
      "lowestMark",
      "tests",
    ]),
  },
  methods: {
    ...mapActions([
      "getStudentById",
      "deleteStudent",
      "getMarksNumber",
      "getMarksNumber",
      "getStudents",
    ]),
    async seekStudent(id) {
      await this.getStudentById(id);
      await this.getMarksNumber(id);
    },
    async deleteConfirm() {
      await this.deleteStudent(this.currentStudent);
      await this.getStudents(); // atualiza a lista de alunos após a exclusão
    },
  },
  mounted() {
    this.getStudentById(this.$route.params.id);
  },
};
</script>

<style scoped>
.q-btn--negative {
  color: #fff;
}
</style>
