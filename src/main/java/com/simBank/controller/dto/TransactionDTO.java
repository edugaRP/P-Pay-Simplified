package com.simBank.controller.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderID, Long receiverID) {

}
