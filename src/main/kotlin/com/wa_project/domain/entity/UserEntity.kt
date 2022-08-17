package com.wa_project.domain.entity

import org.springframework.data.annotation.Id
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.GeneratedValue

class UserEntity {
    @Id
    @GeneratedValue
    var identificador: Integer? = null
    var nome: String? = null
    var documento : String? = null
    @Column(name = "data_de_criacao")
    var dataDeCriacao : LocalDate? = null
    @Column(name = "data_de_atualizacao")
    var dataDeAtualização : LocalDate? = null
}