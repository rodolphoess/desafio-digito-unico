package br.inter.desafio.jpa.repositories.impl;

import br.inter.desafio.domain.entities.usuario.Usuario;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<Integer, Usuario> usuarios = newHashMap();

    @Override
    public void salvar(Usuario usuario) {

        usuarios.put(usuarios.size() + 1, usuario);

        usuarios.get(0);

    }

}
