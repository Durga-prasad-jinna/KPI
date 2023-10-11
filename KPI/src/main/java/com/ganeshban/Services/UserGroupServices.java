package com.ganeshban.Services;

import com.ganeshban.Entity.UserGroupEntity;
import com.ganeshban.Core.MyException;
import com.ganeshban.Repository.UserGroupRepo;
import com.ganeshban.Services.Interfaces.UserGroupInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupServices implements UserGroupInterfaces {

    @Autowired
    private UserGroupRepo repo;

    @Override
    public UserGroupEntity getOne(long id) throws MyException {
        Optional<UserGroupEntity> userGroup = repo.findById(id);
        if (userGroup.isEmpty()) {
            throw new MyException("user group having id " + id + " not found.");
        }
        return userGroup.get();
    }

    @Override
    public List<UserGroupEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public UserGroupEntity save(UserGroupEntity data) throws MyException {
        UserGroupEntity entity = repo.findByUserGrpName(data.getUserGrpName());
        if (entity != null) {
            throw new MyException("name not available");
        }
        return repo.save(data);
    }


    @Override
    public String delete(long id) {
        repo.deleteById(id);
        return "Deleted !";
    }
}

