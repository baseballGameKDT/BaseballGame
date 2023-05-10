<template lang="">
    <div>
        <GameLevelComponent @submit="onSubmit"/>
    </div>
</template>

<script>
import GameLevelComponent from '@/components/game/GameLevelComponent.vue';
import { mapActions } from 'vuex';

const gameModule = 'gameModule'

export default {
    components: {
        GameLevelComponent
    },
    methods: {
        ...mapActions(
            gameModule, ['sendGameLevelToSpring']
        ),
        async onSubmit (payload) {
            await this.sendGameLevelToSpring(payload)
            console.log(payload.numberCount)
            await this.$router.push({
                name: 'GamePlayPage',
                params: { numberCount: payload.numberCount }
            })
        }
    }
    
}

</script>

<style lang="">
    
</style>