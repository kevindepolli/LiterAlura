package com.kevindepolli.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosPessoa(@JsonAlias("name") String nome,
                          @JsonAlias("birth_year") Integer anoNascimento,
                          @JsonAlias("death_year") Integer anoFalecimento) {
}
