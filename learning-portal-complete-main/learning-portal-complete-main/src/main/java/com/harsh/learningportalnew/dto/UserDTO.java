package com.harsh.learningportalnew.dto;

import com.harsh.learningportalnew.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private String username;
	private String password;
	private UserEntity.Role role;

}
