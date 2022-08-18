package com.wa_project.service

import com.wa_project.mapper.DtoToEntity
import com.wa_project.mapper.EntityToDto
import com.wa_project.mocks.Objetos
import com.wa_project.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.util.Assert



//@ExtendWith(MockitoExtension::class)
@SpringBootTest
@SpringJUnitConfig
class TestService {

    @Mock
    var userRepository: UserRepository? = null
    @Mock
    var dtoToEntity: DtoToEntity? = null
    @Mock
    var entityToDto: EntityToDto? = null
    @InjectMocks
    var userService: UserService? = null

    var mocks : Objetos = Objetos()

    @Test
    fun saveTest() {  //exemplo de teste
        Mockito.`when`(userRepository?.save(any())).thenReturn(mocks.alimentaEntity())
        Mockito.`when`(dtoToEntity?.convert(any())).thenReturn(mocks.alimentaEntity())
        Mockito.`when`(entityToDto?.convert(any())).thenReturn(mocks.alimentaDTO())

        var result = userService?.save(mocks.alimentaDTO())

       Assertions.assertEquals(result?.identificador,1)
    }
}