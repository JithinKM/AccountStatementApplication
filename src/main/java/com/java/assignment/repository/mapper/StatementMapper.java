package com.java.assignment.repository.mapper;

import com.java.assignment.entity.StatementEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for Statement table.
 *
 * @author Jithin KM
 */
public class StatementMapper implements RowMapper<StatementEntity> {

    /**
     * Map statement result set to StatementEntity.
     * @throws {@link SQLException}
     *
     * @return StatementEntity
     */
    @Override
    public StatementEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {

        return new StatementEntity(rs.getLong("id"), rs.getLong("account_id"),
                rs.getString("datefield"), rs.getString("amount"));
    }
}
