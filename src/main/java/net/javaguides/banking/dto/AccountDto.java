package net.javaguides.banking.dto;


public record AccountDto(Long id, //Using Long, so that the default value is null.
                         String accountHolderName,
                         double balance) {
}
