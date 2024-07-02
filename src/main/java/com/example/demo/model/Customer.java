package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private long customerId;

    @Column()
    private long tagId;

    @Column()
    private long userId;

    @Column(nullable = false)
    private String remoteIp;

    @Column(nullable = false)
    private Date timestamp;

    public Customer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Customer(long customerId, long tagId, long userId, String remoteIp, Date timestamp) {
        this.customerId = customerId;
        this.tagId = tagId;
        this.userId = userId;
        this.remoteIp = remoteIp;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Customer {" +
                ", customerId='" + customerId + '\'' +
                ", tagId='" + tagId + '\'' +
                ", userId='" + userId + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
