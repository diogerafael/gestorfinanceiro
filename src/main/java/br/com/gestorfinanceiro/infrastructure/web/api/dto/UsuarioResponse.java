package br.com.gestorfinanceiro.infrastructure.web.api.dto;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class UsuarioResponse {
    private final String email;
    private final String nome;
    private final int idade;
}
