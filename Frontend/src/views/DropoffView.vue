<template>
  <div>
    <div class="block">
      <h1>Drop-off </h1>
      <input class="input" v-model="trackingnum" placeholder="Enter Tracking Number" />
      <div>
        <button class="button" @click="saveDropoff(),clearMessage()">Submit <span> </span></button>
        <p class="success">{{ msg }}</p>
        <p class="error">{{ err }}</p>
      </div>


    </div>
  </div>
</template>
  
<script>
import axios from 'axios';
export default {
  data() {
    return {
      trackingnum: "",
      msg: "",
      err: "",
    }
  },
  methods: {
    clearMessage() {
      // This method will be executed after 10 seconds
      setTimeout(() => {
        this.msg = "";
        this.err="";
      }, 6000)
    },
    async track() {
      const res = await axios.get('http://localhost:8080/');
      console.log(res)
    },
    async saveDropoff() {
      const storeID = this.$store.getters.getStoreid;
      const timeStamp = new Date().toDateString();
      const dropoff = {
        tracking: this.trackingnum,
        storeID: storeID,
        timeStamp: timeStamp,
      }
      await axios.post("http://localhost:8080/saveDropoff", dropoff)
        .then((res) => {

          this.msg = "Dropoff saved successfully";
          this.trackingnum="";
        }).catch((err) => {
          this.err = "Dropoff saving failed...*_*"
        })

    }
  },

  mounted() {
    if (!this.$store.getters.getStoreid && !this.$store.state.storeid) {
      this.$router.push({ name: 'Login' })
    }
  },
}
</script>
  
<style scoped>
.success{
  color: green;
}
.error{
  color: red;
}

.input {
  padding: 10px 20px;
  margin-top: 20px;
  font: 900;
  font-size: larger;
  border: 2px solid black;
  outline: none;
  border-radius: 25px;
  width: 300px;

}

.block {
  background-color: rgb(255, 255, 255);
  box-shadow: inset;
  justify-content: center;
  align-items: center;
  color: black;
  padding: 20px;
  margin: 20px;
  border-radius: 10px;
  box-shadow: -1px 2px 19px 0px rgba(119, 119, 119, 0.75);

}

.button {
  padding: 10px 20px;
  margin: 15px 0px;
  font: 900;
  font-size: larger;
  border: none;
  outline: none;
  border-radius: 25px;
  width: 130px;
  background-color: #2F855A;
  color: white;
}

.button:hover {
  color: #39a871;
  box-shadow: -1px 2px 19px 0px #2f855ab6;
  font-weight: 400;
  color: white;

}
</style>