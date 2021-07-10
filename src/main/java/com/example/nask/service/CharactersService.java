package com.example.nask.service;

import com.example.nask.components.SwapiWebClient;
import com.example.nask.model.AllCharactersResponse;
import com.example.nask.model.CharacterResponse;
import org.springframework.stereotype.Service;

@Service
public class CharactersService {

    private final SwapiWebClient swapiWebClient;

    public CharactersService(SwapiWebClient swapiWebClient) {
        this.swapiWebClient = swapiWebClient;
    }

    public AllCharactersResponse getCharacters(Integer page) {
        return swapiWebClient.CreateAllCharactersResponse(page);
    }

    public CharacterResponse getCharacterById(Integer id) {
        return swapiWebClient.getCharacter(id);
    }
}
