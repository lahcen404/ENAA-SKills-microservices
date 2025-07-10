package org.budgetmanager.validationservice.dto;

public class BriefDto {
    private Long id;
    private String title;
    private String description;
    // Add other fields as needed

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 