package com.java.assignment.service.impl;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;
import com.java.assignment.exception.BusinessException;
import com.java.assignment.model.AccountStatement;
import com.java.assignment.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Account service test class
 *
 * @author Jithin KM
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepositoryMock;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void getAccountStatementsSuccessTest() {

        AccountEntity accountEntity = new AccountEntity(3L, "current", "12345678");
        Mockito.when(accountRepositoryMock.getAccountByAccountId(3L)).thenReturn(accountEntity);

        List<StatementEntity> statementEntityList = new ArrayList<>();
        StatementEntity statementEntity1 = new StatementEntity(1L, 3L, "19.08.2020", "87.8901139771573");
        statementEntityList.add(statementEntity1);
        StatementEntity statementEntity2 = new StatementEntity(2L, 3L, "09.09.2020", "320.113318991709");
        statementEntityList.add(statementEntity2);
        Mockito.when(accountRepositoryMock.getStatementByAccountNumber(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDate.class), Mockito.any(LocalDate.class)))
                .thenReturn(statementEntityList);

        AccountStatement actualAccountStatement = accountService.getAccountStatements(3L, "09-08-2020", "15-09-2020", 100L, 500L);

        assertEquals(3L, actualAccountStatement.getAccountId());
        assertEquals("87.8901139771573", actualAccountStatement.getStatementList().stream().findFirst().get().getAmount());
    }

    @Test(expected = BusinessException.class)
    public void getAccountStatementsIncorrectDateFailureTest() {
        try {
            accountService.getAccountStatements(3L, "09-09-2020", "15-08-2020", 100L, 500L);
        } catch (BusinessException e) {
            String expectedMessage = "fromDate should be less than the toDate: ";
            assertEquals(expectedMessage, e.getMessage());
            throw e;
        }

        fail("BusinessException did not throw!");
    }

    @Test(expected = BusinessException.class)
    public void getAccountStatementsIncorrectAmountFailureTest() {
        try {
            accountService.getAccountStatements(3L, "09-08-2020", "15-09-2020", 100L, 50L);
        } catch (BusinessException e) {
            String expectedMessage = "fromAmount should be less than the toAmount: ";
            assertEquals(expectedMessage, e.getMessage());
            throw e;
        }

        fail("BusinessException did not throw!");
    }

    @Test
    public void getAccountStatementsEmptyDatesSuccessTest() {

        AccountEntity accountEntity = new AccountEntity(3L, "current", "12345678");
        Mockito.when(accountRepositoryMock.getAccountByAccountId(3L)).thenReturn(accountEntity);

        List<StatementEntity> statementEntityList = new ArrayList<>();
        StatementEntity statementEntity1 = new StatementEntity(1L, 3L, "19.08.2020", "87.8901139771573");
        statementEntityList.add(statementEntity1);
        StatementEntity statementEntity2 = new StatementEntity(2L, 3L, "09.09.2020", "320.113318991709");
        statementEntityList.add(statementEntity2);
        Mockito.when(accountRepositoryMock.getStatementByAccountNumber(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDate.class), Mockito.any(LocalDate.class)))
                .thenReturn(statementEntityList);

        AccountStatement actualAccountStatement = accountService.getAccountStatements(3L, "19.08.2020", "", 100L, 50L);


        assertEquals(3L, actualAccountStatement.getAccountId());
        assertEquals("87.8901139771573", actualAccountStatement.getStatementList().stream().findFirst().get().getAmount());
    }
}
