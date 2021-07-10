package com.example.nask.model;

import java.util.List;

public class CharacterResponse {

    private SwapiCharacter character;
    private SwapiHomeworld homeworld;
    private List<SwapiStarship> starships;

    /*getters and setters*/

    public SwapiCharacter getCharacter() {
        return character;
    }

    public void setCharacter(SwapiCharacter character) {
        this.character = character;
    }

    public SwapiHomeworld getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(SwapiHomeworld homeworld) {
        this.homeworld = homeworld;
    }

    public List<SwapiStarship> getStarships() {
        return starships;
    }

    public void setStarships(List<SwapiStarship> starships) {
        this.starships = starships;
    }
}
