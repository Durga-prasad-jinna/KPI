package com.ganeshban.DTO;

import lombok.Getter;

@Getter
public class UserChangePasswordDTO {
    long id;
    String oldpassword;
    String newpassword;
    String verifypassword;
}

