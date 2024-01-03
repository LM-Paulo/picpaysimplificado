package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private  String document;

    @Column(unique = true)
    private  String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    public Users(UserDto userDto){
        this.firstName = userDto.fisrtName();
        this.lastName = userDto.lastName();
        this.document = userDto.document();
        this.email = userDto.email();
        this.password = userDto.password();
        this.balance = userDto.balance();

    }




}
