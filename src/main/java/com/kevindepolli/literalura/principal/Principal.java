package com.kevindepolli.literalura.principal;

import com.kevindepolli.literalura.model.DadosLivro;
import com.kevindepolli.literalura.model.DadosResultadoBusca;
import com.kevindepolli.literalura.model.Livro;
import com.kevindepolli.literalura.repository.LivroRepository;
import com.kevindepolli.literalura.service.ConsumoApi;
import com.kevindepolli.literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private Scanner scanner = new Scanner(System.in);

    private final String ENDERECO = "https://gutendex.com/";

    private LivroRepository repositorio;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){
        var menu = """
                
                -------------------------------------------------
                
                Escolha o número de sua opção:
                1- buscar livro pelo título
                2- listar livros registrados
                3- listar autores registrados
                4- listar autores vivos em um determinado ano
                5- listar livros em um determinado idioma
                0- sair
                """;

        System.out.println(menu);
        var opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1:
                buscarLivro();
                break;
            case 2:
                listarLivros();
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private void listarLivros() {
        repositorio.findAll().forEach(System.out::println);
    }

    private void buscarLivro() {
        DadosLivro dadosLivro = getDadosLivro();
        Livro livro = new Livro(dadosLivro);
        repositorio.save(livro);
        System.out.println(dadosLivro);
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + "books/?search=" + nomeLivro.replace(" ", "%20"));
        var resultadosBuscaLivro = conversor.obterDados(json, DadosResultadoBusca.class);
       return resultadosBuscaLivro.resultados().get(0);
    }
}
