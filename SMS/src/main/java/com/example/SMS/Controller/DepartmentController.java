package com.example.SMS.Controller;


import com.example.SMS.Model.DepartmentEntity;
import com.example.SMS.Model.userModel;
import com.example.SMS.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService  departmentService;


    @GetMapping("/details")
    public List<DepartmentEntity> getDetails(){
       return departmentService.getAll();
    }

    @PostMapping("/addcourse")
    public String addCourse(@RequestBody DepartmentEntity add , userModel od) {
        departmentService.addCourse(add);

        return "Updated";
    }
}
