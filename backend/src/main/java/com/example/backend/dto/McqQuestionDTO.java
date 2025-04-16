package com.example.backend.dto;

import com.example.backend.entity.Exam;

public class McqQuestionDTO {

    private int id;
    private int mcqNumber;
    private String questionText;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private String correctAnswer;
    private String studentAnswer;
    private int marks;
    private int examId; // Assuming you only need the exam ID in the DTO

    // No-args constructor
    public McqQuestionDTO() {
    }

    // All-args constructor
    public McqQuestionDTO(int id, int mcqNumber, String questionText, String answer_1, String answer_2, String answer_3, String answer_4, String correctAnswer, String studentAnswer, int marks, int examId) {
        this.id = id;
        this.mcqNumber = mcqNumber;
        this.questionText = questionText;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.marks = marks;
        this.examId = examId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMcqNumber() {
        return mcqNumber;
    }

    public void setMcqNumber(int mcqNumber) {
        this.mcqNumber = mcqNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getAnswer_4() {
        return answer_4;
    }

    public void setAnswer_4(String answer_4) {
        this.answer_4 = answer_4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public String toString() {
        return "McqQuestionDTO{" +
                "id=" + id +
                ", mcqNumber=" + mcqNumber +
                ", questionText='" + questionText + '\'' +
                ", answer_1='" + answer_1 + '\'' +
                ", answer_2='" + answer_2 + '\'' +
                ", answer_3='" + answer_3 + '\'' +
                ", answer_4='" + answer_4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", studentAnswer='" + studentAnswer + '\'' +
                ", marks=" + marks +
                ", examId=" + examId +
                '}';
    }
}