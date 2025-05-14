package com.example.SMS.Repository;

import com.example.SMS.Model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepo extends JpaRepository<userModel,Long> {
    List<userModel> findAllById(Long id);
}
