package com.jsi.rickandmortydoz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties
@Table(name = "characters", schema = "api")
@Getter
@Setter
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Integer originId;
    private Integer locationId;
    private String image;
    @ManyToMany
    @JoinTable(
            name = "episode_character",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id")
    )
    private Set<Episode> cinemas = new HashSet<>();
    private String url;
    private String created;

}
