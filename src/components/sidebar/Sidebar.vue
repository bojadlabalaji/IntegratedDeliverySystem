<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div class="sidebar" :style="{ width: sidebarWidth }">
        {{ storeId }}
        <h1>
            <span v-if="collapsed">
                <div>
                    <img alt="Vue logo" class="logosmall" src="@/assets/idslogo.svg" width="25" height="25" />
                </div>
                
            </span>
            <span v-else>
                <img alt="Vue logo" class="logo" src="@/assets/idslogo.svg" width="100" height="100" />
            </span>
        </h1>

        <!-- <SidebarLink to="/home" icon="fas fa-home">Home</SidebarLink> -->
        <SidebarLink to="/shipment" icon="fa-solid fa-truck-fast">Shipment</SidebarLink>
        <SidebarLink to="/dropoff" icon="fa-solid fa-box-open">Drop-off</SidebarLink>
        <SidebarLink to="/track" icon="fa-solid fa-map-location-dot">Track</SidebarLink>
        <SidebarLink to="/eod" icon="fa-regular fa-calendar-days">End of Day</SidebarLink>
        <SidebarLink to="" @click="logout()" v-if="this.$store.getters.isLogin === 'true'" icon="fa-solid fa-arrow-right-from-bracket">Logout</SidebarLink>

        <span class="collapse-icon" :class="{ 'rotate-180': collapsed }" @click="toggleSidebar">
            <i class="fas fa-angle-double-left" />
        </span>
        
    </div>
</template>
<script>

import { collapsed, toggleSidebar, sidebarWidth } from './state'
import SidebarLink from './SidebarLink.vue'

export default {
    props: {},
    components: { SidebarLink },
    data(){
        return{
            isLogin:this.$store.getters.isLogin,
            storeId:this.$store.getters.getStoreid,
        }
    },
    setup() {
        return { collapsed, toggleSidebar, sidebarWidth }
    },
    methods:{
        logout(){
            console.log("Logout clicked")
            // this.$store.commit('example')
            const l = this.$store.getters.isLogin;
            console.log(l)
            this.$store.commit('logout');
            this.$router.go();
            this.$router.push("/login");

            
        }
    }
}
</script>



<style>
.logo{
    margin-left: 20%;
    padding-bottom: 10%;
}
.logosmall{
    margin-left: 20%;
}
:root {
    --sidebar-bg-color: #2f855a;
    --sidebar-item-hover: #38a169;
    --sidebar-item-active: #276749;
}
</style>

<style scoped>
.sidebar {
    color: white;
    background-color: var(--sidebar-bg-color);

    float: left;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    bottom: 0;
    padding: 0.5em;

    transition: 0.3s ease;

    display: flex;
    flex-direction: column;
}

.sidebar h1 {
    height: 2.5em;
}

.collapse-icon {
    position: absolute;
    bottom: 0;
    padding: 0.75em;

    color: rgba(255, 255, 255, 0.7);

    transition: 0.2s linear;
}

.rotate-180 {
    transform: rotate(180deg);
    transition: 0.2s linear;
}
</style>