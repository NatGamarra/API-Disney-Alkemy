package com.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CharacterDTO implements Serializable {

    private String image;
    private String name;
}
