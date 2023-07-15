package com.java.assignment.repository;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * Account repository interface
 *
 * @author Jithin KM
 */
public interface AccountRepository {

    List<AccountEntity> getAllAccounts();
    AccountEntity getAccountByAccountId(Long accountId);
    List<StatementEntity> getStatementByAccountNumber(long accountId, long fromAmount, long toAmount,
                                                      LocalDate fromDate, LocalDate toDate);
}
