package com.ganeshban.Services;

import com.ganeshban.Core.MyException;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.DTO.UserChangePasswordDTO;
import com.ganeshban.Entity.UserEntity;
import com.ganeshban.Entity.UserGroupEntity;
import com.ganeshban.Repository.UserGroupRepo;
import com.ganeshban.Repository.UserRepo;
import com.ganeshban.Services.Interfaces.UserInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements UserInterfaces {

    @Autowired
    private UserRepo repo;
    @Autowired
    private UserGroupRepo repoGrp;


    @Override
    public UserEntity getOne(long id) throws MyException {
        Optional<UserEntity> user = repo.findById(id);

        if (user.isEmpty()) {
            throw new MyException("user having id " + id + " is not found.");
        }
        return user.get();
    }

    @Override
    public List<UserEntity> getAll() {
        return repo.findAll();
    }

    public UserEntity login(LoginDTO data) throws MyException {
        UserEntity user = repo.findByUsername(data.getUsername());
        if (user == null || !user.getPassword().equals(data.getPassword())) {
            throw new MyException("username and password is incorrect.");
        }
        return user;
    }

    public UserEntity save(UserEntity data) throws MyException {
        validation(data);
        UserEntity entity = data;
        Optional<UserGroupEntity> grpEntity = repoGrp.findById(data.getUserGroup().getUserGrpID());
        if (grpEntity.isEmpty()) {
            throw new MyException("user group not found.");
        }
        entity.setUserGroup(grpEntity.get());
        return repo.save(entity);
    }

    private void usernameValidation(String userName) throws MyException {
        UserEntity user = repo.findByUsername(userName);

        if (user != null) {
            throw new MyException("username is not available.");
        }
    }


    @Override
    public String changePassword(UserChangePasswordDTO data) throws MyException {


        validation(data);
        UserEntity userModel = getOne(data.getId());

        if (!userModel.getPassword().equals(data.getNewpassword())) {
            throw new MyException("Old password is wrong.");
        }
        userModel.setPassword(data.getNewpassword());
        return "password change success.";
    }


    @Override
    public String delete(long id) {
        repo.deleteById(id);

        return "Deleted !";
    }


    private void validation(UserEntity data) throws MyException {
        lengthValidation(data.getPassword());
        usernameValidation(data.getUsername());

    }

    private void validation(UserChangePasswordDTO data) throws MyException {
        lengthValidation(data.getNewpassword());
        passwordMatchValidation(data.getNewpassword(), data.getVerifypassword());
    }

    private void lengthValidation(String str) throws MyException {
        if (str.length() < 8) {
            throw new MyException("password must be at least 8 character long.");
        }
    }

    private void passwordMatchValidation(String psw1, String psw2) throws MyException {
        if (psw1.equals(psw2)) {
            throw new MyException("new password and verify password didn't match.");
        }

    }
}
