package br.com.fatec.apiexemplo.repository;

import br.com.fatec.apiexemplo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
