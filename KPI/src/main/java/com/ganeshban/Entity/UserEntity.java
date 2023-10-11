package com.ganeshban.Entity;

//import com.ganeshban.Model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbluser")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", precision = 1)
    private long id;
    @Column(name = "username", length = 50, precision = 2, unique = true)
    private String username;
    @Column(name = "userpassword", length = 50)
    private String password;
    @Column(name = "fullname", length = 100)
    private String fullName;

    private byte status;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "GroupID")
    private UserGroupEntity userGroup;

//    public UserModel toModel() {
//        UserModel model = new UserModel(id, username, password, fullName, status, userGroup.getUserGrpID());
//        return model;
//    }

}


