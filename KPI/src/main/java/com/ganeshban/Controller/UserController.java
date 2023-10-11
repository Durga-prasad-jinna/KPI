package com.ganeshban.Controller;

import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.DTO.UserChangePasswordDTO;
import com.ganeshban.Entity.UserEntity;
import com.ganeshban.Core.MyException;
//import com.ganeshban.Model.UserModel;
import com.ganeshban.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices services;

    @GetMapping("/{id}")
    public UserEntity getOne(@PathVariable long id) throws MyException {
        return services.getOne(id);
    }

//    @GetMapping("/all")
//    public List<UserEntity> getAll() {
//        return services.getAll();
//    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody UserEntity data) throws MyException {
        return services.save(data);
    }

    @PostMapping("login")
    public UserEntity login(@RequestBody LoginDTO data) throws MyException {
        return services.login((data));
    }


    @PutMapping("/update")
    public UserEntity update(@RequestBody UserEntity data) throws MyException {
        return services.save(data);
    }

    @PutMapping("changepassword")
    public String changePassword(@RequestBody UserChangePasswordDTO data) throws MyException {
        return services.changePassword(data);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return services.delete(id);
    }

}
