package com.quiz.quizapp.model;

import java.util.Map;

public class StudentRequest {
    private String studentId;
    private Map<Integer, String> answers;

    public String getStudentId() {
        return studentId;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }
}
