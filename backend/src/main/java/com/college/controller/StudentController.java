package com.college.controller;

import com.college.dto.ApiResponse;
import com.college.entity.Student;
import com.college.repository.StudentRepository;
import com.college.repository.CourseRepository;
import com.college.repository.UserRepository;
import com.college.security.UserPrincipal;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> students = studentRepository.findByIsActiveTrue();
            return ResponseEntity.ok(new ApiResponse(true, "Students retrieved successfully", students));
        } catch (Exception e) {
            logger.error("Error retrieving students", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving students"));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getStudentById(@PathVariable Long id, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own data
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(id);
                if (student.isPresent() && student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.ok(new ApiResponse(true, "Student retrieved successfully", student.get()));
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                return ResponseEntity.ok(new ApiResponse(true, "Student retrieved successfully", student.get()));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Student not found"));
            }
        } catch (Exception e) {
            logger.error("Error retrieving student with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving student"));
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
        try {
            Student savedStudent = studentRepository.save(student);
            logger.info("Student created successfully: {}", savedStudent.getStudentId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Student created successfully", savedStudent));
        } catch (Exception e) {
            logger.error("Error creating student", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating student"));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                Student existingStudent = student.get();
                existingStudent.setFirstName(studentDetails.getFirstName());
                existingStudent.setLastName(studentDetails.getLastName());
                existingStudent.setDateOfBirth(studentDetails.getDateOfBirth());
                existingStudent.setGender(studentDetails.getGender());
                existingStudent.setPhone(studentDetails.getPhone());
                existingStudent.setAddress(studentDetails.getAddress());
                
                Student updatedStudent = studentRepository.save(existingStudent);
                logger.info("Student updated successfully: {}", updatedStudent.getStudentId());
                return ResponseEntity.ok(new ApiResponse(true, "Student updated successfully", updatedStudent));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Student not found"));
            }
        } catch (Exception e) {
            logger.error("Error updating student with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error updating student"));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                student.get().setIsActive(false);
                studentRepository.save(student.get());
                logger.info("Student deactivated successfully: {}", student.get().getStudentId());
                return ResponseEntity.ok(new ApiResponse(true, "Student deactivated successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Student not found"));
            }
        } catch (Exception e) {
            logger.error("Error deleting student with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error deleting student"));
        }
    }
}
