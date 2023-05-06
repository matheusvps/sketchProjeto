<template>
  <q-dialog v-model="showDialog">
    <q-card>
      <q-card-section class="text-center">{{
        $t("deleteQuest")
      }}</q-card-section>
      <q-card-actions align="center">
        <q-btn color="negative" @click="showDialog = false">
          {{ $t("cancelDelete") }}
        </q-btn>
        <q-btn color="positive" @click="confirm">
          {{ $t("confirmDelete") }}
        </q-btn>
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
export default {
  props: {
    message: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      showDialog: true,
    };
  },
  methods: {
    confirm() {
      this.$emit("confirmed");
      this.showDialog = false;
      this.$router.push("/student-list");
    },
  },
};
</script>
