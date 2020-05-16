package br.inter.desafio.web.mvc.controllers.digitounico;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.application.manterdigitounico.handlers.CalcularDigitoUnicoHandler;
import br.inter.desafio.web.mvc.controllers.digitounico.form.CalcularDigitoUnicoForm;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping
public class DigitoUnicoController {

    private final CalcularDigitoUnicoHandler calcularDigitoUnicoHandler;

    public DigitoUnicoController(CalcularDigitoUnicoHandler calcularDigitoUnicoHandler) {
        this.calcularDigitoUnicoHandler = calcularDigitoUnicoHandler;
    }

    @GetMapping("/")
    @ApiIgnore
    public String root() {
        return "index";
    }

    @PostMapping("/calcular")
    @ApiOperation(value = "Calcula o dígito único para o valor e fator passados.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Valor dígito único: (valor)"),
                            @ApiResponse(code = 500, message = "É necessário informar um valor para cálculo do dígito único maior do que zero. Por favor, informe um valor válido.")})
    public ResponseEntity calcularDigitoUnico(@RequestBody CalcularDigitoUnicoForm form) {

        CalcularDigitoUnicoCommand command = CalcularDigitoUnicoCommand.builder()
                                                                       .valorASerConcatenado(form.getValorASerConcatenado())
                                                                       .numeroDeConcatenacoes(form.getFatorDeConcatenacao())
                                                                       .build();

        return ResponseEntity.ok("Valor dígito único: " + this.calcularDigitoUnicoHandler.handle(command));
    }

}
