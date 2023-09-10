package com.jsi.rickandmortydoz.repository.data;

import com.jsi.rickandmortydoz.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    Character findByName(String name);
}
