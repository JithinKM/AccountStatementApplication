package com.java.assignment.repository.impl;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;
import com.java.assignment.exception.AccountNotFoundException;
import com.java.assignment.repository.AccountRepository;
import com.java.assignment.repository.mapper.AccountMapper;
import com.java.assignment.repository.mapper.StatementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Account repository implementation.
 *
 * @author Jithin KM
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Get all accounts
     *
     * @return list of Account
     */
    @Override
    public List<AccountEntity> getAllAccounts() {
        return jdbcTemplate.query("SELECT * FROM account", new AccountMapper());
    }

    /**
     * Get account details from the Account table for a specific accountId.
     *
     * @param accountId account id for which the account details to be fetched
     * @return Account details
     */
    @Override
    public AccountEntity getAccountByAccountId(final Long accountId) {

        List<AccountEntity> accountEntities = jdbcTemplate.query("SELECT * FROM account WHERE id = ?",
                new AccountMapper(), accountId);

        return accountEntities.stream().findAny().orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    /**
     * Get statement from the Statement table for a specific accountId.
     *
     * @param accountId account id for which the statement to be fetched
     * @return list of statements
     */
    @Override
    public List<StatementEntity> getStatementByAccountNumber(final long accountId, final long fromAmount,
                                                             final long toAmount, final LocalDate fromDate,
                                                             final LocalDate toDate) {

        return jdbcTemplate.query("SELECT * FROM statement WHERE account_id = ? AND CAST(amount AS FLOAT) > ? " +
                        "AND CAST(amount AS FLOAT) < ? AND TO_DATE(datefield, 'dd.mm.yyyy') > ? " +
                        "AND TO_DATE(datefield, 'dd.mm.yyyy') < ?",
                new StatementMapper(), accountId, fromAmount, toAmount, fromDate, toDate);
    }
}
