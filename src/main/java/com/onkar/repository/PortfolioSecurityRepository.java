package com.onkar.repository;

import com.onkar.domain.Portfolio;
import com.onkar.domain.PortfolioSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioSecurityRepository  extends JpaRepository<PortfolioSecurity, Long>
{
}
