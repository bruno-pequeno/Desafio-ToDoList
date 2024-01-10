package com.bruno.desafiotodolist.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_todos")
public class TodoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private boolean realizado;

    private int prioridade;
}
