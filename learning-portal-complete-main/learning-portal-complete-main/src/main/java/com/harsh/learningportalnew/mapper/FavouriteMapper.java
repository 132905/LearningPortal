package com.harsh.learningportalnew.mapper;

import com.harsh.learningportalnew.dto.FavouriteCourseDTO;
import com.harsh.learningportalnew.entity.FavouriteCourseEntity;

public class FavouriteMapper {

	public static FavouriteCourseEntity populateFavouriteCourse(FavouriteCourseDTO favouriteCourseDTO) {
		FavouriteCourseEntity favouriteCourseEntity = new FavouriteCourseEntity();
		favouriteCourseEntity.setFavouriteId(favouriteCourseDTO.getFavouriteId());
		favouriteCourseEntity.setRegisteredCourse(favouriteCourseDTO.getRegisteredCourse());
		return favouriteCourseEntity;
	}

	public static FavouriteCourseDTO favCourseEntitytoDTO(FavouriteCourseEntity favouriteCourseEntity) {
		FavouriteCourseDTO favouriteCourseDTO = new FavouriteCourseDTO();
		favouriteCourseDTO.setFavouriteId(favouriteCourseEntity.getFavouriteId());
		favouriteCourseDTO.setRegisteredCourse(favouriteCourseEntity.getRegisteredCourse());
		return favouriteCourseDTO;
	}

}