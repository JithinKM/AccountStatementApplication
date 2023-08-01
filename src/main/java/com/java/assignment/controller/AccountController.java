package com.java.assignment.controller;

import com.java.assignment.model.Account;
import com.java.assignment.model.AccountStatement;
import com.java.assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Account controller class.
 *
 * @author Jithin KM
 */
@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Get all accounts list.
     *
     * @return all account list
     */
    @GetMapping
    ResponseEntity<List<Account>> getHomePage() {

        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    /**
     * Get account details along with the statement.
     * Get the account number and the statements for a specific account id.
     * The from-date and to-date are specified as the request params.
     * The minimum and maximum amount to be included in the statement are specified as
     * from-amount & to-amount in the request params.
     * If either from-date or to-date is not specified, the statement for the past 3 moths
     * statement is returned.
     * @param id account id
     * @param fromDate from date
     * @param toDate to date
     * @param fromAmount from amount
     * @param toAmount to amount
     *
     * @return statements list
     */
    @GetMapping("/account/{id}")
    ResponseEntity<AccountStatement> getAccountStatement(
            @PathVariable("id") final long id,
            @RequestParam(required = false) final String fromDate,
            @RequestParam(required = false) final String toDate,
            @RequestParam(value = "fromAmount", defaultValue = "0") final Long fromAmount,
            @RequestParam(value = "toAmount", defaultValue = Long.MAX_VALUE + "") final Long toAmount) {

        AccountStatement accountStatements = accountService.getAccountStatements(id, fromDate, toDate, fromAmount,
                toAmount);

        return new ResponseEntity<>(accountStatements, HttpStatus.OK);
    }
}
