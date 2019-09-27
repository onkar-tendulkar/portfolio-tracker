package com.onkar.repository;
import com.onkar.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>
{
    @Query("SELECT t  FROM Portfolio t where t.userId = ?1")
    List<Portfolio> findPortfolioByUserId( Integer userId);
}