package br.com.fatec.apiexemplo.controller;
import br.com.fatec.apiexemplo.model.Usuario;
import br.com.fatec.apiexemplo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET - listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok().body(usuarioService.listar());
    }

    // GET - buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestParam Integer id,@RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {
        if(usuarioService.buscarPorId(id).isPresent()) {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
