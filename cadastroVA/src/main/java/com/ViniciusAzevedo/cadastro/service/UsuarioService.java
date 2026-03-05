package com.ViniciusAzevedo.cadastro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ViniciusAzevedo.cadastro.model.Usuario;
import com.ViniciusAzevedo.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {



    //injeção de dependencia se trata da conexão de uma camada com a outra, injetando o contexto da camada service no controller por exemplo, o programa é burro pra crlh então ele precisa que a gente oriente esse animal.
    //forma 1:
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

     public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User não encontrado"));
    }


    public Usuario atualizar(Long id, Usuario dados) {
        Usuario usuario = repository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setSenha(dados.getSenha());
        usuario.setPerfil(dados.getPerfil());
        usuario.setEndereco(dados.getEndereco());
        usuario.setBairro(dados.getBairro());
        usuario.setComplemento(dados.getComplemento());
        usuario.setCep(dados.getCep());
        usuario.setCidade(dados.getCidade());
        usuario.setEstado(dados.getEstado());
        usuario.setFoto(dados.getFoto());

        return repository.save(usuario);
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    public Usuario login(String email, String senha) {

        Usuario usuario = repository.findByEmail(email);

        if (usuario == null) {
            return null;
        }

        if (usuario.getSenha().equals(senha)) {
            return usuario;
        }

        return null;
    }

}
