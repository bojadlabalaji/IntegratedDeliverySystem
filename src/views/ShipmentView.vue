<template>
  <div class="block-outer">
    <div class="block">
      <div class="rows">
        <h1> Shipment Details </h1>
      </div>
      <div class="rows">
        <div class="colums from">
          <div class="popup-blur" v-show="from_popup">
            <div class="popup">
              From Details:
              <table>
                <tr>
                  <td>Name:</td>
                  <td>
                    <input v-model="from_name" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Address 1:</td>
                  <td>
                    <input v-model="from_address1" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Address 2:</td>
                  <td>
                    <input v-model="from_address2" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>City:</td>
                  <td>
                    <input v-model="from_city" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>State:</td>
                  <td>
                    <input v-model="from_state" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Zipcode:</td>
                  <td>
                    <input v-model="from_zip" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Phone:</td>
                  <td>
                    <input v-model="from_phone" type="tel" />
                  </td>
                </tr>
                <tr>
                  <td>Email:</td>
                  <td>
                    <input v-model="from_email" type="email" />
                  </td>
                </tr>
                <tr>
                  <td></td>
                  <td>
                    <button @click="from_popup_trigger(), saveFromCustomer()">Save</button>
                  </td>
                </tr>
              </table>
            </div>
          </div>
          <div>
            From:

            <input v-model="from_phone" style="width:150px" type="text">
            <button @click="getFromCustomerByPhone()">Find</button>
            <button @click="from_popup_trigger()">Add / Edit</button>
          </div>
          <div>
            <p>{{ from_name }}</p>
            <p>{{ from_address1 }}</p>
            <p>{{ from_address2 }}</p>
            <p>{{ from_city }} {{ from_state }} {{ from_zip }}</p>
            <p>{{ from_phone }}</p>
            <p>{{ from_email }}</p>
          </div>

        </div>
        <div class="colums">
          <div>
            <h4>Package Info:</h4>
          </div>
          <table>
            <tr>
              <td>Dimensions:</td>
              <td>
                <input v-model="l" style="width:50px" type="number" />In x
                <input v-model="w" style="width:50px" type="number" />In x
                <input v-model="h" style="width:50px" type="number" />In
              </td>
            </tr>
            <tr>
              <td>Weight:</td>
              <td><input v-model="wt" style="width:70px" type="number" /> Lbs</td>
            </tr>
            <tr>
              <td>Insurance: $</td>
              <td><input v-model="insr" style="width:70px" type="number" /></td>
            </tr>
            <tr>
              <td>Description: </td>
              <td><textarea v-model="desc" type="text" /></td>
            </tr>
          </table>

          <div>
            <button @click="getrates()">Get Rates</button>
          </div>
        </div>
      </div>
      <div class="rows">
        <div class="colums from">
          <div class="popup-blur" v-show="to_popup">
            <div class="popup">
              To Details:
              <table>
                <tr>
                  <td>Name:</td>
                  <td>
                    <input v-model="to_name" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Address 1:</td>
                  <td>
                    <input v-model="to_address1" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Address 2:</td>
                  <td>
                    <input v-model="to_address2" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>City:</td>
                  <td>
                    <input v-model="to_city" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>State:</td>
                  <td>
                    <input v-model="to_state" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Zipcode:</td>
                  <td>
                    <input v-model="to_zip" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Phone:</td>
                  <td>
                    <input v-model="to_phone" type="text" />
                  </td>
                </tr>
                <tr>
                  <td>Email:</td>
                  <td>
                    <input v-model="to_email" type="text" />
                  </td>
                </tr>

                <tr>
                  <td></td>
                  <td>
                    <button @click="to_popup_trigger(), saveToCustomer()">Save</button>
                  </td>
                </tr>
              </table>
            </div>
          </div>
          <div>
            To:
            <input v-model="to_phone" style="width:150px" type="tel">
            <button @click="getToCustomerByPhone()">Find</button>
            <button @click="to_popup_trigger()">Add / Edit</button>
          </div>
          <div>
            <p>{{ to_name }}</p>
            <p>{{ to_address1 }}</p>
            <p>{{ to_address2 }}</p>
            <p>{{ to_city }} {{ to_state }} {{ to_zip }}</p>
            <p>{{ to_phone }}</p>
            <p>{{ to_email }}</p>
          </div>
        </div>
        <div class="colums">
          <h4>Costs: {{ pick[1] }}</h4>
          <table style="width:100%;">
            <tr align="left">
              <th></th>
              <th>Type</th>
              <th>Cost</th>
              <th>Est Date</th>
            </tr>
            <tr align="left">
              <td><input type="radio" v-model="pick" :value="[0, day1, nextDay]" /></td>
              <td>Next Day</td>
              <td>${{ day1 }}</td>
              <td>{{ nextDay }}</td>
            </tr>
            <tr align="left">
              <td><input type="radio" v-model="pick" :value="[1, day2, twoDay]" /></td>
              <td>Two Day</td>
              <td>${{ day2 }}</td>
              <td>{{ twoDay }}</td>
            </tr>
            <tr>
              <td><input type="radio" v-model="pick" :value="[2, day5, standartDay]" /></td>
              <td>Standard</td>
              <td>${{ day5 }}</td>
              <td>{{ standartDay }}</td>
            </tr>

          </table>
        </div>
      </div>
      <div class="rows">
        <div class="colums" style="border:none">
          <button @click="reset()">Cancle</button>
        </div>
        <div class="colums" style="border:none">
          <button @click="savePackage(), clearMessage()"> Complete Shipment</button>
          <p style="color:red">{{ err }}</p>
          <p style="color:green">{{ res }}</p>
        </div>

      </div>

    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  mounted(){
    if(!this.$store.getters.getStoreid && !this.$store.state.storeid){
      this.$router.push({name:'Login'})
    }
  },
  data() {
    return {


      from_popup: false,
      from_name: "",
      from_address1: "",
      from_address2: "",
      from_city: "",
      from_state: "",
      from_zip: "",
      from_phone: "",
      from_email: "",

      to_popup: false,
      to_name: "",
      to_address1: "",
      to_address2: "",
      to_city: "",
      to_state: "",
      to_zip: "",
      to_phone: "",
      to_email: "",

      l: "0",
      w: "0",
      h: "0",
      wt: "0",
      insr: "100",
      desc: "",

      pick: [],
      day1: "00",
      day2: "00",
      day5: "00",
      nextDay: "",
      twoDay: "",
      standartDay: "",
      res: "",
      err: "",
    }
  },
  methods: {

    clearMessage() {
      // This method will be executed after 10 seconds
      setTimeout(() => {
        this.res = "";
        this.err="";
      }, 10000)
    },
    // to pop up user details div
    from_popup_trigger() {
      this.from_popup = !this.from_popup
    },
    //to popup user details div
    to_popup_trigger() {
      this.to_popup = !this.to_popup
    },
    // to generate shipping cost
    getrates() {
      this.day5 = (this.l + this.w + this.h + this.wt)
      this.day2 = (this.l + this.w + this.h + this.wt) * 1.75
      this.day1 = (this.l + this.w + this.h + this.wt) * 3.5
      this.nextDay = this.formattedDate(1);
      this.twoDay = this.formattedDate(2);
      this.standartDay = this.formattedDate(5);


    },
    formattedDate(addDays) {
      const today = new Date()
      const newDate = new Date(today)
      newDate.setDate(newDate.getDate() + addDays)

      const day = newDate.getDate()
      const month = newDate.getMonth()
      const year = newDate.getFullYear()

      console.log(month + "-" + day + "-" + year)

      return month + "-" + day + "-" + year;

    },
    // to set all the data values to default values
    reset() {
      this.from_name = "";
      this.from_address1 = "";
      this.from_address2 = "";
      this.from_city = "";
      this.from_state = "";
      this.from_zip = "";
      this.from_phone = "";
      this.from_email = "";

      this.to_name = "";
      this.to_address1 = "";
      this.to_address2 = "";
      this.to_city = "";
      this.to_state = "";
      this.to_zip = "";
      this.to_phone = "";
      this.to_email = "";

      this.l = "0";
      this.w = "0";
      this.h = "0";
      this.wt = "0";
      this.insr = "100";
      this.desc = "";

      this.pick = "";
      this.day1 = "00";
      this.day2 = "00";
      this.day5 = "00";



    },
    async getFromCustomerByPhone() {
      console.log("http://localhost:8080/getCustomerByKey?phone=" + this.from_phone)
      await axios.post("http://localhost:8080/getCustomerByKey?phone=" + this.from_phone, {})
        .then((res) => {
          console.log(res.data)
          this.from_name = res.data.name;
          this.from_address1 = res.data.address1;
          this.from_address2 = res.data.address2;
          this.from_city = res.data.city;
          this.from_state = res.data.state;
          this.from_zip = res.data.zipcode;
          this.from_phone = res.data.phone;
          this.from_email = res.data.email;
        })
        .catch((error) => {
          console.log(error.data)
          // error.response.status Check status code
        }).finally(() => {
          //Perform action in always
          console.log("Finally block")
        });

    },
    async getToCustomerByPhone() {
      console.log("http://localhost:8080/getCustomerByKey?phone=" + this.to_phone)
      await axios.post("http://localhost:8080/getCustomerByKey?phone=" + this.to_phone, {})
        .then((res) => {
          console.log(res.data)
          this.to_name = res.data.name;
          this.to_address1 = res.data.address1;
          this.to_address2 = res.data.address2;
          this.to_city = res.data.city;
          this.to_state = res.data.state;
          this.to_zip = res.data.zipcode;
          this.to_phone = res.data.phone;
          this.to_email = res.data.email;
        })
        .catch((error) => {
          console.log(error.data)
          // error.response.status Check status code
        }).finally(() => {
          //Perform action in always
          console.log("Finally block")
        });

    },
    async saveFromCustomer() {
      const customer = {
        phone: this.from_phone,
        name: this.from_name,
        address1: this.from_address1,
        address2: this.from_address2,
        city: this.from_city,
        state: this.from_state,
        zipcode: this.from_zip,
        email: this.from_email
      };
      console.log("Im triggered");
      await axios.post("http://localhost:8080/saveCustomer", customer)
        .then((res) => {
          console.log(res.data)
        })
        .catch((error) => {
          console.log(error.data)
          // error.response.status Check status code
        }).finally(() => {
          //Perform action in always
          console.log("Finally block")
        });

    },
    async saveToCustomer() {
      const customer = {
        phone: this.to_phone,
        name: this.to_name,
        address1: this.to_address1,
        address2: this.to_address2,
        city: this.to_city,
        state: this.to_state,
        zipcode: this.to_zip,
        email: this.to_email,

      };
      console.log("Im triggered");
      await axios.post("http://localhost:8080/saveCustomer", customer)
        .then((res) => {
          console.log(res.data)
        })
        .catch((error) => {
          console.log(error.data)
          // error.response.status Check status code
        }).finally(() => {
          //Perform action in always
          console.log("Finally block")
        });

    },
    generateTrackingNumber() {
      // Get current timestamp
      const timestamp = new Date().getTime().toString();

      // Generate a random string of alphanumeric characters
      const randomString = Math.random().toString(36).substring(2, 10);

      // Combine timestamp and random string
      const uniquePart = timestamp + randomString;

      // Ensure the length is 18 characters
      const paddedUniquePart = uniquePart.padEnd(16, '0').substring(0, 16);

      // Construct the final tracking number
      const trackingNumber = "1Z" + paddedUniquePart;

      // Return the unique trackingNumber which contain Capital Alphabets and digits
      return trackingNumber.toUpperCase();
    },
    verifyPackage() {
      if(this.from_phone == ""){
        return false;
      }
      if(this.to_phone == ""){
        return false;
      }
      if(this.l<=0 || this.w<=0 || this.h<=0 || this.wt<=0){
        return false;
      }
      if(this.pick.length == 0){
        return false;
      }
      return true;
    },
    async savePackage() {
      if (this.verifyPackage()==false) {
        this.err = "Please Fill all the required feilds....^_^"
        return
      };
      //call method to generate unique tracking number
      const uniqueTracking = this.generateTrackingNumber();

      const dimensions = this.l + "," + this.w + "," + this.h;
      const storeID = this.$store.getters.getStoreid;
      const status = "In Transit"
      const type = ["Next Day", "Second Day", "Standard"]
      const Package = {

        tracking: uniqueTracking,
        fromUserId: this.from_phone,
        toUserId: this.to_phone,
        dimensions: dimensions,
        weight: this.wt,
        insurance: this.insr,
        cost: this.pick[1],
        type: type[this.pick[0]],

        description: this.desc,
        storeId: storeID,
        estDate: this.pick[2],
        actDate: null,
        createdTimeStamp: new Date().toString(),
        status: status,
      }
      await axios.post("http://localhost:8080/savePackage", Package)
        .then((res) => {
          console.log(res.data)
          this.res = "Shipping Successfull with Tracking Number: "+uniqueTracking

          this.reset()
        })
        .catch((error) => {
          console.log(error.data)
          // error.response.status Check status code
        }).finally(() => {
          //Perform action in always
          console.log("Finally block")
        });

    }
  }
}
</script>

