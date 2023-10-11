package com.ganeshban.Services.Interfaces;

import com.ganeshban.Entity.UserGroupEntity;
import com.ganeshban.Core.MyException;

import java.util.List;

public interface UserGroupInterfaces {
    UserGroupEntity getOne(long id) throws MyException;
    List<UserGroupEntity> getAll();
    UserGroupEntity save(UserGroupEntity data) throws MyException;
    String delete(long id);

}

