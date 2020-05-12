package br.inter.desafio.application.manterdigitounico.handlers;

import br.inter.desafio.application.manterdigitounico.commands.CalcularDigitoUnicoCommand;
import br.inter.desafio.domain.entities.digitounico.DigitoUnicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalcularDigitoUnicoHandler {

    private final DigitoUnicoRepository digitoUnicoRepository;

    public CalcularDigitoUnicoHandler(DigitoUnicoRepository digitoUnicoRepository) {
        this.digitoUnicoRepository = digitoUnicoRepository;
    }

    public void handle(CalcularDigitoUnicoCommand command) {



    }

}
