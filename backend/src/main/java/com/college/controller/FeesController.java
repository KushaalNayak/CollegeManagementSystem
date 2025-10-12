package com.college.controller;

import com.college.dto.ApiResponse;
import com.college.entity.Fees;
import com.college.repository.FeesRepository;
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
@RequestMapping("/api/v1/fees")
@CrossOrigin(origins = "*")
public class FeesController {

    @Autowired
    private FeesRepository feesRepository;

    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(FeesController.class);

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getFeesByStudentId(@PathVariable Long studentId, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own fees
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Fees> fees = feesRepository.findByStudentId(studentId);
            return ResponseEntity.ok(new ApiResponse(true, "Fees retrieved successfully", fees));
        } catch (Exception e) {
            logger.error("Error retrieving fees for student: {}", studentId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving fees"));
        }
    }

    @GetMapping("/student/{studentId}/academic-year/{academicYear}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getFeesByStudentAndAcademicYear(@PathVariable Long studentId, @PathVariable String academicYear, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own fees
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Fees> fees = feesRepository.findByStudentIdAndAcademicYear(studentId, academicYear);
            return ResponseEntity.ok(new ApiResponse(true, "Fees retrieved successfully", fees));
        } catch (Exception e) {
            logger.error("Error retrieving fees for student: {} and academic year: {}", studentId, academicYear, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving fees"));
        }
    }

    @GetMapping("/student/{studentId}/semester/{semester}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD') or hasRole('STUDENT')")
    public ResponseEntity<?> getFeesByStudentAndSemester(@PathVariable Long studentId, @PathVariable String semester, Authentication authentication) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            
            // Students can only view their own fees
            if (userPrincipal.getAuthorities().iterator().next().getAuthority().equals("ROLE_STUDENT")) {
                Optional<Student> student = studentRepository.findById(studentId);
                if (student.isPresent() && !student.get().getUser().getId().equals(userPrincipal.getId())) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body(new ApiResponse(false, "Access denied"));
                }
            }
            
            List<Fees> fees = feesRepository.findByStudentIdAndSemester(studentId, semester);
            return ResponseEntity.ok(new ApiResponse(true, "Fees retrieved successfully", fees));
        } catch (Exception e) {
            logger.error("Error retrieving fees for student: {} and semester: {}", studentId, semester, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving fees"));
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> createFees(@Valid @RequestBody Fees fees) {
        try {
            Fees savedFees = feesRepository.save(fees);
            logger.info("Fees created successfully for student: {}", fees.getStudent().getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Fees created successfully", savedFees));
        } catch (Exception e) {
            logger.error("Error creating fees", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating fees"));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> updateFees(@PathVariable Long id, @Valid @RequestBody Fees feesDetails) {
        try {
            Optional<Fees> fees = feesRepository.findById(id);
            if (fees.isPresent()) {
                Fees existingFees = fees.get();
                existingFees.setAmount(feesDetails.getAmount());
                existingFees.setTotalFees(feesDetails.getTotalFees());
                existingFees.setBalanceDue(feesDetails.getBalanceDue());
                existingFees.setFeeType(feesDetails.getFeeType());
                existingFees.setPaymentDate(feesDetails.getPaymentDate());
                existingFees.setDescription(feesDetails.getDescription());
                existingFees.setAcademicYear(feesDetails.getAcademicYear());
                existingFees.setSemester(feesDetails.getSemester());
                
                Fees updatedFees = feesRepository.save(existingFees);
                logger.info("Fees updated successfully: {}", updatedFees.getId());
                return ResponseEntity.ok(new ApiResponse(true, "Fees updated successfully", updatedFees));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Fees not found"));
            }
        } catch (Exception e) {
            logger.error("Error updating fees with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error updating fees"));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('FACULTY') or hasRole('HOD')")
    public ResponseEntity<?> deleteFees(@PathVariable Long id) {
        try {
            Optional<Fees> fees = feesRepository.findById(id);
            if (fees.isPresent()) {
                feesRepository.delete(fees.get());
                logger.info("Fees deleted successfully: {}", id);
                return ResponseEntity.ok(new ApiResponse(true, "Fees deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Fees not found"));
            }
        } catch (Exception e) {
            logger.error("Error deleting fees with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error deleting fees"));
        }
    }
}
