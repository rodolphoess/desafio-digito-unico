package br.inter.desafio.web.mvc.controllers.usuario;

import br.inter.desafio.application.manterusuario.commands.AlterarUsuarioCommand;
import br.inter.desafio.application.manterusuario.commands.CadastrarUsuarioCommand;
import br.inter.desafio.application.manterusuario.commands.CalcularDigitoUnicoParaUsuarioCommand;
import br.inter.desafio.application.manterusuario.commands.DeletarUsuarioPorIdCommand;
import br.inter.desafio.application.manterusuario.handlers.*;
import br.inter.desafio.application.manterusuario.queries.ListarDigitosUnicosUsuarioQuery;
import br.inter.desafio.application.manterusuario.queries.ListarUsuarioPorIdQuery;
import br.inter.desafio.domain.entities.usuario.UsuarioNaoEncontradoException;
import br.inter.desafio.web.mvc.controllers.usuario.form.AlterarUsuarioForm;
import br.inter.desafio.web.mvc.controllers.usuario.form.CadastrarUsuarioForm;
import br.inter.desafio.web.mvc.controllers.usuario.form.CalcularDigitoUnicoParaUsuarioForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final CadastrarUsuarioHandler cadastrarUsuarioHandler;
    private final ListarUsuarioPorIdHandler listarUsuarioPorIdHandler;
    private final ListarTodosUsuariosHandler listarTodosUsuariosHandler;
    private final DeletarUsuarioPorIdHandler deletarUsuarioPorIdHandler;
    private final AlterarUsuarioHandler alterarUsuarioHandler;
    private final CalcularDigitoUnicoParaUsuarioHandler calcularDigitoUnicoParaUsuarioHandler;
    private final ListarDigitosUnicosUsuarioHandler listarDigitosUnicosUsuarioHandler;

    public UsuarioController(CadastrarUsuarioHandler cadastrarUsuarioHandler,
                             ListarUsuarioPorIdHandler listarUsuarioPorIdHandler,
                             ListarTodosUsuariosHandler listarTodosUsuariosHandler,
                             DeletarUsuarioPorIdHandler deletarUsuarioPorIdHandler,
                             AlterarUsuarioHandler alterarUsuarioHandler,
                             CalcularDigitoUnicoParaUsuarioHandler calcularDigitoUnicoParaUsuarioHandler,
                             ListarDigitosUnicosUsuarioHandler listarDigitosUnicosUsuarioHandler) {
        this.cadastrarUsuarioHandler = cadastrarUsuarioHandler;
        this.listarUsuarioPorIdHandler = listarUsuarioPorIdHandler;
        this.listarTodosUsuariosHandler = listarTodosUsuariosHandler;
        this.deletarUsuarioPorIdHandler = deletarUsuarioPorIdHandler;
        this.alterarUsuarioHandler = alterarUsuarioHandler;
        this.calcularDigitoUnicoParaUsuarioHandler = calcularDigitoUnicoParaUsuarioHandler;
        this.listarDigitosUnicosUsuarioHandler = listarDigitosUnicosUsuarioHandler;
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

        return ResponseEntity.ok(this.listarUsuarioPorIdHandler.handle(query));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity listarTodos() {
        return ResponseEntity.ok(this.listarTodosUsuariosHandler.handle());
    }

    @DeleteMapping(value = "/deletar", params = {"id"})
    public ResponseEntity deletar(@RequestParam("id") Integer idUsuario) {

        DeletarUsuarioPorIdCommand command = DeletarUsuarioPorIdCommand.builder()
                                                                       .idUsuario(idUsuario)
                                                                       .build();

        this.deletarUsuarioPorIdHandler.handle(command);

        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }

    @PutMapping("/alterar")
    public ResponseEntity alterar(@RequestBody AlterarUsuarioForm form) {

        AlterarUsuarioCommand command = AlterarUsuarioCommand.builder()
                                                             .idUsuario(form.getIdUsuario())
                                                             .nome(form.getNome())
                                                             .email(form.getEmail())
                                                             .build();

        this.alterarUsuarioHandler.handle(command);

        return ResponseEntity.ok("O usuário foi alterado com sucesso.");
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

    @GetMapping(value = "/recuperar-digitos-unicos", params = {"id-usuario"})
    public ResponseEntity recuperarDigitosUnicosDeUsuario(@RequestParam("id-usuario") Integer idUsuario) {

        ListarDigitosUnicosUsuarioQuery query = ListarDigitosUnicosUsuarioQuery.builder()
                                                                               .idUsuario(idUsuario)
                                                                               .build();

        return ResponseEntity.ok(this.listarDigitosUnicosUsuarioHandler.handle(query));
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Não há usuário cadastrado com esse ID.")
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public void usuarioNaoEncontradoException() { /* Método para tratamento de exceção. */ }

}
