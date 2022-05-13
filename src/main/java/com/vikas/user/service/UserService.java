package com.vikas.user.service;

import com.vikas.user.controller.UserController;
import com.vikas.user.entity.User;
import com.vikas.user.repository.UserRepository;
import com.vikas.user.vo.Department;
import com.vikas.user.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of"+ UserService.class);
       return repository.save(user);
    }

    public ResponseVO findUserWithDepartment(Long userId) {
        log.info("Inside findUserWithDepartment method of"+ UserService.class);
        ResponseVO responseVO = new ResponseVO();
        User user = repository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseVO.setUser(user);
        responseVO.setDepartment(department);
        return responseVO;
    }
}
