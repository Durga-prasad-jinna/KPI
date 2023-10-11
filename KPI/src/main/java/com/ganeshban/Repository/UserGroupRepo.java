package com.ganeshban.Repository;

import com.ganeshban.Entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepo extends JpaRepository<UserGroupEntity, Long> {
    UserGroupEntity findByUserGrpName(String groupName);
}

