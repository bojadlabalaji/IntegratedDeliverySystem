import { createStore} from 'vuex'
import createPersistedState from "vuex-persistedstate";
const store = createStore({
    plugins: [createPersistedState({
        storage: window.sessionStorage,
      })],
    state:{
        storeid:"",
        isLogin:false,
        BASE_URL:"http://localhost:8080",
    },
    getters:{
        getStoreid(){
            return localStorage.getItem("storeid");
        }, 
        isLogin(){
            return localStorage.getItem("isLogin");
        }
        
    },
    setters:{

    },
    models:{
    },
    actions:{

    },
    mutations:{
        login(state,storeid){
            state.storeid = storeid;
            localStorage.setItem("storeid",storeid);
            state.isLogin=true;
            localStorage.setItem("isLogin",state.isLogin);

        },
        logout(state){
            state.storeid ="";
            localStorage.removeItem("storeid");
            state.isLogin=false;
            localStorage.setItem("isLogin",false);
            
        },
        example(){
            console.log("Example mutation commited")
        },
        initialiseStore(state){
            if(localStorage.getItem("storeid")){
                state.storeid = localStorage.getItem("storeid");
                state.isLogin = localStorage.getItem("isLogin");
            }
        }
    }
})
export default store;