package com.java.assignment.service.impl;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;
import com.java.assignment.model.AccountStatement;
import com.java.assignment.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        Assert.assertEquals(3L, actualAccountStatement.getAccountId());
        Assert.assertEquals("87.8901139771573", actualAccountStatement.getStatementList().stream().findFirst().get().getAmount());
    }
}
