package com.github.gif26.izzy_financs.model;

import com.github.gif26.izzy_financs.dto.request.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table(name = "Users")
@Entity(name = "User")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    public User(UserRequestDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
//        this.password = new BCryptPasswordEncoder().encode(dto.password());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