<style scoped>
.block-outer {
  color: #000;
  display: flex;
  align-content: center;
  align-items: center;
  /* background-color: aquamarine; */
}

.block {
  position: absolute;
  left: 20%;
  top: 5%;
  width: 60vw;
  height: 90vh;
  border-radius: 10px;
  /* padding: 20px; */
  /* border: 1px solid #000; */
  /* background-color: beige; */
  box-shadow: -1px 2px 19px 0px rgba(119, 119, 119, 0.75);
  display: flex;
  flex-direction: column;
}

.rows {
  /* border: 2px solid black; */
  padding: 5px;
  /* margin: 10px; */
  display: flex;
  width: 100%;
}

.colums {
  border: 1px solid rgb(88, 88, 88);
  padding: 10px;
  border-radius: 5px;
  margin: 0px 5px;
  width: 50%;
}

.popup-blur {
  position: fixed;
  left: 0;
  top: 0;
  /* filter: blur(5px); */
  width: 100vw;
  height: 100vh;
  backdrop-filter: blur(10px);
  background-color: rgba(255, 255, 255, 0.781)
}

.popup {
  position: absolute;
  padding: 30px;
  width: 30vw;
  left: 30%;
  top: 20%;
  /* backdrop-filter: blur(10px) */
  background-color: aliceblue;
  border: 1px solid black;
}

button {
  padding: 5px 15px;
  margin: 0px 5px;
  font: 900;
  /* font-size: larger; */
  border: none;
  outline: none;
  border-radius: 25px;
  width: auto;
  background-color: #2F855A;
  color: white;
}

button:hover {
  background-color: #34a06a;
  box-shadow: -1px 2px 19px 3px #2fff97b6;
  font-weight: 400;
  color: white;
}

.from {
  height: 192px;
}
</style>