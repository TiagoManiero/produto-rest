package com.tiagomaniero.produtorest.config.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String username;

    private String senha;
}
