package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.readmodel.digitounico.DigitoUnicoDTO;
import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    UsuarioDTO recuperar(Integer idUsuario);

    void deletar(Integer idUsuario);

    void alterar(Integer idUsuario, String nome, String email);

    void calcularDigitoUnicoParaUsuario(Integer idUsuario, String valorASerConcatenado, int numeroDeConcatenacoes);

    DigitoUnicoDTO recuperarCalculosDeDigitoUnicoDeUmUsuario(Integer idUsuario);

}
