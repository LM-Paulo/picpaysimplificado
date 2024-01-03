package com.picpaysimplificado.dto;

import java.math.BigDecimal;

public record UserDto (String fisrtName, String lastName, String document, String email, String password, BigDecimal balance) {
}
