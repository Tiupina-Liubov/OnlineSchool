package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
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

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isActive == account.isActive && Objects.equals(id, account.id) && Objects.equals(balanced, account.balanced) && Objects.equals(createAt, account.createAt) && Objects.equals(updateAt, account.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balanced, isActive, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balanced=" + balanced +
                ", isActive=" + isActive +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
