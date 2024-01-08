<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button @click="server()">Name</button>
    <p>{{ names }}</p>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  data() {
    return {
      names: ""
    }
  },
  methods: {
    async server() {
      this.names = "Balaji";
      const res = await axios.get('http://localhost:8080/');
      console.log(res)
      this.names = res.data;

    }
  }
}
</script>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
