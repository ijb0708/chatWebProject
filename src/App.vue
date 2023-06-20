<template>
  <v-app id="app">
    <customHeader />
    <v-main no-scrollbar>
      <router-view />
    </v-main>
    <customFooter />
  </v-app>
</template>

<script>
import customHeader from '@/components/customHeader.vue';
import customFooter from '@/components/customFooter.vue';
export default {
  name: 'App',
  components: {
    customHeader,
    customFooter
  }
}
</script>