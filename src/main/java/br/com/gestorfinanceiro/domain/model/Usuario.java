package br.com.gestorfinanceiro.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
public class Usuario {
    private final String email;
    private final String nome;
    private final int idade;

    public String email() {
        return email;
    }

    public String nome() {
        return nome;
    }

    public int idade() {
        return idade;
    }
}