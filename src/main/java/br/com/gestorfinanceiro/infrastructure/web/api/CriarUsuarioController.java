package br.com.gestorfinanceiro.infrastructure.web.api;

import br.com.gestorfinanceiro.domain.model.Usuario;
import br.com.gestorfinanceiro.domain.usecase.usuario.CriarUsuarioUseCase;
import br.com.gestorfinanceiro.domain.usecase.usuario.UsuarioDataRow;
import br.com.gestorfinanceiro.infrastructure.web.api.dto.UsuarioRequest;
import br.com.gestorfinanceiro.infrastructure.web.api.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class CriarUsuarioController {

    private CriarUsuarioUseCase criarUsuario;

    @Autowired
    public CriarUsuarioController(CriarUsuarioUseCase criarUsuario){
        this.criarUsuario = criarUsuario;
    }

    public ResponseEntity<UsuarioResponse> criar(UsuarioRequest usuarioRequest) {

        UsuarioDataRow usuarioDataRow = UsuarioDataRow.builder().email(usuarioRequest.email).idade(usuarioRequest.idade).nome(usuarioRequest.nome).build();

        Usuario  usuarioCriado = criarUsuario.fromData(usuarioDataRow);

        UsuarioResponse response = UsuarioResponse.builder().email(usuarioCriado.email()).idade(usuarioCriado.idade()).nome(usuarioCriado.nome()).build();
        ResponseEntity<UsuarioResponse> usuarioResponseResponseEntity = new ResponseEntity<UsuarioResponse>(
                response,HttpStatus.CREATED);

        return usuarioResponseResponseEntity;
    }
}
