package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "msqResults")
public class    McqResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int resultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // 🔥 Prevents infinite recursion
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    @JsonIgnore // 🔥 Prevents infinite recursion
    private Exam exam;

    @Column(name = "exam_name")
    private String examName;

    @Column(name = "total_mcq_marks", nullable = false)
    private int totalMarks;

    @Column(name = "obtained_mcq_marks")
    private int obtainedMarks;

    @Column(name = "grade")
    private String grade;

    @Column(name = "feedback")
    private String feedback;

    // All arguments constructor
    public McqResult(int resultId, User user, Exam exam,String examName, int totalMarks, int obtainedMarks, String grade, String feedback) {
        this.resultId = resultId;
        this.user = user;

        this.exam = exam;
        this.examName=examName;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
        this.feedback = feedback;
    }

    public McqResult() {

    }

    // Getters and Setters
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
