package org.example.services;

import org.example.models.Pokemon;
import org.example.models.Results;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    public List<Pokemon> getAllPokemon(int startVal){
        Results rs = restTemplate.getForObject(API_URL + "?offset=" + startVal + "&limit=20", Results.class);
        List<Pokemon> list = rs.getList();
        for (Pokemon item: list) {
            String url = item.getUrl();

            int pokemonIndex = url.indexOf("pokemon");
            String pokemonString = url.substring(pokemonIndex);
            //pokemon/3/
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1, pokemonString.length() - 1);
            int id = Integer.parseInt(number);
            item.setId(id);
        }
        return list;
    }

}
