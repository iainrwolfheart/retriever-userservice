package com.goldenretriever.userservice.repositories;

import com.goldenretriever.userservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T extends User, ObjectId> extends MongoRepository<T, ObjectId> {

    @Query(value="{'_id' : ObjectId('?0')}")
    T findBy_userId(String _userId);

    T findByEmail(String email);

    @Query(value = "{$or: [{username: ?0}, {email: ?1}]}", exists = true)
    boolean userExists(String username, String email);

    @Query(value="{'_id': ObjectId('?0')}", delete = true)
    void deleteById(String _userId);
}
