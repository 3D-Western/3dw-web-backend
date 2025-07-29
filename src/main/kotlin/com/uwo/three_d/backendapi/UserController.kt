package com.uwo.three_d.backendapi

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/users")
@RestController
class UserController(val service: UserService) {

    @GetMapping
    fun getAllUsers() = service.getAll();

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) = service.getById(id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody user: User): User = service.create(user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) = service.remove(id);

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long, @RequestBody user: User
    ) = service.update(id, user);
}