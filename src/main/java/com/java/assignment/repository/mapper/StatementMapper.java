package com.java.assignment.repository.mapper;

import com.java.assignment.entity.StatementEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for Statement table
 *
 * @author Jithin KM
 */
public class StatementMapper implements RowMapper<StatementEntity> {
    @Override
    public StatementEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new StatementEntity(rs.getLong("id"), rs.getLong("account_id"),
                rs.getString("datefield"), rs.getString("amount"));
    }
}
