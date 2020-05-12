package br.inter.desafio.application.manterdigitounico.handlers;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.domain.entities.digitounico.DigitoUnicoRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class CalcularDigitoUnicoHandler {

    private final DigitoUnicoRepository digitoUnicoRepository;

    public CalcularDigitoUnicoHandler(DigitoUnicoRepository digitoUnicoRepository) {
        this.digitoUnicoRepository = digitoUnicoRepository;
    }

    public int handle(CalcularDigitoUnicoCommand command) {
        requireNonNull(command);

        DigitoUnico digitoUnico = DigitoUnico.calcularDigitoUnico(command.getValorASerConcatenado(),
                                                                  command.getFatorDeConcatenacao()
        );

        this.digitoUnicoRepository.salvar(digitoUnico);

        return digitoUnico.getValorDigitoUnico();
    }

}
