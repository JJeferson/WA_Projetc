package com.wa_project.domain.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Id
@Entity
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