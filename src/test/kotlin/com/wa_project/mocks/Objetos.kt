package com.wa_project.mocks

import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.entity.UserEntity
import com.wa_project.domain.response.UserResponse
import java.time.LocalDate

class Objetos {
    fun alimentaDTO(): UserDTO {
        var novoObj:UserDTO = UserDTO()
        novoObj.dataDeCriacao = LocalDate.now()
        novoObj.dataDeAtualização = LocalDate.now()
        novoObj.nome = "teste"
        novoObj.documento = "teste"
        novoObj.identificador = Integer(1)
        return  novoObj
    }

    fun alimentaEntity(): UserEntity {
        var novoObj:UserEntity = UserEntity()
        novoObj.dataDeCriacao = LocalDate.now()
        novoObj.dataDeAtualização = LocalDate.now()
        novoObj.nome = "teste"
        novoObj.documento = "teste"
        novoObj.identificador = Integer(1)
        return  novoObj
    }

    fun alimentaResponse(): UserResponse {
        var novoObj:UserResponse = UserResponse()
        novoObj.dataDeCriacao = LocalDate.now()
        novoObj.dataDeAtualização = LocalDate.now()
        novoObj.nome = "teste"
        novoObj.documento = "teste"
        novoObj.identificador = Integer(1)
        return  novoObj
    }
}