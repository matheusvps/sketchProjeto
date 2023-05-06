<template>
  <div class="q-pa-md flex justify-center">
    <q-list separator>
      <q-item
        v-for="employee in employees"
        :key="employee.id"
        style="max-width: 500px"
      >
        <q-item-section
          ><router-link
            :to="{ name: 'employeeDetails', params: { id: employee.id } }"
            >{{ employee.name }}</router-link
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
    ...mapState(["employees"]),
  },
  async created() {
    await this.$store.dispatch("getEmployees");
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
