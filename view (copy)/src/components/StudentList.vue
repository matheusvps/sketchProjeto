<template>
  <div class="q-pa-md flex justify-center">
    <q-list separator>
      <q-item
        v-for="student in students"
        :key="student.id"
        style="max-width: 500px"
      >
        <q-item-section
          ><router-link
            :to="{ name: 'studentDetails', params: { id: student.id } }"
            >{{ student.name }}</router-link
          >
        </q-item-section>
      </q-item>
    </q-list>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["students"]),
  },
  async created() {
    await this.$store.dispatch("getStudents");
  },
};
</script>

<style scoped>
.box-gray {
  background-color: gray;
  padding: 10px;
  border-radius: 5px;
  margin-top: 5px;
}
.white-text {
  color: aliceblue;
  text-align: center;
  align-items: center;
  justify-content: center;
}
</style>
