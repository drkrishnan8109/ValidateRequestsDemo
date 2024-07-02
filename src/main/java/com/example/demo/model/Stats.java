package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "hourly_stats",
        uniqueConstraints = {
        @UniqueConstraint(name = "UniqueCustomerAndTime", columnNames = { "customer_id", "time" })
        },
        indexes = @Index(columnList = "customer_id"))
public class Stats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(nullable = false)
    private Timestamp time;

    @Column(name = "request_count", nullable = false)
    private BigInteger requestCount = BigInteger.valueOf(0);

    @Column(name = "invalid_count", nullable = false)
    private BigInteger invalidCount = BigInteger.valueOf(0);

   /* @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;  */

}
