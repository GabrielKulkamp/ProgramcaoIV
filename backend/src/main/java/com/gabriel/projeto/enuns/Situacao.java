package com.gabriel.projeto.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situacao {
    INICIADA(1,"Iniciada"),
    PROGRESSO(2,"Em Progresso"),
    CONCLUIDA(3, "Encerrada");

    private final int value;
    private final String descricao;

}
