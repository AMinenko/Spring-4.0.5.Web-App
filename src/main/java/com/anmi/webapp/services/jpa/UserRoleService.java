package com.anmi.webapp.services.jpa;

import com.anmi.webapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleService extends JpaRepository<Role,Long> {
}
