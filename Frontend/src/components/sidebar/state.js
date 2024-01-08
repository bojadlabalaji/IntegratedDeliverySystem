import {ref, computed} from 'vue'

export const collapsed = ref(false)
export const toggleSidebar = () => (collapsed.value = !collapsed.value)

export const sidebar_width = 180
export const sdiebar_width_collapsed = 54
export const sidebarWidth = computed(
    ()=> `${collapsed.value ? sdiebar_width_collapsed:sidebar_width}px`
)