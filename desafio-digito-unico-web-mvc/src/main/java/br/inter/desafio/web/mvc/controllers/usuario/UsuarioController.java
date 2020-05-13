package br.inter.desafio.web.mvc.controllers.usuario;

import br.inter.desafio.application.manterusuario.commands.CadastrarUsuarioCommand;
import br.inter.desafio.application.manterusuario.handlers.CadastrarUsuarioHandler;
import br.inter.desafio.application.manterusuario.handlers.RecuperarUsuarioHandler;
import br.inter.desafio.application.manterusuario.queries.RecuperarUsuarioPorIdQuery;
import br.inter.desafio.web.mvc.controllers.usuario.form.CadastrarUsuarioForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final CadastrarUsuarioHandler cadastrarUsuarioHandler;
    private final RecuperarUsuarioHandler recuperarUsuarioHandler;

    public UsuarioController(CadastrarUsuarioHandler cadastrarUsuarioHandler,
                             RecuperarUsuarioHandler recuperarUsuarioHandler) {
        this.cadastrarUsuarioHandler = cadastrarUsuarioHandler;
        this.recuperarUsuarioHandler = recuperarUsuarioHandler;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody CadastrarUsuarioForm form) {

        CadastrarUsuarioCommand command = CadastrarUsuarioCommand.builder()
                                                                 .nome(form.getNome())
                                                                 .email(form.getEmail())
                                                                 .build();

        this.cadastrarUsuarioHandler.handle(command);

        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @GetMapping(value = "/recuperar", params = {"id"})
    public ResponseEntity recuperar(@RequestParam("id") Integer idUsuario) {

        RecuperarUsuarioPorIdQuery query = RecuperarUsuarioPorIdQuery.builder()
                .idUsuario(idUsuario)
                .build();

        return ResponseEntity.ok(this.recuperarUsuarioHandler.handle(query));
    }

}
