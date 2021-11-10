package com.gabriel.projeto.domain;

import com.gabriel.projeto.enuns.Situacao;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Entity
@Getter
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
    private Long id;

    @Setter
    @NotNull
    private String assunto;

    @Setter
    private Situacao situacao;

    public Tarefa() {

    }
}
