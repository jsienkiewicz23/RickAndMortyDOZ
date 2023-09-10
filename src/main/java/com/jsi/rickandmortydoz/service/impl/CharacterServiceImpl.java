package com.jsi.rickandmortydoz.service.impl;

import com.jsi.rickandmortydoz.model.Character;
import com.jsi.rickandmortydoz.repository.CharacterDao;
import com.jsi.rickandmortydoz.service.CharacterService;
import com.jsi.rickandmortydoz.web.CharacterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    WebClient webClient;

    @Value("${rickandmorty.api.url}")
    private String url;

    private CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    public Character getCharacterByName(String name) {
        return characterDao.findByName(name);
    }

    @Override
    public Flux<CharacterDTO> importCharacters() {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(CharacterDTO.class)
                .doOnError(throwable -> log.error("Failed for some reason", throwable));
    }
}
