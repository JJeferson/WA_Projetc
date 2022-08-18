package com.wa_project.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.wa_project.mapper.DtoToResponse
import com.wa_project.mocks.Objetos
import com.wa_project.service.UserService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class TestController {
    @Autowired
    var mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    var mocks : Objetos= Objetos()
    @Test
    fun saveTest200(){  //exemplo de teste
        var request = mocks.alimentaDTO()
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("http://127.0.0.1:8080/cad/user").
            contentType("application/json").
            content(objectMapper!!.writeValueAsString(request))).
        andExpect(MockMvcResultMatchers.status().isOk)
    }


}