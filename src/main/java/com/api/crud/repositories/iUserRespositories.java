package com.api.crud.repositories;

import com.api.crud.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface iUserRespositories extends JpaRepository<UserModels,Long> {

}
