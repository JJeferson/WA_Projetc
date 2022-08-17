package com.wa_project.repository

import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Integer> {
    fun save(userEntity: UserEntity?): UserEntity?
    fun findByIdentificador (id : Integer? ): UserEntity?
}