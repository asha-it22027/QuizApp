package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Score;
import com.quiz.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    private QuizRepository quizRepo;

    // Endpoint to validate student and play quiz
    @PostMapping("/start")
    public String startQuiz(@RequestParam String studentId,
                            @RequestParam int ans1,
                            @RequestParam int ans2) {

        if (!quizRepo.isValidStudent(studentId)) {
            return "⛔ আপনার Student ID সঠিক নয়। প্রবেশ অনুমোদিত না।";
        }

        // Correct answers
        int score = 0;
        if (ans1 == 2) score++;  // correct option for Q1
        if (ans2 == 3) score++;  // correct option for Q2

        quizRepo.saveScore(new Score(studentId, score));

        return "✅ ধন্যবাদ! আপনি পেয়েছেন: " + score + " / 2";
    }
}
