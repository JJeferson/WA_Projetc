package com.wa_project.mapper
import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity
import com.wa_project.domain.response.UserResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface DtoToResponse {
    fun convert(userDTO: UserDTO?): UserResponse?
}