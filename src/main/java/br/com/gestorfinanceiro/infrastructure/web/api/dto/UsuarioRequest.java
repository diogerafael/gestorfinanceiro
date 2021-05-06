package br.com.gestorfinanceiro.infrastructure.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UsuarioRequest {
    public String email;
    public String nome;
    public int idade;
}
