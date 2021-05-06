package br.com.gestorfinanceiro.infrastructure.web.api;

import br.com.gestorfinanceiro.domain.model.Usuario;
import br.com.gestorfinanceiro.domain.usecase.usuario.CriarUsuarioUseCase;
import br.com.gestorfinanceiro.domain.usecase.usuario.UsuarioDataRow;
import br.com.gestorfinanceiro.infrastructure.web.api.dto.UsuarioRequest;
import br.com.gestorfinanceiro.infrastructure.web.api.dto.UsuarioResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CriarUsuarioControllerTest {

    private static final String EMAIL = "email@email.com";
    private static final String NOME = "Fulano";
    private static final int IDADE = 18;

    @InjectMocks
    CriarUsuarioController criarUsuarioConstroller;

    @Mock
    private CriarUsuarioUseCase criarUsuario;

    @Test
    public void deve_criar_e_retornar_objeto_criado() {
        //arrange
        UsuarioRequest request = UsuarioRequest.builder()
                .email(EMAIL)
                .nome(NOME)
                .idade(IDADE)
                .build();

        UsuarioResponse respostaEsperada =  UsuarioResponse.builder().email(EMAIL).nome(NOME)
                .idade(IDADE)
                .build();
        UsuarioDataRow usuarioDataRow = UsuarioDataRow.builder().email(EMAIL).nome(NOME)
                .idade(IDADE).build();
        Usuario usuario = Usuario.builder().email(EMAIL).nome(NOME)
                .idade(IDADE).build();
        when(criarUsuario.fromData(usuarioDataRow)).thenReturn(usuario);
        //action
        ResponseEntity<UsuarioResponse> resposta = criarUsuarioConstroller.criar(request);
        //assert
        assertEquals(HttpStatus.CREATED, resposta.getStatusCode().CREATED);
        assertEquals(respostaEsperada, resposta.getBody());
    }

}