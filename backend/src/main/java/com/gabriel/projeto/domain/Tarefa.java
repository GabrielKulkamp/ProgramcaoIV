package com.gabriel.projeto.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
    private Long id;

    @Setter
    private String titulo;

    @Setter
    private String descricao;

    @Setter
    private boolean isFinalizado;
}
