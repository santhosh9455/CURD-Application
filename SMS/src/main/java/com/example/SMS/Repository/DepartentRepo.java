package com.example.SMS.Repository;

import com.example.SMS.Model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartentRepo extends JpaRepository<DepartmentEntity,Long> {
}
