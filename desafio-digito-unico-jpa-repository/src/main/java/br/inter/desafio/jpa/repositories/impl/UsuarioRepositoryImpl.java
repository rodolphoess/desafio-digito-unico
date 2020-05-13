package br.inter.desafio.jpa.repositories.impl;

import br.inter.desafio.domain.entities.digitounico.DigitoUnico;
import br.inter.desafio.domain.entities.usuario.Usuario;
import br.inter.desafio.domain.entities.usuario.UsuarioNaoEncontradoException;
import br.inter.desafio.domain.entities.usuario.UsuarioRepository;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;
import br.inter.desafio.shared.value.Email;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toList;

@Repository
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<Integer, Usuario> usuarios = newHashMap();

    @Override
    public void salvar(Usuario usuario) {
        usuario.setId(usuarios.size() + 1);

        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public UsuarioDTO listar(Integer idUsuario) {
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
                                                   .map(this::instanciarCalculoDigitoUnico)
                                                   .collect(toList());
    }

    private Usuario checarSeHaUsuarioCadastradoComOIdInformado(Integer idUsuario) {
        Usuario usuario = usuarios.get(idUsuario);

        lancarBloqueioSeNaoHouverUsuarioCadastrado(usuario);

        return usuario;
    }

    private void lancarBloqueioSeNaoHouverUsuarioCadastrado(Usuario usuario) {
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Não há usuário cadastrado com esse ID.");
        }
    }

    private UsuarioDTO usuarioDominioParaDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(),
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
