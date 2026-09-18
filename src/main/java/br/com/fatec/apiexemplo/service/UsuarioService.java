package br.com.fatec.apiexemplo.service;

import br.com.fatec.apiexemplo.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> listar() {
        return listaUsuarios;
    }

    public Usuario buscarPorIndice(int indice) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return null;
        }

        return listaUsuarios.get(indice);
    }

    public Usuario adicionar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    public Usuario atualizar(int indice, Usuario usuario) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return null;
        }

        listaUsuarios.set(indice, usuario);

        return usuario;
    }

    public boolean deletar(int indice) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return false;
        }

        listaUsuarios.remove(indice);

        return true;
    }
}
