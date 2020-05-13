package br.inter.desafio.web.mvc.controllers.digitounico;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.application.manterdigitounico.handlers.CalcularDigitoUnicoHandler;
import br.inter.desafio.web.mvc.controllers.digitounico.form.CalcularDigitoUnicoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DigitoUnicoController {

    private final CalcularDigitoUnicoHandler calcularDigitoUnicoHandler;

    public DigitoUnicoController(CalcularDigitoUnicoHandler calcularDigitoUnicoHandler) {
        this.calcularDigitoUnicoHandler = calcularDigitoUnicoHandler;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/calcular")
    public ResponseEntity calcularDigitoUnico(@RequestBody CalcularDigitoUnicoForm form) {

        CalcularDigitoUnicoCommand command = CalcularDigitoUnicoCommand.builder()
                                                                       .valorASerConcatenado(form.getValorASerConcatenado())
                                                                       .numeroDeConcatenacoes(form.getFatorDeConcatenacao())
                                                                       .build();

        return ResponseEntity.ok("Valor dígito único: " + this.calcularDigitoUnicoHandler.handle(command));
    }

}
