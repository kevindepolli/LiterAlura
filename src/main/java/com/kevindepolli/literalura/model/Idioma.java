package com.kevindepolli.literalura.model;

public enum Idioma {
    INGLES("en"),
    ESPANHOL("es"),
    FRANCES("fr"),
    ALEMAO("de"),
    CHINES("zh"),
    JAPONES("ja"),
    ITALIANO("it"),
    PORTUGUES("pt"),
    RUSSO("ru");

    private String idiomaLivro;

    Idioma(String idioma){
        this.idiomaLivro = idioma;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaLivro.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrada para a string fornecida: " + text);
    }
}
