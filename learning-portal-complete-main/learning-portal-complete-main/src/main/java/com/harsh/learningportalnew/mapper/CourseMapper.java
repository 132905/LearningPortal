package com.harsh.learningportalnew.mapper;

import com.harsh.learningportalnew.dto.CourseDTO;
import com.harsh.learningportalnew.entity.CourseEntity;

public class CourseMapper {

	public static CourseEntity populateCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseId(courseDTO.getCourseId());
		courseEntity.setTitle(courseDTO.getTitle());
		courseEntity.setDescription(courseDTO.getDescription());
		courseEntity.setPrice(courseDTO.getPrice());
		courseEntity.setCategory(courseDTO.getCategory());
		return courseEntity;
	}

	public static CourseDTO courseEntityToDTO(CourseEntity courseEntity) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setCourseId(courseEntity.getCourseId());
		courseDTO.setTitle(courseEntity.getTitle());
		courseDTO.setDescription(courseEntity.getDescription());
		courseDTO.setPrice(courseEntity.getPrice());
		courseDTO.setCategory(courseEntity.getCategory());
		return courseDTO;
	}

}
