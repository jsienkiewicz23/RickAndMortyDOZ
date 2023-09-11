package com.jsi.rickandmortydoz.repository;

import com.jsi.rickandmortydoz.model.Character;
import reactor.core.publisher.Flux;

public interface CharacterDao {

    Character findByName(String name);

    Flux<?> saveAll(Iterable<Character> entities);
}
