package com.uwo.three_d.backendapi

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val repo: UserRepository) {

    // Retrieve records from db
    fun getAll(): List<User> = repo.findAll();

    // Retrieve record by id; throws error if no record with given id exists
    fun getById(id: Long): User = repo.findByIdOrNull(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND) as Throwable;

    // Add record to db
    fun create(user: User): User = repo.save(user);

    // Delete record from db; throws error if no record with given id exists
    fun remove(id: Long) {
        if (repo.existsById(id)) repo.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // Update info of record; throws error if no record with given id exists
    fun update(id: Long, user: User): User {
        return if (repo.existsById(id)) {
            user.id = id;
            repo.save(user);
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}