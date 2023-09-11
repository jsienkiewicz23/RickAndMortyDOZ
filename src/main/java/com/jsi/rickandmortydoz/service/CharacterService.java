package com.jsi.rickandmortydoz.service;

import com.jsi.rickandmortydoz.model.Character;
import com.jsi.rickandmortydoz.web.CharacterDTO;
import reactor.core.publisher.Flux;

public interface CharacterService {

    Character getCharacterByName(String name);

    Flux<CharacterDTO> importCharacters();
}
