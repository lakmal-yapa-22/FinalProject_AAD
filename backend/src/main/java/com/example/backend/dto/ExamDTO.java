package com.example.backend.dto;

import com.example.backend.entity.QuestionType;

import java.time.LocalDateTime;

public class ExamDTO {

    private int examId;

    private String examName;

    private QuestionType type;

    private String description;
    private int duration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String createdBy;
    public ExamDTO() {}

    public ExamDTO(int examId, String examName, QuestionType type, String description, int duration, LocalDateTime startTime, LocalDateTime endTime, String createdBy) {
        this.examId = examId;
        this.examName = examName;
        this.type = type;
        this.description = description;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdBy = createdBy;

    }
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





}
