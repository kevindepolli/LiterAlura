package com.kevindepolli.literalura;

import com.kevindepolli.literalura.model.DadosLivro;
import com.kevindepolli.literalura.principal.Principal;
import com.kevindepolli.literalura.repository.LivroRepository;
import com.kevindepolli.literalura.service.ConsumoApi;
import com.kevindepolli.literalura.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepository);
		principal.exibeMenu();
	}
}
