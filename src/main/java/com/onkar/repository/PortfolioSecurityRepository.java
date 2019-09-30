package com.onkar.repository;

import com.onkar.domain.Portfolio;
import com.onkar.domain.PortfolioSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioSecurityRepository  extends JpaRepository<PortfolioSecurity, Long>
{
    @Query("SELECT ps FROM PortfolioSecurity ps join ps.portfolio p WHERE ps.symbol= :symbol AND p.userId = :userId")
    List<PortfolioSecurity> findPortfoliosWithMatchingSecurity(@Param("userId") Integer userId,@Param("symbol") String symbol);
}
