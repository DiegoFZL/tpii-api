package br.com.fatec.apiexemplo.service;

import br.com.fatec.apiexemplo.model.Usuario;
import org.springframework.stereotype.Service;
import br.com.fatec.apiexemplo.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository listaUsuarios;

    public UsuarioService (UsuarioRepository usuarioRepository) {
        this.listaUsuarios = usuarioRepository;
    }

    public List<Usuario> listar() {
        return listaUsuarios.findAll();
    }

    public Optional<Usuario> buscarPorId(int indice) {

        if (indice < 0 || indice >= listaUsuarios.findAll().size()) {
            return null;
        }

        return listaUsuarios.findById(indice);
    }

    public Usuario salvar(Usuario usuario) {
        listaUsuarios.save(usuario);
        return usuario;
    }

    public Optional<Usuario> atualizar(int indice, Usuario usuario) {

        return listaUsuarios.findById(indice).map(usuarioExistente -> {
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setIdade(usuario.getIdade());
            return listaUsuarios.save(usuarioExistente);
        });
    }

    public boolean deletar(int indice) {

        if (indice < 0 || indice >= listaUsuarios.findAll().size()) {
            return false;
        }

        listaUsuarios.deleteById(indice);

        return true;
    }
}
