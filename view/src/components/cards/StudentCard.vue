<template>
  <div>
    <div>
      <h1>Estudante Exemplo></h1>
      <p>Média do Estudante : 5</p>
      <p>Email do Estudante : exemplo@gmail.com</p>
      <p>Idade do Estudante : 13</p>
      <p>Maior Nota do Estudante: 8</p>
      <p>Menor Nota do Estudante: 5</p>
      <p>Número de Testes: 4</p>
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

    <delete-dialog v-if="showDialog" @confirmed="deleteConfirm" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import DeleteDialog from "@/components/tools/DeleteDialog.vue";

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
      "age",
      "email",
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
