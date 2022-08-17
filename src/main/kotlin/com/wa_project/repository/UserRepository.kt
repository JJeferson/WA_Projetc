package com.wa_project.repository


import com.wa_project.domain.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<UserEntity, Integer> {
    fun save(userEntity: UserEntity?): UserEntity?
    fun findByIdentificador (id : Integer? ): UserEntity?
}