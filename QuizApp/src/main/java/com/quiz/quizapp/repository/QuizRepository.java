package com.quiz.quizapp.repository;

import com.quiz.quizapp.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuizRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Check if student exists
    public boolean isValidStudent(String studentId) {
        String sql = "SELECT COUNT(*) FROM student WHERE student_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, studentId);
        return count != null && count > 0;
    }

    // Save score
    public void saveScore(Score score) {
        String sql = "INSERT INTO score (student_id, score) VALUES (?, ?)";
        jdbcTemplate.update(sql, score.getStudentId(), score.getScore());
    }
}
