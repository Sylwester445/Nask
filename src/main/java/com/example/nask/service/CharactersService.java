package com.example.nask.service;

import com.example.nask.components.SwapiWebClient;
import com.example.nask.model.AllCharactersResponse;
import com.example.nask.model.CharacterResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CharactersService {

    private final SwapiWebClient swapiWebClient;

    public CharactersService(SwapiWebClient swapiWebClient) {
        this.swapiWebClient = swapiWebClient;
    }

    @Cacheable("Cache-1")
    public AllCharactersResponse getCharacters(Integer page) {
        return swapiWebClient.getAllCharacters(page);
    }

    @Cacheable("Cache-2")
    public CharacterResponse getCharacterById(Integer id) {
        return swapiWebClient.getCharacter(id);
    }
}
