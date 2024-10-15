package com.kenneth.springpostgres.entity;

import com.kenneth.springpostgres.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }
}
