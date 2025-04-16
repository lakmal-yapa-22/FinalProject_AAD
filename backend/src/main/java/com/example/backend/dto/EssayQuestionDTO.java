package com.example.backend.dto;

import com.example.backend.entity.Exam;

public class EssayQuestionDTO {
    private int id;

    private int questionNumber;

    private String description;


    private String essay_questionText1;
    private String essay_questionText2;
    private String essay_questionText3;
    private String essay_questionText4;


    private int marks;
    private int examId; // Assuming you only need the exam ID in the DTO

    public EssayQuestionDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEssay_questionText1() {
        return essay_questionText1;
    }

    public void setEssay_questionText1(String essay_questionText1) {
        this.essay_questionText1 = essay_questionText1;
    }

    public String getEssay_questionText2() {
        return essay_questionText2;
    }

    public void setEssay_questionText2(String essay_questionText2) {
        this.essay_questionText2 = essay_questionText2;

    }

    public String getEssay_questionText3() {
        return essay_questionText3;
    }

    public void setEssay_questionText3(String essay_questionText3) {
        this.essay_questionText3 = essay_questionText3;
    }

    public String getEssay_questionText4() {
        return essay_questionText4;
    }

    public void setEssay_questionText4(String essay_questionText4) {
        this.essay_questionText4 = essay_questionText4;
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


    public EssayQuestionDTO(int id, int questionNumber, String description, String essay_questionText1, String essay_questionText2, String essay_questionText3, String essay_questionText4,int marks,int examId) {
        this.id = id;
        this.questionNumber = questionNumber;
        this.description = description;

        this.essay_questionText1 = essay_questionText1;
        this.essay_questionText2 = essay_questionText2;

        this.essay_questionText3 = essay_questionText3;
        this.essay_questionText4 = essay_questionText4;

        this.marks = marks;
        this.examId = examId;

    }
}
