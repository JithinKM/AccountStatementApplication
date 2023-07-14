package com.java.assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Account controller test class
 *
 * @author Jithin KM
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles="USER")
    public void getHomePageSuccessTest() throws Exception {

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles="USER")
    public void getAccountStatementSuccessTest() throws Exception {

        this.mockMvc.perform(get("/account/3"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void getAccountStatementWithParamsSuccessTest() throws Exception {

        this.mockMvc.perform(get("/account/3?fromDate=12-07-2020&toDate=15-11-2020&fromAmount=50&toAmount=600"))
                .andExpect(status().isOk());
    }
}
