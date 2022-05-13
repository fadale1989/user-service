package com.vikas.user.vo;

import com.vikas.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseVO {
    User user;
    Department department;
}
