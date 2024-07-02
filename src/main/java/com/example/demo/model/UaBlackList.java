package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UaBlackList {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer ip;
}
