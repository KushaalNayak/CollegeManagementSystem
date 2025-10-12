package com.college.controller;

import com.college.dto.ApiResponse;
import com.college.entity.Course;
import com.college.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        try {
            List<Course> courses = courseRepository.findByIsActiveTrue();
            return ResponseEntity.ok(new ApiResponse(true, "Courses retrieved successfully", courses));
        } catch (Exception e) {
            logger.error("Error retrieving courses", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving courses"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        try {
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                return ResponseEntity.ok(new ApiResponse(true, "Course retrieved successfully", course.get()));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Course not found"));
            }
        } catch (Exception e) {
            logger.error("Error retrieving course with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving course"));
        }
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<?> getCoursesByDepartment(@PathVariable String department) {
        try {
            List<Course> courses = courseRepository.findByDepartment(department);
            return ResponseEntity.ok(new ApiResponse(true, "Courses retrieved successfully", courses));
        } catch (Exception e) {
            logger.error("Error retrieving courses for department: {}", department, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving courses"));
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('HOD')")
    public ResponseEntity<?> createCourse(@Valid @RequestBody Course course) {
        try {
            Course savedCourse = courseRepository.save(course);
            logger.info("Course created successfully: {}", savedCourse.getCourseCode());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Course created successfully", savedCourse));
        } catch (Exception e) {
            logger.error("Error creating course", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating course"));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('HOD')")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @Valid @RequestBody Course courseDetails) {
        try {
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                Course existingCourse = course.get();
                existingCourse.setCourseName(courseDetails.getCourseName());
                existingCourse.setDescription(courseDetails.getDescription());
                existingCourse.setDurationYears(courseDetails.getDurationYears());
                existingCourse.setTotalFees(courseDetails.getTotalFees());
                existingCourse.setDepartment(courseDetails.getDepartment());
                
                Course updatedCourse = courseRepository.save(existingCourse);
                logger.info("Course updated successfully: {}", updatedCourse.getCourseCode());
                return ResponseEntity.ok(new ApiResponse(true, "Course updated successfully", updatedCourse));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Course not found"));
            }
        } catch (Exception e) {
            logger.error("Error updating course with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error updating course"));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        try {
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                course.get().setIsActive(false);
                courseRepository.save(course.get());
                logger.info("Course deactivated successfully: {}", course.get().getCourseCode());
                return ResponseEntity.ok(new ApiResponse(true, "Course deactivated successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Course not found"));
            }
        } catch (Exception e) {
            logger.error("Error deleting course with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error deleting course"));
        }
    }
}
