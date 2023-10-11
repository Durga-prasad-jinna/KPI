package com.ganeshban.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblusergroup")
public class UserGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long userGrpID;
    @Column(name = "grpname", length = 100, unique = true)
    String userGrpName;

}
