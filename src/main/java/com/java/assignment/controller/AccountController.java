package com.java.assignment.controller;

import com.java.assignment.model.AccountStatement;
import com.java.assignment.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Account controller class
 *
 * @author Jithin KM
 */
@RestController
@RequestMapping("/")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    /**
     * Get account details along with the statement
     * Get the account number and the statements for a specific account id.
     * The from-date and to-date are specified as the request params.
     * The minimum and maximum amount to be included in the statement are specified as
     * from-amount & to-amount in the request params.
     * If either from-date or to-date is not specified, the statement for the past 3 moths
     * statement is returned.
     *
     * @return statements list
     */
    @GetMapping("/account/{id}")
    ResponseEntity<AccountStatement> getAccountStatement(
            @PathVariable("id") long id,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @RequestParam(value = "fromAmount", defaultValue = "0") Long fromAmount,
            @RequestParam(value = "toAmount", defaultValue = Long.MAX_VALUE + "") Long toAmount) {

        AccountStatement accountStatements = accountService.getAccountStatements(id, fromDate, toDate, fromAmount, toAmount);

        return new ResponseEntity<>(accountStatements, HttpStatus.OK);
    }
}
