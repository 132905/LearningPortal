package com.harsh.learningportalnew.mapper;

import com.harsh.learningportalnew.dto.RegisteredCourseDTO;
import com.harsh.learningportalnew.entity.RegisteredCourseEntity;

public class RegisteredMapper {

	public static RegisteredCourseEntity populateRegisteredCourse(RegisteredCourseDTO registeredCourseDTO) {
		RegisteredCourseEntity registeredCourseEntity = new RegisteredCourseEntity();
		registeredCourseEntity.setRegistrationId(registeredCourseDTO.getRegistrationId());
		registeredCourseEntity.setUser(registeredCourseDTO.getUser());
		registeredCourseEntity.setCourse(registeredCourseDTO.getCourse());
		return registeredCourseEntity;
	}

	public static RegisteredCourseDTO regCourseEntitytoDTO(RegisteredCourseEntity registeredCourseEntity) {
		RegisteredCourseDTO registeredCourseDTO = new RegisteredCourseDTO();
		registeredCourseDTO.setRegistrationId(registeredCourseEntity.getRegistrationId());
		registeredCourseDTO.setUser(registeredCourseEntity.getUser());
		registeredCourseDTO.setCourse(registeredCourseEntity.getCourse());
		return registeredCourseDTO;
	}

}
