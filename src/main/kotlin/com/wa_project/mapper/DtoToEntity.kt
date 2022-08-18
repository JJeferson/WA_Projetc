package com.wa_project.mapper

import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface DtoToEntity {
    fun convert(userDTO: UserDTO?): UserEntity? }