<template>
    
    <div>
        <h1>List of Pokemon:</h1>
        <button v-if="count > 0" v-on:click="getPrevious">Previous</button>
        <button v-if="count < 1320" v-on:click="getNext">Next</button>
        <h2>v-for="pokemon in pokemonArray" v-bind:key="pokemon.id">{{ pokemon.name }}</h2>
    </div>

</template>

<script>
import service from '../services/PokemonService.js';

export default {
    data() {
        return { 
            pokemonArray: [],
            count: 0,
        }
    },
    created() {//life cycle hook
        service.getAllPokemon() //asynchronous communication
        .then ((response) => {
            // console.log (response);
            this.pokemonArray = response.data.results;
        })
    },
    methods: {
        getMore() {
            service.getMorePokemon(this.count)
            .then((response) => {
                this.pokemonArray = response.data.results;
            })

        },
        getNext() {
            this.count += 20;
            this.getMore();
        },
        getPrevious() {
            this.count -= 20;
            this.getMore();
        }
    }
    
}

</script>

<style>
</style>