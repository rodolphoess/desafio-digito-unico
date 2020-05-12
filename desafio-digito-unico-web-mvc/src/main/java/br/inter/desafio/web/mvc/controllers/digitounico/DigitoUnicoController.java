package br.inter.desafio.web.mvc.controllers.digitounico;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.application.manterdigitounico.handlers.CalcularDigitoUnicoHandler;
import br.inter.desafio.web.mvc.controllers.digitounico.form.CalcularDigitoUnicoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/digito-unico")
public class DigitoUnicoController {

    private final CalcularDigitoUnicoHandler calcularDigitoUnicoHandler;

    public DigitoUnicoController(CalcularDigitoUnicoHandler calcularDigitoUnicoHandler) {
        this.calcularDigitoUnicoHandler = calcularDigitoUnicoHandler;
    }

    @PostMapping("/calcular")
    public ResponseEntity calcularDigitoUnico(@RequestBody CalcularDigitoUnicoForm form) {

        CalcularDigitoUnicoCommand command = CalcularDigitoUnicoCommand.builder()
                                                                       .valorASerConcatenado(form.getValorASerConcatenado())
                                                                       .fatorDeConcatenacao(form.getFatorDeConcatenacao())
                                                                       .build();

        this.calcularDigitoUnicoHandler.handle(command);

        return ResponseEntity.ok().build();
    }

}
