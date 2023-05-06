<template>
  <div>
    <q-item>
      <q-item-section>
        <q-item-label caption class="text-gray-8">
          {{ $t("system") }}</q-item-label
        >
      </q-item-section>
    </q-item>
    <nav>
      <q-tabs
        class="q-tabs-centered bg-grey text-white shadow-2"
        align="justify"
        position="top"
        dense
      >
        <q-route-tab :to="{ name: 'home' }"> {{ $t("start") }} </q-route-tab>

        <q-route-tab :to="{ name: 'allLists' }">
          {{ $t("register") }}
        </q-route-tab>

        <q-route-tab :to="{ name: 'addStudent' }">
          {{ $t("studentcreate") }}
        </q-route-tab>

        <q-route-tab :to="{ name: 'addStudent' }">
          Criar Professor
        </q-route-tab>

        <q-route-tab :to="{ name: 'addStudent' }">
          Criar Empregado
        </q-route-tab>
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
  margin-top: 50px; /* altura das tabs */
}

.q-page-container {
  padding: 20px;
}
</style>
