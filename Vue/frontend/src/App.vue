<template>
  <v-app>
    <NavMenuPage />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import NavMenuPage from "./views/layout/navigation/NavMenuPage.vue";

export default {
  name: "App",
  components: {
    NavMenuPage,
  },
  data: () => ({
    //
  }),
};
</script>
