<template>
  <div>
    <q-item>
      <q-item-section>
        <q-item-label caption class="text-gray-8">{{ $t("system") }}</q-item-label>
      </q-item-section>
    </q-item>
    <nav>
      <q-tabs
        class="q-tabs-centered bg-dark-blue text-white shadow-2"
        align="justify"
        position="top"
        dense
      >
        <q-route-tab :to="{ name: 'home' }">{{ $t("start") }}</q-route-tab>

        <q-route-tab :to="{ name: 'allLists' }">{{ $t("register") }}</q-route-tab>

        <q-route-tab :to="{ name: 'addStudent' }">{{ $t("student.create") }}</q-route-tab>

        <q-route-tab :to="{ name: 'addTeacher' }">{{ $t("teacher.create") }}</q-route-tab>

        <q-route-tab :to="{ name: 'addEmployee' }">{{ $t("employee.create") }}</q-route-tab>
      </q-tabs>
    </nav>
    <div class="content">
      <router-view class="q-page-container" />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.q-tabs-centered {
  display: flex;
  justify-content: center;
}

.content {
  margin-top: 50px;
  /* height of the tabs */
}

.q-page-container {
  padding: 20px;
}

.text-gray-8 {
  color: #999;
}

.bg-dark-blue {
  background-color: #0d47a1;
}

.shadow-2 {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.q-tabs-centered .q-tab {
  padding: 10px 20px;
}

.q-tabs-centered .q-tab__content {
  font-size: 14px;
}

.q-route-tab {
  text-decoration: none;
  color: #fff;
  transition: background-color 0.2s;
}

.q-route-tab:hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.q-route-tab.active {
  background-color: rgba(255, 255, 255, 0.2);
}
</style>
