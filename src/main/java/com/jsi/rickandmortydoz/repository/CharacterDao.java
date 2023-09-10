package com.jsi.rickandmortydoz.repository;

import com.jsi.rickandmortydoz.model.Character;

public interface CharacterDao {

    Character findByName(String name);
}
