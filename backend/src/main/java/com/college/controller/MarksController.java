package com.college.controller;

import com.college.dto.ApiResponse;
import com.college.entity.Marks;
import com.college.repository.MarksRepository;
import com.college.repository.StudentRepository;
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
@RequestMapping("/api/v1/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(MarksController.class);

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getMarksByStudentId(@PathVariable Long studentId, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own marks
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Marks> marks = marksRepository.findByStudentId(studentId);
            return ResponseEntity.ok(new ApiResponse(true, "Marks retrieved successfully", marks));
        } catch (Exception e) {
            logger.error("Error retrieving marks for student: {}", studentId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving marks"));
        }
    }

    @GetMapping("/student/{studentId}/subject/{subject}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getMarksByStudentAndSubject(@PathVariable Long studentId, @PathVariable String subject, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own marks
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Marks> marks = marksRepository.findByStudentIdAndSubject(studentId, subject);
            return ResponseEntity.ok(new ApiResponse(true, "Marks retrieved successfully", marks));
        } catch (Exception e) {
            logger.error("Error retrieving marks for student: {} and subject: {}", studentId, subject, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving marks"));
        }
    }

    @GetMapping("/student/{studentId}/semester/{semester}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getMarksByStudentAndSemester(@PathVariable Long studentId, @PathVariable String semester, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own marks
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Marks> marks = marksRepository.findByStudentIdAndSemester(studentId, semester);
            return ResponseEntity.ok(new ApiResponse(true, "Marks retrieved successfully", marks));
        } catch (Exception e) {
            logger.error("Error retrieving marks for student: {} and semester: {}", studentId, semester, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving marks"));
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> createMarks(@Valid @RequestBody Marks marks) {
        try {
            Marks savedMarks = marksRepository.save(marks);
            logger.info("Marks created successfully for student: {}", marks.getStudent().getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Marks created successfully", savedMarks));
        } catch (Exception e) {
            logger.error("Error creating marks", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating marks"));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> updateMarks(@PathVariable Long id, @Valid @RequestBody Marks marksDetails) {
        try {
            Optional<Marks> marks = marksRepository.findById(id);
            if (marks.isPresent()) {
                Marks existingMarks = marks.get();
                existingMarks.setMarksObtained(marksDetails.getMarksObtained());
                existingMarks.setTotalMarks(marksDetails.getTotalMarks());
                existingMarks.setExamType(marksDetails.getExamType());
                existingMarks.setSubject(marksDetails.getSubject());
                existingMarks.setSemester(marksDetails.getSemester());
                existingMarks.setAcademicYear(marksDetails.getAcademicYear());
                
                Marks updatedMarks = marksRepository.save(existingMarks);
                logger.info("Marks updated successfully: {}", updatedMarks.getId());
                return ResponseEntity.ok(new ApiResponse(true, "Marks updated successfully", updatedMarks));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Marks not found"));
            }
        } catch (Exception e) {
            logger.error("Error updating marks with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error updating marks"));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> deleteMarks(@PathVariable Long id) {
        try {
            Optional<Marks> marks = marksRepository.findById(id);
            if (marks.isPresent()) {
                marksRepository.delete(marks.get());
                logger.info("Marks deleted successfully: {}", id);
                return ResponseEntity.ok(new ApiResponse(true, "Marks deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Marks not found"));
            }
        } catch (Exception e) {
            logger.error("Error deleting marks with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error deleting marks"));
        }
    }
}
