package br.inter.desafio.domain.entities.usuario;

import br.inter.desafio.domain.readmodel.usuario.UsuarioDTO;

import java.util.List;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    UsuarioDTO listarPorId(Integer idUsuario);

    List<UsuarioDTO> listarTodos();

    void deletar(Integer idUsuario);

    void alterar(Integer idUsuario, String nome, String email);

    void calcularDigitoUnicoParaUsuario(Integer idUsuario, String valorASerConcatenado, int numeroDeConcatenacoes);

    List<UsuarioDTO.DigitoUnico> recuperarCalculosDeDigitoUnicoDeUmUsuario(Integer idUsuario);

}
