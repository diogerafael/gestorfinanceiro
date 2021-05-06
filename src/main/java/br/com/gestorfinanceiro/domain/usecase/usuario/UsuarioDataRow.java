package br.com.gestorfinanceiro.domain.usecase.usuario;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public final class  UsuarioDataRow {
    private final String email;
    private final String nome;
    private final int idade;
}
