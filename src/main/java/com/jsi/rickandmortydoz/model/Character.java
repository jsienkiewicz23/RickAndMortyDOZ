package com.jsi.rickandmortydoz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String name;
    private String status;
    private Long externId;
    private String species;
    private String type;
    private String gender;
    private String origin;
    private Long location;
    private Long image;
    private Long episode;
    private String url;
    private Long created;

}
