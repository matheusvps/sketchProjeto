<template>
  <div class="text-center">
    <q-list>
      <q-item dense>
        <q-item-section>
          <router-link :to="{ name: 'studentList' }">
            <q-btn label="Lista de Estudantes" />
          </router-link>
        </q-item-section>
      </q-item>
      <q-item dense>
        <q-item-section>
          <router-link :to="{ name: 'teacherList' }">
            <q-btn label="Lista de Professores" />
          </router-link>
        </q-item-section>
      </q-item>
      <q-item dense>
        <q-item-section>
          <router-link :to="{ name: 'employeeList' }">
            <q-btn label="Lista de Empregados" />
          </router-link>
        </q-item-section>
      </q-item>
    </q-list>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          label: "Student List",
          route: { name: "StudentList" },
        },
        {
          label: "Teacher List",
          route: { name: "TeacherList" },
        },
        {
          label: "Employee List",
          route: { name: "EmployeeList" },
        },
      ],
    };
  },
  methods: {
    navigate(route) {
      this.$router.push(route);
    },
  },
};
</script>
