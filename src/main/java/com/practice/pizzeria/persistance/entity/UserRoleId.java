package com.practice.pizzeria.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleId implements Serializable {
    private String username;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId that)) return false;

        if (!username.equals(that.username)) return false;
        return role.equals(that.role);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
