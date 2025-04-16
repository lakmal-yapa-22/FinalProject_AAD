package com.example.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    private String examName;

    @Enumerated(EnumType.STRING)
    @Column(name = "questionType", nullable = false)
    private QuestionType type;

    private String description;
    private int duration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String createdBy;





    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Essay_Question> essayQuestions;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Mcq_Question> mcq_questions;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<McqResult> results;



    // All arguments constructor
    public Exam(int examId, String examName, QuestionType type, String description, int duration,
                LocalDateTime startTime, LocalDateTime endTime, String createdBy,
                List<Essay_Question> essayQuestions, List<Mcq_Question> mcq_questions, List<McqResult> results) {
        this.examId = examId;
        this.examName = examName;
        this.type = type;
        this.description = description;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdBy = createdBy;
        this.essayQuestions = essayQuestions;
        this.mcq_questions = mcq_questions;
        this.results = results;
    }
    public Exam(int examId,String examName,QuestionType type,String description,int duration,LocalDateTime startTime,LocalDateTime endTime,String createdBy) {
        this.examId = examId;
        this.examName = examName;
        this.type = type;
        this.description = description;

        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdBy = createdBy;

    }

    public Exam() {

    }

    // Getters and Setters
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Essay_Question> getEssayQuestions() {
        return essayQuestions;
    }

    public void setEssayQuestions(List<Essay_Question> essayQuestions) {
        this.essayQuestions = essayQuestions;
    }

    public List<Mcq_Question> getMcq_questions() {
        return mcq_questions;
    }

    public void setMcq_questions(List<Mcq_Question> mcq_questions) {
        this.mcq_questions = mcq_questions;
    }

    public List<McqResult> getResults() {
        return results;
    }

    public void setResults(List<McqResult> results) {
        this.results = results;
    }
}