package com.harsh.learningportalnew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harsh.learningportalnew.entity.CourseEntity;
import com.harsh.learningportalnew.entity.CourseEntity.Category;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	@Query("SELECT c FROM CourseEntity c WHERE c.category = :category")
	List<CourseEntity> findByCategory(Category category);
}
