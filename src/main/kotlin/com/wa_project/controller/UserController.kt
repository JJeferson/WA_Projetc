package com.wa_project.controller
import com.wa_project.controller_advice.exceptions.PreconditionFailedException
import com.wa_project.domain.dto.UserDTO
import com.wa_project.domain.response.UserResponse
import com.wa_project.mapper.DtoToResponse
import com.wa_project.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/cad"])
class UserController {

    @Autowired
    var userService: UserService? = null
    @Autowired
    var dtoToResponse: DtoToResponse? = null

    @Transactional
    @CacheEvict(value = ["/user"], allEntries = true)
    @PostMapping("/user")
    fun newUser(@RequestBody userDTO: UserDTO?): ResponseEntity<UserResponse?>? {
      return ResponseEntity.ok<UserResponse?>(dtoToResponse?.convert(userService?.save(userDTO)))
    }

    @Transactional
    @CacheEvict(value = ["/user"], allEntries = true)
    @PutMapping("/user")
    fun editUser(@RequestBody userDTO: UserDTO?): ResponseEntity<UserResponse?>? {
        if(userDTO?.identificador==null){
            throw PreconditionFailedException("É preciso informar o identificador")
        }
        return ResponseEntity.ok<UserResponse?>(dtoToResponse?.convert(userService?.update(userDTO)))
    }

    @Transactional
    @GetMapping("/user")
    fun getUser(@RequestParam(value = "id", required = true) id: Integer): ResponseEntity<UserResponse?>? {
         return ResponseEntity.ok<UserResponse?>(dtoToResponse?.convert(userService?.findByIdentificador(id)))
    }
}