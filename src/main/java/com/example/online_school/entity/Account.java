package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "accounts")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID id;

    @Column(name = "balanced")
    private BigDecimal balanced;

    @Column(name = "isActive")
    boolean isActive;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
