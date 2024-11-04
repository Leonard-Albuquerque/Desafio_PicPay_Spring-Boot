package com.picpaySimplificado.picpaySimplificado.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderID, Long receiverId) {

}
