package com.thiunuwan.authservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;


    private String authority;     //authority means --> role name

    public Role(String authority) {
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
