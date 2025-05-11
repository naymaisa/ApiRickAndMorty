/**
 * @author nayara.maisa
 */

package com.naymaisa.api_rick_and_morty.controller;

import com.naymaisa.api_rick_and_morty.client.RickAndMortyClient;
import com.naymaisa.api_rick_and_morty.response.AllEpisodesResponse;
import com.naymaisa.api_rick_and_morty.response.CharacterResponse;
import com.naymaisa.api_rick_and_morty.response.EpisodeResponse;
import com.naymaisa.api_rick_and_morty.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable int id){
        return rickAndMortyClient.findAndCharacterById(id);

    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable int id){
        return rickAndMortyClient.findAndLocationById(id);

    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable int id){
        return rickAndMortyClient.findAndEpisodeById(id);

    }


    @GetMapping("/episodes/")
    public Flux<AllEpisodesResponse> getAllEpisodes(){
        return rickAndMortyClient.getAllEpisodes();

    }
}
