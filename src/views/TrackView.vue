<template>
  <div class="outer">
    <div class="block">
      <h1>Tracking </h1>
      <input class="input" v-model="trackingnum" placeholder="Enter Tracking Number" />
      <div>
        <button class="button" @click="track()">Track <span> </span></button>
      </div>

    </div>
    <div v-if="from" class="tracking-div">
      <WelcomeItem>
          <template #icon>
            <i class="fa-solid fa-house"></i>
          </template>
          <template #heading>{{ from.name }}</template>
          {{ from.address1 }}<br>
          {{ from.address2 }}<br>
          {{ from.city }} {{ from.state }} {{ from.zipcode }}

        </WelcomeItem>
        <WelcomeItem v-for="store in dropoff_stores" :key="store">
            <template #icon>
              <i class="fa-solid fa-store"></i>
            </template>
            <template #heading>{{ store[3] }} </template>
            {{ store[2] }} <br>
            {{ store[4] }}

        </WelcomeItem>
        <WelcomeItem>
          <template #icon>
            <i class="fa-solid fa-location-crosshairs" style="color: #ff0000;"></i>
          </template>
          <template #heading><h3 style="color:rgb(255, 0, 0);  font-weight: 800;">{{ status }}</h3></template>

        </WelcomeItem>
        <WelcomeItem>
          <template #icon>
            <i class="fa-solid fa-house"></i>
          </template>
          <template #heading>{{ to.name }}</template>
          {{ to.address1 }}<br>
          {{ to.address2 }}<br>
          {{ to.city }} {{ to.state }} {{ to.zipcode }}

        </WelcomeItem>
    </div>
  </div>
</template>
  
<script>

import axios from 'axios'
import WelcomeItem from '../components/WelcomeItem.vue'
export default {
  components: {
    WelcomeItem
  },
  data() {
    return {
      trackingnum: "",
      dropoff_stores: "",
      from: "",
      to: "",
      package: "",
      status: "",
    }
  },
  methods: {
    async getUserDetails() {
      // console.log("Userdatils method called")

      await axios.post("http://localhost:8080/getCustomerByKey?phone=" + this.package.fromUserId, {})
        .then((res) => {
          this.from = res.data
          console.log(this.from)
        }).catch((err) => {
          //none
          console.log(err)
        });
      await axios.post("http://localhost:8080/getCustomerByKey?phone=" + this.package.toUserId, {})
        .then((res) => {
          this.to = res.data
          console.log(this.to)
        }).catch((err) => {
          //none
          console.log(err)
        });

    },
    async packageDetails() {
      await axios.get("http://localhost:8080/getPackage?trackingNum=" + this.trackingnum)
        .then((res) => {
          // console.log(res)
          this.package = res.data;
          console.log(this.package);
          this.status = this.package.status;
          this.getUserDetails();

        }).catch((err) => {
          console.log(err)
        })
    },
    async track() {
      this.packageDetails()
      this.dropoff_stores=""
      await axios.get("http://localhost:8080/trackPackage?trackingNum=" + this.trackingnum)
        .then((res) => {
          console.log(res.data)
          this.dropoff_stores = res.data;

        }).catch((err) => {
          console.log(err)
        })
    }
  }
}
</script>
  
<style scoped>
.input {
  padding: 10px 20px;
  margin: 20px 0px 0px 0px;
  font: 900;
  font-size: larger;
  border: 2px solid black;
  outline: none;
  border-radius: 25px;
  width: 300px;

}

.outer {
  display: flex;
  justify-content: center;
  align-items: center;
  /* flex-direction: column; */
}

.block {
  background-color: rgb(255, 255, 255);
  /* box-shadow: inset; */
  /* display: flex;
  flex-direction: column; */
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

.tracking-div {
  /* display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column; */
  /* background-color: black; */
  color: white;
  width: 50vw;
  min-height: 80vh;
  border-radius: 10px;
  padding: 10px;
  margin-left: 200px;
}

.tracking-div .inner {
  padding: 10px;
  background-color: white;
  border-radius: 10px;


  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  width: 250px;
  color: black;
  margin: 10px;
  box-shadow: -1px 2px 10px 0px #2f855ab0;
}

.loop_div {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.status_msg {
  font-weight: 600;
  color: green;
}

i {
  color: #2f855a;
  background-color: #2f855a;
}

.tracking-div h1 {
  font-size: 20px;
  font-weight: 800;
  color: #2F855A;
}
</style>