package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "essayResult")
public class EssayResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultId")
    private int resultId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User userId;

    @ManyToOne
    @JoinColumn(name = "examId")
    @JsonIgnore
    private Exam examId;
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "questionId")
    private int questionId;

    private String questionDescription;


    private String part1;


    private String part2;


    private String part3;


    private String part4;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "answer4")
    private String answer4;

    @Column(name = "totalMarks")
    private int totalMarks;

    @Column(name = "obtainedMarks")
    private int obtainedMarks;



    @Column(name = "feedback")
    private String feedback;

    // No-args constructor
    public EssayResult() {
    }

    // All-args constructor
    public EssayResult(int resultId, User userId, Exam examId,int questionId,
                       String answer1, String answer2, String answer3, String answer4,
                       int totalMarks, int obtainedMarks, String feedback) {
        this.resultId = resultId;
        this.userId = userId;
        this.examId = examId;
        this.questionId = questionId;


        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.feedback = feedback;


    }

    // Getters and Setters
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }



    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
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



    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
        public int getQuestionId() {
        return questionId;
        }
        public void setQuestionId(int questionId) {
        this.questionId = questionId;
        }
        public String getQuestionDescription() {
        return questionDescription;
        }
        public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
        }
        public String getPart1() {
        return part1;
        }
        public void setPart1(String part1) {
        this.part1 = part1;
        }
        public String getPart2() {
        return part2;
        }
        public void setPart2(String part2) {
        this.part2 = part2;
        }
        public String getPart3() {
        return part3;
        }
        public void setPart3(String part3) {
        this.part3 = part3;
        }
        public String getPart4() {
        return part4;
        }
        public void setPart4(String part4) {
        this.part4 = part4;
        }
        public void setExamName(String examName) {
        this.examName = examName;
        }
        public String getExamName() {
        return examName;
        }


    // toString() method
    @Override
    public String toString() {
        return "EssayResult{" +
                "resultId=" + resultId +
                ", userId=" + userId +
                ", examId=" + examId +
                ", examName='" + examName + '\'' +
                ", questionId=" + questionId +
                ", questionDescription='" + questionDescription + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                 ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", totalMarks=" + totalMarks +
                ", obtainedMarks=" + obtainedMarks +

                ", feedback='" + feedback + '\'' +
                '}';
    }
}