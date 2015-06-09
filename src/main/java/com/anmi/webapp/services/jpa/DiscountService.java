package com.anmi.webapp.services.jpa;

import com.anmi.webapp.entity.DiscountProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountService extends JpaRepository<DiscountProgram,Long> {
}
