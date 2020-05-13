package br.inter.desafio.web.mvc.controllers.usuario;

import br.inter.desafio.application.manterusuario.commands.CadastrarUsuarioCommand;
import br.inter.desafio.application.manterusuario.commands.CalcularDigitoUnicoParaUsuarioCommand;
import br.inter.desafio.application.manterusuario.commands.DeletarUsuarioPorIdCommand;
import br.inter.desafio.application.manterusuario.handlers.CadastrarUsuarioHandler;
import br.inter.desafio.application.manterusuario.handlers.CalcularDigitoUnicoParaUsuarioHandler;
import br.inter.desafio.application.manterusuario.handlers.DeletarUsuarioHandler;
import br.inter.desafio.application.manterusuario.handlers.ListarUsuarioHandler;
import br.inter.desafio.application.manterusuario.queries.ListarUsuarioPorIdQuery;
import br.inter.desafio.web.mvc.controllers.usuario.form.CadastrarUsuarioForm;
import br.inter.desafio.web.mvc.controllers.usuario.form.CalcularDigitoUnicoParaUsuarioForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final CadastrarUsuarioHandler cadastrarUsuarioHandler;
    private final ListarUsuarioHandler listarUsuarioHandler;
    private final DeletarUsuarioHandler deletarUsuarioHandler;
    private final CalcularDigitoUnicoParaUsuarioHandler calcularDigitoUnicoParaUsuarioHandler;

    public UsuarioController(CadastrarUsuarioHandler cadastrarUsuarioHandler,
                             ListarUsuarioHandler listarUsuarioHandler,
                             DeletarUsuarioHandler deletarUsuarioHandler,
                             CalcularDigitoUnicoParaUsuarioHandler calcularDigitoUnicoParaUsuarioHandler) {
        this.cadastrarUsuarioHandler = cadastrarUsuarioHandler;
        this.listarUsuarioHandler = listarUsuarioHandler;
        this.deletarUsuarioHandler = deletarUsuarioHandler;
        this.calcularDigitoUnicoParaUsuarioHandler = calcularDigitoUnicoParaUsuarioHandler;
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

    @GetMapping(value = "/listar", params = {"id"})
    public ResponseEntity listar(@RequestParam("id") Integer idUsuario) {

        ListarUsuarioPorIdQuery query = ListarUsuarioPorIdQuery.builder()
                                                                     .idUsuario(idUsuario)
                                                                     .build();

        return ResponseEntity.ok(this.listarUsuarioHandler.handle(query));
    }

    @DeleteMapping(value = "/deletar", params = {"id"})
    public ResponseEntity deletar(@RequestParam("id") Integer idUsuario) {

        DeletarUsuarioPorIdCommand command = DeletarUsuarioPorIdCommand.builder()
                                                                       .idUsuario(idUsuario)
                                                                       .build();

        this.deletarUsuarioHandler.handle(command);

        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }

    @PostMapping(value = "/calcular-digito-unico")
    public ResponseEntity calcularDigitoUnicoParaUsuario(@RequestBody CalcularDigitoUnicoParaUsuarioForm form) {

        CalcularDigitoUnicoParaUsuarioCommand command = CalcularDigitoUnicoParaUsuarioCommand.builder()
                                                                    .idUsuario(form.getIdUsuario())
                                                                    .valorASerConcatenado(form.getValorASerConcatenado())
                                                                    .numeroDeConcatenacoes(form.getNumeroDeConcatenacoes())
                                                                    .build();

        this.calcularDigitoUnicoParaUsuarioHandler.handle(command);

        return ResponseEntity.ok("Dígito único calculado para o usuário.");
    }

}
