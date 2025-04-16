package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "mcq")
public class Mcq_Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int mcqNumber;

    private String questionText;


    private String answer_1;


    private String answer_2;

    private String answer_3;


    private String answer_4;


    private String correctAnswer;



    private int marks;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "examId")
    @JsonIgnore // 🔥 Prevents infinite recursion

    private Exam exam;

    // No-args constructor
    public Mcq_Question() {
    }

    // All-args constructor
    public Mcq_Question( int id, int mcqNumber, String questionText, String answer_1, String answer_2, String answer_3, String answer_4, String correctAnswer,int marks, Exam exam) {
        this.id = id;

        this.mcqNumber = mcqNumber;
        this.questionText = questionText;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.correctAnswer = correctAnswer;

        this.marks = marks;
        this.exam = exam;
    }

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

    @Override
    public String toString() {
        return "Mcq_Question{" +

                ", mcqNumber=" + mcqNumber +
                ", questionText='" + questionText + '\'' +
                ", answer_1='" + answer_1 + '\'' +
                ", answer_2='" + answer_2 + '\'' +
                ", answer_3='" + answer_3 + '\'' +
                ", answer_4='" + answer_4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +

                ", marks=" + marks +
                ", exam=" + exam +
                '}';
    }
}