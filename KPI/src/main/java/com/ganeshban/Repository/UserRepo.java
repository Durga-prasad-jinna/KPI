package com.ganeshban.Repository;

import com.ganeshban.Core.MyException;
import com.ganeshban.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    //    List<UserEntity> getAll();
//    UserModel getOne(long id) throws MyException;
//    List<UserEntity> allUsers = repo.findAll();
    UserEntity findByUsername(String username) throws MyException;

}
