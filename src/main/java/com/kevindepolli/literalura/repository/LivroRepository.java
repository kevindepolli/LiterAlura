package com.kevindepolli.literalura.repository;

import com.kevindepolli.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
