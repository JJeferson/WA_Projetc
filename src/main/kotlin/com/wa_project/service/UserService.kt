package com.wa_project.service

import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity
import com.wa_project.mapper.DtoToEntity
import com.wa_project.mapper.EntityToDto
import com.wa_project.repository.UserRepository
import com.wa_project.repository.UserUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: UserUseCase {
    @Autowired
    var userRepository: UserRepository? = null

    var dtoToEntity: DtoToEntity? = null
    var entityToDto: EntityToDto? = null

    override fun save(userDTO: UserDTO?): UserDTO? {
       return entityToDto?.convert(userRepository?.save(dtoToEntity?.convert(userDTO)))
    }

    override fun update(userDTO: UserDTO?): UserDTO? {
      return entityToDto?.convert(userRepository?.save(dtoToEntity?.convert(userDTO)))
    }

    override fun findByIdentificador(id: Integer?): UserDTO? {
       return entityToDto?.convert(userRepository?.findByIdentificador(id))
    }
}