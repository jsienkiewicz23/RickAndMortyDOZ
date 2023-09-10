package com.jsi.rickandmortydoz.repository.data;

import com.jsi.rickandmortydoz.model.Character;
import com.jsi.rickandmortydoz.repository.CharacterDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@RequiredArgsConstructor
public class CharacterDaoData implements CharacterDao
{
    private final CharacterRepository characterRepository;
    @Override
    public Character findByName(String name) {
        return characterRepository.findByName(name);
    }
}
