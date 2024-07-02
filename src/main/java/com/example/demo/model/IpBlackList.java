package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ip_blacklist")
public class IpBlackList {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String ip;

}
