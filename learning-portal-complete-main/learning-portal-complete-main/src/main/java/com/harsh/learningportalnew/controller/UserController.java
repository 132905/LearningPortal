package com.harsh.learningportalnew.controller;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.learningportalnew.dto.FavouriteCourseDTO;
import com.harsh.learningportalnew.dto.RegisteredCourseDTO;
import com.harsh.learningportalnew.dto.UserDTO;
import com.harsh.learningportalnew.entity.CourseEntity;
import com.harsh.learningportalnew.entity.FavouriteCourseEntity;
import com.harsh.learningportalnew.entity.UserEntity;
import com.harsh.learningportalnew.entity.CourseEntity.Category;
import com.harsh.learningportalnew.entity.UserEntity.Role;
import com.harsh.learningportalnew.mapper.UserMapper;
import com.harsh.learningportalnew.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//GET ALL USERS
	@GetMapping("/getall")
	public List<UserEntity> getAllUser() {

		log.info("showing all users");
		return userService.getAllUsers();
	}

	//DELETE USERS
	@DeleteMapping("/delete/{id}/{userId}")
	public void deleteUser(@PathVariable Long id, @PathVariable Long userId) {
		//finding if the users exist
		Optional<UserEntity> isAdmin = userService.getUser(userId);

		//checking if the user exists and is admin
		if (isAdmin.isPresent() && (isAdmin.get().getRole() == Role.ADMIN)) {
			userService.deleteUser(id);
			log.info("user deleted");
		}
	}

	//GET ALL COURSES BY CATEGORY
	@GetMapping("/categories/{category}")
	public List<CourseEntity> getByCategory(@PathVariable Category category) {
		//listing courses by category
		log.info("Listing all the courses by category:{} ", category);
		return userService.getCoursesByCategory(category);
	}

	//LOGIN USER
	@GetMapping("/login/{id}/{userId}")
	public Optional<UserEntity> loginUser(@PathVariable Long id, @PathVariable Long userId) {
		//finding the user
		Optional<UserEntity> isUser = userService.getUser(userId);

		//if user exists
		if (isUser.isPresent()) {
			log.info("user loggedIn");
			return userService.loginUser(id);
		}
		return Optional.empty();
	}

	//REGISTER USER
	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserEntity user) {
		//hashing the password
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);

		log.info("user Registered:{}", user);
		UserDTO resUserDTO = UserMapper.userEntitytoDTO(user);

		//registering the user
		return userService.registerUser(resUserDTO);

	}

	//PURCHASE COURSE
	@PostMapping("/purchase/{userId}/{courseId}")
	public RegisteredCourseDTO purchaseCourse(@PathVariable Long userId, @PathVariable Long courseId) {

		log.info("course purchased:{}", courseId);
		return userService.purchaseCourse(courseId, userId);

	}

	//ADDING A FAVOURITE COURSE
	@PostMapping("/favourite/{registrationId}")
	public FavouriteCourseDTO addFavouriteCourse(@PathVariable Long registrationId) {

		log.info("course added to favourites");
		return userService.favouriteCourse(registrationId);
	}

	//SEE FAVOURITE COURSE
	@GetMapping("/favourite/seeAll/{userId}")
	public List<FavouriteCourseEntity> seeAllFavourite(@PathVariable Long userId) {

		log.info("listing all the favourite courses");
		return userService.seeFavouriteCourses(userId);
	}

}
