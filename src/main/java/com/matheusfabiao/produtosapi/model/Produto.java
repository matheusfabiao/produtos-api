package com.matheusfabiao.produtosapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String marca;

    @Column
    private Integer valor;
}