package br.com.fatec.apiexemplo.controller;

import br.com.fatec.apiexemplo.model.Usuario;
import br.com.fatec.apiexemplo.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        listaUsuarios.add(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> buscaPorIndice(@PathVariable int indice) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(listaUsuarios.get(indice));
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return ResponseEntity.notFound().build();
        }

        listaUsuarios.remove(indice);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int indice, @RequestBody Usuario usuarioAtualizado) {

        if (indice < 0 || indice >= listaUsuarios.size()) {
            return ResponseEntity.notFound().build();
        }

        listaUsuarios.set(indice, usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
