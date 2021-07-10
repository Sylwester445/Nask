package com.example.nask.controller;

import com.example.nask.model.AllCharactersResponse;
import com.example.nask.model.CharacterResponse;
import com.example.nask.service.CharactersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersController {

    private final CharactersService charactersService;

    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    Logger logger = LoggerFactory.getLogger(CharactersController.class);

    @GetMapping(value = "/characters")
    public ResponseEntity<AllCharactersResponse> getCharacters
            (@RequestParam(required = false, name = "page", defaultValue = "2") int page) {
        logger.info("GET request to: /characters?page=" + page);
        return ResponseEntity.ok(charactersService.getCharacters(page));
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable Integer id) {
        logger.info("GET request to: characters/" + id);
        return ResponseEntity.ok(charactersService.getCharacterById(id));
    }

}
