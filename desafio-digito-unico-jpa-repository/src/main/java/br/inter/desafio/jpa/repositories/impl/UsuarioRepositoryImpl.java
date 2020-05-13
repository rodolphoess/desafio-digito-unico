package br.inter.desafio.jpa.repositories.impl;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.domain.entities.usuario.Usuario;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toList;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<Integer, Usuario> usuarios = newHashMap();

    @Override
    public void salvar(Usuario usuario) {

        usuarios.put(usuarios.size() + 1, usuario);
    }

    @Override
    public UsuarioDTO recuperar(Integer idUsuario) {

        Usuario usuario = usuarios.get(idUsuario);

        return usuarioDominioParaDto(usuario, idUsuario);
    }

    private UsuarioDTO usuarioDominioParaDto(Usuario usuario, Integer idUsuario) {
        return new UsuarioDTO(idUsuario,
                              usuario.getNome(),
                              usuario.getEmail().getEmailFornecido(),
                              instanciarCalculosDigitosUnicos(usuario.getDigitosUnicosCalculados())
        );
    }

    private List<UsuarioDTO.DigitoUnico> instanciarCalculosDigitosUnicos(List<DigitoUnico> digitosUnicosCalculados) {
        return digitosUnicosCalculados.stream()
                                      .map(this::instanciarCalculoDigitoUnico)
                                      .collect(toList());
    }

    private UsuarioDTO.DigitoUnico instanciarCalculoDigitoUnico(DigitoUnico digitoUnico) {
        return new UsuarioDTO.DigitoUnico(digitoUnico.getValorASerConcatenado(),
                                          digitoUnico.getNumeroDeConcatenacoes(),
                                          digitoUnico.getValorDigitoUnico()
        );
    }

}
