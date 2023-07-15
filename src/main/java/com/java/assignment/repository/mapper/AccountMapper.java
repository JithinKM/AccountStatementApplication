package com.java.assignment.repository.mapper;

import com.java.assignment.entity.AccountEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for Account table.
 *
 * @author Jithin KM
 */
public class AccountMapper  implements RowMapper<AccountEntity> {

    /**
     * Map account result set to AccountEntity.
     * @throws {@link SQLException}
     *
     * @return AccountEntity
     */
    @Override
    public AccountEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new AccountEntity(rs.getLong("id"), rs.getString("account_type"),
                rs.getString("account_number"));
    }
}
