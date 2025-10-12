package com.college.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "marks")
@EntityListeners(AuditingEntityListener.class)
public class Marks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @DecimalMin(value = "0.0", message = "Marks cannot be negative")
    @DecimalMax(value = "100.0", message = "Marks cannot exceed 100")
    @Column(precision = 5, scale = 2)
    private BigDecimal marksObtained;
    
    @NotNull
    @Column(precision = 5, scale = 2)
    private BigDecimal totalMarks;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ExamType examType;
    
    @Size(max = 100)
    private String subject;
    
    @Size(max = 50)
    private String semester;
    
    @Size(max = 10)
    private String academicYear;
    
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    
    public Marks() {}
    
    public Marks(BigDecimal marksObtained, BigDecimal totalMarks, ExamType examType, String subject, String semester, String academicYear, Student student) {
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.examType = examType;
        this.subject = subject;
        this.semester = semester;
        this.academicYear = academicYear;
        this.student = student;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getMarksObtained() {
        return marksObtained;
    }
    
    public void setMarksObtained(BigDecimal marksObtained) {
        this.marksObtained = marksObtained;
    }
    
    public BigDecimal getTotalMarks() {
        return totalMarks;
    }
    
    public void setTotalMarks(BigDecimal totalMarks) {
        this.totalMarks = totalMarks;
    }
    
    public ExamType getExamType() {
        return examType;
    }
    
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String getAcademicYear() {
        return academicYear;
    }
    
    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public enum ExamType {
        INTERNAL, EXTERNAL, ASSIGNMENT, PROJECT, QUIZ
    }
}
