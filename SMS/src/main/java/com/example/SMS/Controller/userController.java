package com.example.SMS.Controller;

import com.example.SMS.Model.userModel;
import com.example.SMS.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userServiceObj;
    

    @PostMapping("/createUser")
    public String createUser(@RequestBody userModel user){
        userServiceObj.createUser(user);
        return "Saved Successfully";
    }
    @GetMapping("/userdata")
    public List<userModel> userData(){
        return userServiceObj.findAlluser();

    }
    @GetMapping("/{id}")
    public List<userModel> userDataById(@PathVariable Long id){
        return userServiceObj.findDatabyId(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id,@RequestBody userModel user){
        Optional<userModel> userExiste =userServiceObj.findUserById(id);
        if (userExiste.isPresent()){
            userExiste.get().setUserName(user.getUserName());
            userServiceObj.updateUser(userExiste.orElse(null));
            return "Updated Successfully";
        }
        return "Error in Updation";
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        userServiceObj.deleteUser(id);
        return "Deleted Successfully";
    }


}
