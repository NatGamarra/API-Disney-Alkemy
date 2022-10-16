package com.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDTO {

    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";

    public JwtDTO(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public JwtDTO(String tokenDeAcceso, String tipoDeToken) {
        this.tokenDeAcceso = tokenDeAcceso;
        this.tipoDeToken = tipoDeToken;
    }
}
