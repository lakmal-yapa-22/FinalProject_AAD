package com.example.backend.dto;

public class EssaySummaryDTO {

    private Integer obtainedMarks;
    private String feedback;
    private Integer totalMarks;

    public EssaySummaryDTO(Integer obtainedMarks, String feedback, Integer totalMarks) {
        this.obtainedMarks = obtainedMarks;
        this.feedback = feedback;
        this.totalMarks = totalMarks;
    }

    // Getters and Setters
    public Integer getObtainedMarks() { return obtainedMarks; }
    public void setObtainedMarks(Integer obtainedMarks) { this.obtainedMarks = obtainedMarks; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Integer getTotalMarks() { return totalMarks; }
    public void setTotalMarks(Integer totalMarks) { this.totalMarks = totalMarks; }
}
