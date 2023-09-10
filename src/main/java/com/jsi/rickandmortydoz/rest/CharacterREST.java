package com.jsi.rickandmortydoz.rest;

import com.jsi.rickandmortydoz.model.Character;
import com.jsi.rickandmortydoz.service.CharacterService;
import com.jsi.rickandmortydoz.web.CharacterDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/character")
@Slf4j
@RequiredArgsConstructor
public class CharacterREST {

    private final CharacterService characterService;

    @GetMapping(value = "/{name}", produces = "application/json")
    ResponseEntity<Character> getCharacterByName(@PathVariable("name") String name) {
        Character character = characterService.getCharacterByName(name);
        if (character == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(character, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/import")
    Flux<?> importAllCharacters() {
        try {
            return characterService.importCharacters();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
