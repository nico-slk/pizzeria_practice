package com.practice.pizzeria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Id
    @Column(nullable = false, length = 20)
    private String role;
    @Column(name = "role_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime roleDate;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false)
    private UserEntity user;
}

