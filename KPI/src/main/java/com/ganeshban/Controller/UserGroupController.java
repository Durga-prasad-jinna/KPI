package com.ganeshban.Controller;

import com.ganeshban.Entity.UserGroupEntity;
import com.ganeshban.Core.MyException;
import com.ganeshban.Services.UserGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usergrp")
public class UserGroupController {
    @Autowired
    private UserGroupServices services;

    @GetMapping("/{id}")
    public UserGroupEntity getOne(@PathVariable long id) throws MyException {
        return services.getOne(id);
    }

    @GetMapping("/all")
    public List<UserGroupEntity> getAll() {
        return services.getAll();

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserGroupEntity create(@RequestBody UserGroupEntity data) throws MyException {
        return services.save(data);
    }

    @PutMapping("/update")
    public UserGroupEntity update(@RequestBody UserGroupEntity data) throws MyException {
        return services.save(data);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return services.delete(id);
    }

}

