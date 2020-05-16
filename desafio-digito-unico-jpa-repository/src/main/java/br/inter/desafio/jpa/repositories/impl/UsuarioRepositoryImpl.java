package br.inter.desafio.jpa.repositories.impl;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.domain.entities.usuario.Usuario;
import br.inter.desafio.domain.entities.usuario.UsuarioNaoEncontradoException;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import br.inter.desafio.shared.value.Email;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toList;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<Integer, Usuario> usuarios = newHashMap();

    private Integer idUsuario = 1;

    @Override
    public void salvar(Usuario usuario) {
        usuario.setId(idUsuario++);

        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public UsuarioDTO listarPorId(Integer idUsuario) {
        Usuario usuario = checarSeHaUsuarioCadastradoComOIdInformado(idUsuario);

        return usuarioDominioParaDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        List<Usuario> listaUsuarios = newArrayList();

        listaUsuarios.addAll(usuarios.values());

        return listaUsuarios.stream().map(this::usuarioDominioParaDTO).collect(toList());
    }

    @Override
    public void deletar(Integer idUsuario) {
        checarSeHaUsuarioCadastradoComOIdInformado(idUsuario);

        usuarios.remove(idUsuario);
    }

    @Override
    public void alterar(Integer idUsuario, String nome, String email) {
        Usuario usuario = checarSeHaUsuarioCadastradoComOIdInformado(idUsuario);

        Usuario novoUsuario = Usuario.recuperar(usuario.getId(), nome, new Email(email), usuario.getDigitosUnicosCalculados());

        usuarios.replace(idUsuario, usuario, novoUsuario);
    }

    @Override
    public void calcularDigitoUnicoParaUsuario(Integer idUsuario, String valorASerConcatenado, int numeroDeConcatenacoes) {
        Usuario usuario = checarSeHaUsuarioCadastradoComOIdInformado(idUsuario);

        usuario.calcularDigitoUnicoParaUsuario(valorASerConcatenado, numeroDeConcatenacoes);

        usuarios.replace(idUsuario, usuario);
    }

    @Override
    public List<UsuarioDTO.DigitoUnico> recuperarCalculosDeDigitoUnicoDeUmUsuario(Integer idUsuario) {
        Usuario usuario = checarSeHaUsuarioCadastradoComOIdInformado(idUsuario);

        return usuario.getDigitosUnicosCalculados().stream()
                                                   .map(this::instanciarDigitoUnicoUsuario)
                                                   .collect(toList());
    }

    private Usuario checarSeHaUsuarioCadastradoComOIdInformado(Integer idUsuario) {
        Usuario usuario = usuarios.get(idUsuario);

        lancarBloqueioSeNaoHouverUsuarioCadastrado(usuario);

        return usuario;
    }

    private void lancarBloqueioSeNaoHouverUsuarioCadastrado(Usuario usuario) {
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException();
        }
    }

    private UsuarioDTO usuarioDominioParaDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(),
                              usuario.getNome(),
                              usuario.getEmail().getEmailFornecido(),
                              instanciarDigitosUnicosUsuario(usuario.getDigitosUnicosCalculados())
        );
    }

    private List<UsuarioDTO.DigitoUnico> instanciarDigitosUnicosUsuario(List<DigitoUnico> digitosUnicosCalculados) {
        return digitosUnicosCalculados.stream()
                                      .map(this::instanciarDigitoUnicoUsuario)
                                      .collect(toList());
    }

    private UsuarioDTO.DigitoUnico instanciarDigitoUnicoUsuario(DigitoUnico digitoUnico) {
        return new UsuarioDTO.DigitoUnico(digitoUnico.getValorASerConcatenado(),
                                          digitoUnico.getNumeroDeConcatenacoes(),
                                          digitoUnico.getValorDigitoUnico()
        );
    }

}
