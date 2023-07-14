package com.java.assignment.repository;

import com.java.assignment.entity.AccountEntity;
import com.java.assignment.entity.StatementEntity;
import com.java.assignment.exception.AccountNotFoundException;
import com.java.assignment.repository.impl.AccountRepositoryImpl;
import com.java.assignment.repository.mapper.AccountMapper;
import com.java.assignment.repository.mapper.StatementMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Account repository test class
 *
 * @author Jithin KM
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplateMock;

    @InjectMocks
    private AccountRepositoryImpl accountRepository;

    @Test
    public void getAllAccountsSuccessTest() {

        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities.add(new AccountEntity(2L, "current", "12345678"));
        Mockito.when(jdbcTemplateMock.query(Mockito.anyString(),
                Mockito.any(AccountMapper.class))).thenReturn(accountEntities);

        List<AccountEntity> allAccounts = accountRepository.getAllAccounts();

        assertEquals(1, allAccounts.size());
        assertEquals("12345678", allAccounts.stream().findFirst().get().getAccountNumber());
    }

    @Test
    public void getAllAccountByAccountIdSuccessTest() {

        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities.add(new AccountEntity(2L, "current", "12345678"));
        Mockito.when(jdbcTemplateMock.query(Mockito.anyString(),
                Mockito.any(AccountMapper.class), Mockito.anyLong())).thenReturn(accountEntities);

        AccountEntity accountByAccountId = accountRepository.getAccountByAccountId(2L);

        assertEquals("12345678", accountByAccountId.getAccountNumber());
    }

    @Test(expected = AccountNotFoundException.class)
    public void getAllAccountByAccountIdFailureTest() {

        Mockito.when(jdbcTemplateMock.query(Mockito.anyString(),
                Mockito.any(AccountMapper.class), Mockito.anyLong())).thenReturn(new ArrayList<>());

        try {
        accountRepository.getAccountByAccountId(122L);
        } catch (AccountNotFoundException e) {
            String expectedMessage = "No data found for id:  122";
            assertEquals(expectedMessage, e.getMessage());
            throw e;
        }

        fail("AccountNotFoundException did not throw!");
    }

    @Test
    public void getAllStatementByAccountIdSuccessTest() {

        List<StatementEntity> statementEntityList = new ArrayList<>();
        statementEntityList.add(new StatementEntity(1L, 2L, "09.08.2020", "535.197875027054"));
        Mockito.when(jdbcTemplateMock.query(Mockito.anyString(),
                Mockito.any(StatementMapper.class), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDate.class), Mockito.any(LocalDate.class))).thenReturn(statementEntityList);

        List<StatementEntity> statementByAccountNumber = accountRepository.getStatementByAccountNumber(2L, 100L, 200L, LocalDate.now(), LocalDate.now());
        assertEquals(1, statementByAccountNumber.size());
        assertEquals("535.197875027054", statementByAccountNumber.stream().findFirst().get().getAmount());
        assertEquals("09.08.2020", statementByAccountNumber.stream().findFirst().get().getDateField());
    }
}
