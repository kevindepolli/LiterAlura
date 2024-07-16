package com.kevindepolli.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Long quantidadeDownloads;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.autor = new Autor(dadosLivro.autores().get(0));
        this.idioma = Idioma.fromString(dadosLivro.idiomas().get(0));
        this.quantidadeDownloads = dadosLivro.quantidadeDownloads();
    }

    public Long getQuantidadeDownloads() {
        return quantidadeDownloads;
    }

    public void setQuantidadeDownloads(Long quantidadeDownloads) {
        this.quantidadeDownloads = quantidadeDownloads;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return  "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma=" + idioma +
                ", quantidadeDownloads=" + quantidadeDownloads;
    }
}
