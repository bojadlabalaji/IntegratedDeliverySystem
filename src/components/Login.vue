<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div class="outer">
        <div class="inner">
            <h1><u>Login</u></h1>
            <p class="error">{{ err }}</p>
            <input type="text" v-model="username" /><br>
            <input type="password" v-model="password" /><br>
            <button @click="login(),clearMessage()">Login</button>

        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            username: "",
            password: "",
            err: "",
        }
    },
    mounted() {
        
        if (this.$store.getters.isLogin === 'true') {
            console.log("login Mounted ")
            this.$router.push({name:'shipment'})
        }
        // console.log("Login Mounted:"+this.$store.getters.isLogin)
    },
    methods: {
        clearMessage() {
            // This method will be executed after 10 seconds
            setTimeout(() => {
                this.err = "";
            }, 6000)
        },
        loginSuccessfull(){
            this.$store.commit('login',this.username);
            this.$router.go();
            this.$router.push({name:'shipment'})
        },
        async login() {
            const payload = {
                username: this.username,
                password: this.password,
            };
            await axios.post(this.$store.state.BASE_URL + "/login", payload)
                .then((res) => {
                    console.log(res.data)
                    if (res.data) {
                        console.log("Login Successfull")
                        this.loginSuccessfull();
                    }
                    else {
                        this.err = "Invalid username/ password...*_*"
                    }
                })
                .catch((error) => {
                    // console.log("Exception Block")
                    console.log(error.code)
                    // error.response.status Check status code
                    this.err = "Exception occur...*_*"
                })
        }
    }
}
</script>
<style scoped>
.outer {
    /* display: flex; */
    /* align-items: center; */
    /* justify-content: center; */
}

.inner {
    position: absolute;
    top: 20%;
    left: 35%;
    background-color: white;
    width: 400px;
    padding: 20px;
    border-radius: 20px;
    color: #2F855A;
    height: 200px;
}

h1 u {
    font-weight: 900;
}

input {
    width: 300px;
    padding: 5px;
    margin: 10px 0px;
    font-size: 20px;
    font-weight: 500;
    border: 1px solid black;
    outline: none;
    border-radius: 5px;

}

button {
    padding: 10px 15px;
    margin: 10px 0px;
    font: 900;
    /* font-size: larger; */
    border: none;
    outline: none;
    border-radius: 5px;
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
.error{
    font-weight: 300;
    color: red;
}
</style>