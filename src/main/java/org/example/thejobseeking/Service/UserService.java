package org.example.thejobseeking.Service;

import lombok.RequiredArgsConstructor;
import org.example.thejobseeking.Model.User;
import org.example.thejobseeking.Repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }


    public void addUser(User user){
    userRepository.save(user);
    }


    public Boolean updateUser(Integer id,User user){
        User c=userRepository.getById(id);

        if(c==null){
            return false;
        }

        c.setName(user.getName());
        c.setEmail(user.getEmail());
        c.setAge(user.getAge());
        c.setPassword(user.getPassword());
        c.setRole(user.getRole());
        userRepository.save(c);

        return true;
    }


    public Boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false ;
    }


    }


