package com.example.nask.components;

import com.example.nask.model.*;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwapiWebClient {

    private final static String swapiCharacterURL = "/people/{id}";
    private final static String swapiAllCharactersURL = "/people/?page=";

    // Swapi People 1 - 83
    // Swapi results per page = 10
    // Swapi Pages = 9

    private WebClient webClient;

    public SwapiWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public AllCharactersResponse getAllCharacters(Integer page) {
        SwapiAllCharacters swapiAllCharacters =
                webClient
                        .method(HttpMethod.GET)
                        .uri(swapiAllCharactersURL + page)
                        .retrieve()
                        .bodyToMono(SwapiAllCharacters.class)
                        .block();
        return CreateAllCharactersResponse(swapiAllCharacters);
    }

    public AllCharactersResponse CreateAllCharactersResponse(SwapiAllCharacters swapiallChar) {

        AllCharactersResponse allCharactersResponse = new AllCharactersResponse();

        allCharactersResponse.setNext(swapiallChar.getNext());
        allCharactersResponse.setPrevious(swapiallChar.getPrevious());
        allCharactersResponse.setCount(swapiallChar.getCount());

        allCharactersResponse.setPages((allCharactersResponse.getCount() + 10 - 1) / 10);

        ArrayList<CharacterResponse> characterResponseArrayList = new ArrayList<>();

        for (SwapiCharacter swapiCharacter : swapiallChar.getResults()) {
            characterResponseArrayList.add(CreateCharacterResponse(swapiCharacter));
        }
        allCharactersResponse.setElements(characterResponseArrayList);
        
        return allCharactersResponse;
    }

    public CharacterResponse getCharacter(Integer id) {
        SwapiCharacter swapiCharacter =
                webClient
                        .method(HttpMethod.GET)
                        .uri(swapiCharacterURL, id)
                        .retrieve()
                        .bodyToMono(SwapiCharacter.class)
                        .block();
        return CreateCharacterResponse(swapiCharacter);
    }

    public CharacterResponse CreateCharacterResponse(SwapiCharacter swapiCharacter) {

        CharacterResponse characterResponse = new CharacterResponse();

        characterResponse.setCharacter(swapiCharacter);
        characterResponse.setHomeworld(getHomeworld(swapiCharacter.getHomeWorld()));
        characterResponse.setStarships(getStarships(swapiCharacter.getStarships()));
        return characterResponse;
    }

    private SwapiHomeworld getHomeworld(String uriHomeworld) {
        return webClient
                .method(HttpMethod.GET)
                .uri(uriHomeworld)
                .retrieve()
                .bodyToMono(SwapiHomeworld.class)
                .block();
    }

    private List<SwapiStarship> getStarships(List<String> uristarshiplist) {
        List<SwapiStarship> swapiStarshipList = new ArrayList<SwapiStarship>();

        for (int i = 0; i < uristarshiplist.size(); i++) {
            swapiStarshipList.add(webClient
                    .method(HttpMethod.GET)
                    .uri(uristarshiplist.get(i))
                    .retrieve()
                    .bodyToMono(SwapiStarship.class)
                    .block());
        }
        return swapiStarshipList;
    }

}
