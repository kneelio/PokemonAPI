<template>

<div>
    <h1>{{ pokemon.name }}</h1>
</div>

</template>

<script>
import service from '..services/PokemonService'

export default {
    props: {
        id: String
    },
    data () {
        return{
            pokemon: {}
        }
    },
    created() {
        service.getPokemonDetail(this.id)
        .then((response)=> {
            this.pokemon = response.data;
        })
    },
}

</script>

<style>
</style>