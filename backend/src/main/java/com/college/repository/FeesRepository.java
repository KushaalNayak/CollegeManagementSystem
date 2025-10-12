package com.college.repository;

import com.college.entity.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
    List<Fees> findByStudentId(Long studentId);
    List<Fees> findByStudentIdAndAcademicYear(Long studentId, String academicYear);
    List<Fees> findByStudentIdAndSemester(Long studentId, String semester);
}
