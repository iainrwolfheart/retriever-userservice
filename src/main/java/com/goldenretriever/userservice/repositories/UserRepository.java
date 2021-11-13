package com.goldenretriever.userservice.repositories;

import com.goldenretriever.userservice.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query(value="{'_id' : ?0 }")
    User findBy_userId(String _userId);

    @Query(value="{'_id': ObjectId('?0')}")
    User deleteBy_UserId(String _userId);
    User findByEmail(String email);
}
