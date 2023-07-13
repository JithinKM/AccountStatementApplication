package com.java.assignment.service.impl;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;
import com.java.assignment.model.AccountStatement;
import com.java.assignment.model.Statement;
import com.java.assignment.repository.AccountRepository;
import com.java.assignment.service.AccountService;
import com.java.assignment.utils.DateUtils;
import com.java.assignment.utils.StringHashUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Account service implementation
 *
 * @author Jithin KM
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountStatement getAccountStatements(long id, String fromDateString, String toDateString, long fromAmount, long toAmount) {

        AccountEntity account = accountRepository.getAccountByAccountId(id);
        logger.info("Account details fetched for id {}: ", id);
        String hashedAccountNumber = StringHashUtils.getHashedString(account.getAccountNumber());

        LocalDate threeMonthsAgo = LocalDate.now().minusDays(90);
        LocalDate today = LocalDate.now();
        LocalDate fromDate;
        LocalDate toDate;

        if (StringUtils.isEmpty(fromDateString) || StringUtils.isEmpty(toDateString)) {
            fromDate = threeMonthsAgo;
            toDate = today;
        } else {
            fromDate = Optional.ofNullable(DateUtils.parseDate(fromDateString)).orElse(threeMonthsAgo);
            toDate = Optional.ofNullable(DateUtils.parseDate(toDateString)).orElse(today);
        }

        List<StatementEntity> statementEntityList = accountRepository.getStatementByAccountNumber(id, fromAmount, toAmount, fromDate, toDate);
        List<Statement> statementList = statementEntityList.stream().map(
                statementEntity -> new Statement(statementEntity.getDateField(), statementEntity.getAmount())).toList();

        return new AccountStatement(id, hashedAccountNumber, statementList);
    }
}
