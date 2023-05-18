<template>
    <div>
        <h2>회원 가입</h2>
        <SignUpComponent @submit="createAccount"/>
    </div> 
</template>
<script>

import SignUpComponent from '@/components/account/SignUpComponent.vue';
import { mapActions } from 'vuex';

const accountModule = 'accountModule'

export default {
    components: {
        SignUpComponent,
    },
    methods: {
        ...mapActions(
            accountModule, ['requestCreateAccountToSpring']
        ),
        async createAccount (payload) {
            await this.requestCreateAccountToSpring(payload)
            await this.$router.push({
                name: 'home'
            })
        }
    }
    
}
</script>
<style lang="">
    
</style>