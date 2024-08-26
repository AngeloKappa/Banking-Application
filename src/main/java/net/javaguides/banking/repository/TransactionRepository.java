package net.javaguides.banking.repository;

import net.javaguides.banking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//The method findByAccountIdOrderByTimestampDesc is a custom query method
// defined in your TransactionRepository interface.
// This method is automatically implemented by Spring Data JPA based on its naming convention.
//
//Breaking Down the Method:
//findByAccountId:
//
//This part indicates that you want to find all Transaction entities
// where the accountId field matches the provided Long value (accountId).
//accountId should be a field in the Transaction entity.
//OrderByTimestampDesc:
//
//OrderBy is used to sort the results.
//Timestamp refers to a field in the Transaction entity.
//Desc indicates that the results should be sorted in descending order based on the Timestamp field.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountIdOrderByTimestampDesc(Long accountId);
}
