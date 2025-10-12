package com.college.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fees")
@EntityListeners(AuditingEntityListener.class)
public class Fees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @DecimalMin(value = "0.0", message = "Amount cannot be negative")
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    
    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal totalFees;
    
    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal balanceDue;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private FeeType feeType;
    
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    
    @Size(max = 100)
    private String description;
    
    @Size(max = 50)
    private String academicYear;
    
    @Size(max = 20)
    private String semester;
    
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    
    public Fees() {}
    
    public Fees(BigDecimal amount, BigDecimal totalFees, BigDecimal balanceDue, FeeType feeType, LocalDate paymentDate, String description, String academicYear, String semester, Student student) {
        this.amount = amount;
        this.totalFees = totalFees;
        this.balanceDue = balanceDue;
        this.feeType = feeType;
        this.paymentDate = paymentDate;
        this.description = description;
        this.academicYear = academicYear;
        this.semester = semester;
        this.student = student;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public BigDecimal getTotalFees() {
        return totalFees;
    }
    
    public void setTotalFees(BigDecimal totalFees) {
        this.totalFees = totalFees;
    }
    
    public BigDecimal getBalanceDue() {
        return balanceDue;
    }
    
    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }
    
    public FeeType getFeeType() {
        return feeType;
    }
    
    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }
    
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAcademicYear() {
        return academicYear;
    }
    
    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
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
    
    public enum FeeType {
        TUITION, LIBRARY, LABORATORY, EXAMINATION, TRANSPORT, HOSTEL, OTHER
    }
}
