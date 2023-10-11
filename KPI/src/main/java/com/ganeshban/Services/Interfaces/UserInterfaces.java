package com.ganeshban.Services.Interfaces;

import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.DTO.UserChangePasswordDTO;
import com.ganeshban.Entity.UserEntity;
import com.ganeshban.Core.MyException;
//import com.ganeshban.Model.UserModel;

import java.util.List;

public interface UserInterfaces {
    UserEntity getOne(long id) throws MyException;

    List<UserEntity> getAll();

    UserEntity save(UserEntity data) throws MyException;
    UserEntity login(LoginDTO data) throws MyException;
    String changePassword(UserChangePasswordDTO data) throws MyException;

    String delete(long id);



}
