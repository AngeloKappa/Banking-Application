package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.TransactionDto;
import net.javaguides.banking.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTimestamp()
        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.id(),
                transactionDto.accountId(),
                transactionDto.amount(),
                transactionDto.transactionType(),
                transactionDto.timestamp()
        );
    }
}
