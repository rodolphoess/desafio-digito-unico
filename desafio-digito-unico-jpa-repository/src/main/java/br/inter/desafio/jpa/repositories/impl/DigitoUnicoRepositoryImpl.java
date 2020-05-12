package br.inter.desafio.jpa.repositories.impl;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.domain.entities.digitounico.DigitoUnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Repository
@AllArgsConstructor
public class DigitoUnicoRepositoryImpl implements DigitoUnicoRepository {

    private final Map<Integer, DigitoUnico> digitosUnicos = newHashMap();

    @Override
    public void salvar(DigitoUnico digitoUnico) {

        digitosUnicos.put(digitosUnicos.size() + 1, digitoUnico);

    }

}
