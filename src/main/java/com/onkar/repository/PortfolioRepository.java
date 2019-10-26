package com.onkar.repository;
import com.onkar.domain.Portfolio;
import com.onkar.domain.PortfolioSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>
{
    List<Portfolio> findPortfolioByUserId( Integer userId);

    @Query("SELECT p FROM Portfolio p WHERE p.id= :portfolioId AND p.userId = :userId")
    List<Portfolio> findPortfolioByPortfolioIdUserId(@Param("portfolioId") Long portfolioId,@Param("userId") Integer userId);

}