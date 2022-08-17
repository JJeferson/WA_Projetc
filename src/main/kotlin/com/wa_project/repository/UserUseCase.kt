package com.wa_project.repository

import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity

interface UserUseCase {
    fun save(userDTO: UserDTO?): UserDTO?
    fun update(userDTO: UserDTO?): UserDTO?
    fun findByIdentificador (id : Integer? ): UserDTO?
}