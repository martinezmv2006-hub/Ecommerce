package com.test.ecommerce.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BRANDS")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}