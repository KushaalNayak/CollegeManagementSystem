package com.college.repository;

import com.college.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudentId(Long studentId);
    List<Marks> findByStudentIdAndSubject(Long studentId, String subject);
    List<Marks> findByStudentIdAndSemester(Long studentId, String semester);
    List<Marks> findByStudentIdAndAcademicYear(Long studentId, String academicYear);
}
