package com.onkar.dao;

import com.onkar.domain.PortfolioSecurity;
import com.onkar.repository.PortfolioSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PortfolioSecurityDAO
{
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private PortfolioSecurityRepository repoPS;

    public List<PortfolioSecurity> findPortfoliosWithMatchingSecurity(Integer userId, String symbol)
    {
        List<PortfolioSecurity> p = repoPS.findPortfoliosWithMatchingSecurity(userId,symbol);
        return p;
    }

    public List<PortfolioSecurity> findSecuritiesInPortfolio(Integer userId, Long portfolio)
    {
        String sql = "SELECT PS.ID, PS.PORTFOLIO_ID, PS.SYMBOL, PS.UNITS, PS.COST_PER_UNIT, PS.DATE_PURCHASED, S.SECTOR,P.NAME" +
                " FROM PORTFOLIO P" +
                " INNER JOIN PORTFOLIO_SECURITY PS ON P.ID = PS.PORTFOLIO_ID" +
                " LEFT OUTER JOIN SECURITY S ON PS.SYMBOL = S.SYMBOL" +
                " WHERE P.ID = "+portfolio+" AND P.USER_ID = "+userId;

        return template.query(sql, new RowMapper<PortfolioSecurity>() {

            @Override
            public PortfolioSecurity mapRow(ResultSet resultSet, int i) throws SQLException {
                PortfolioSecurity ps = new PortfolioSecurity();

                ps.setId( resultSet.getLong("ID"));
                ps.setSymbol( resultSet.getString("SYMBOL"));
                ps.setUnits( resultSet.getInt("UNITS"));
                ps.setCostPerUnit( resultSet.getFloat("COST_PER_UNIT"));
                ps.setDatePurchased(resultSet.getDate("DATE_PURCHASED"));
                ps.setPortfolioId( resultSet.getInt("PORTFOLIO_ID"));
                ps.setPortfolioName( resultSet.getString("NAME"));


                return ps;
            }
        });
    }

}
