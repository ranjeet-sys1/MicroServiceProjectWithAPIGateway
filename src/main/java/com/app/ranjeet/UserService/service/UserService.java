package com.app.ranjeet.UserService.service;

import com.app.ranjeet.UserService.VO.Department;
import com.app.ranjeet.UserService.VO.ResponseTemplateVO;
import com.app.ranjeet.UserService.entity.User;
import com.app.ranjeet.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User SaveUser(User user){
        return userRepository.save(user);
    }
    public ResponseTemplateVO getUserFromDepartment(Long userId){
        Optional<User> OptionUser = userRepository.findById(userId);
        User user=null;
        if(OptionUser.isPresent()){
            user = OptionUser.get();
        }
        Department department = restTemplate.getForObject("http://" +
                "localhost:9001/departments/getDepartment/"+user.getDepartmentId()+"", Department.class);
        ResponseTemplateVO vo =new ResponseTemplateVO();
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
