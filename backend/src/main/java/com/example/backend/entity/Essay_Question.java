package com.example.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "essay")
public class Essay_Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int questionNumber;

    private String description ;


    private String essay_questionText1;
    private String essay_questionText2;
    private String essay_questionText3;
    private String essay_questionText4;



    private int marks;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "examId")
    @JsonIgnore // 🔥 Prevents infinite recursion

    private Exam exam;
    public Essay_Question() {}
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
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public Essay_Question(int id,int questionNumber,String description,String essay_questionText1,String essay_questionText2,String essay_questionText3,int marks,Exam exam) {
        this.id = id;
        this.questionNumber = questionNumber;
        this.description = description;

        this.essay_questionText1 = essay_questionText1;
        this.essay_questionText2 = essay_questionText2;

        this.essay_questionText3 = essay_questionText3;
        this.essay_questionText4 = essay_questionText4;

        this.marks = marks;
        this.exam = exam;

    }






}