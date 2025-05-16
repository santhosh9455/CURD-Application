package com.example.SMS.Service;

import com.example.SMS.Model.DepartmentEntity;
import com.example.SMS.Repository.DepartentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartentRepo departentRepo;

    public List<DepartmentEntity> getAll() {
        return departentRepo.findAll();
    }

    public void addCourse(DepartmentEntity add) {
        departentRepo.save(add);
    }
}
