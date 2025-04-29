package org.example.orm_kerndl;


import org.springframework.data.repository.CrudRepository;

import org.example.orm_kerndl.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}