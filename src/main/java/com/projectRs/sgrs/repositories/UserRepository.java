package com.projectRs.sgrs.repositories;

import com.projectRs.sgrs.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Carga como un bean de spring no se necesita mapear con @Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
