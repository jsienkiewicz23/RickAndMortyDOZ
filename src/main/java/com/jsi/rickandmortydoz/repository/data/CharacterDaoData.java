package com.jsi.rickandmortydoz.repository.data;

import com.jsi.rickandmortydoz.model.Character;
import com.jsi.rickandmortydoz.repository.CharacterDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;

@Repository
@Primary
@RequiredArgsConstructor
public class CharacterDaoData implements CharacterDao {
    private final CharacterRepository characterRepository;

    @Override
    public Character findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Flux<?> saveAll(Iterable<Character> entities) {
        Assert.notNull(entities, "The given Iterable of entities must not be null");
        //entities.forEach();
        return saveAll(entities);
    }
}
