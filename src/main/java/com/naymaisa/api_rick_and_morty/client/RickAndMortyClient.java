/**
 * @author nayara.maisa
 */

package com.naymaisa.api_rick_and_morty.client;


import com.naymaisa.api_rick_and_morty.response.AllEpisodesResponse;
import com.naymaisa.api_rick_and_morty.response.CharacterResponse;
import com.naymaisa.api_rick_and_morty.response.EpisodeResponse;
import com.naymaisa.api_rick_and_morty.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {
    public RickAndMortyClient(WebClient.Builder builder) {
       webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    private final WebClient webClient;

    public Mono<CharacterResponse> findAndCharacterById(int id){
        log.info("buscando o personagem com o id[{}]", id);
        return (Mono<CharacterResponse>) webClient
                .get()
                .uri("/character/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error-> Mono.error(new RuntimeException(("verifique os parametros "))))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAndLocationById(int id){
        log.info("buscando o local com o id[{}]", id);
        return  webClient
                .get()
                .uri("/location/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error-> Mono.error(new RuntimeException(("verifique os parametros "))))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAndEpisodeById(int id){
        log.info("buscando o episodio com o id[{}]", id);
        return  webClient
                .get()
                .uri("/episode/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error-> Mono.error(new RuntimeException(("verifique os parametros "))))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<AllEpisodesResponse> getAllEpisodes(){
        log.info("Listando todos os episodios");
        return  webClient
                .get()
                .uri("/episode/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error-> Mono.error(new RuntimeException(("verifique os parametros "))))
                .bodyToFlux(AllEpisodesResponse.class);
    }
}

