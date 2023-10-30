package com.simBank.controller.dto;

import com.simBank.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String cpf, String password, String email, BigDecimal balance, UserType userType){
}
