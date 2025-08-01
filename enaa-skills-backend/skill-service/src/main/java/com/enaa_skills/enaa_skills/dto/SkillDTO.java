package com.enaa_skills.enaa_skills.dto;



import java.util.List;

public class SkillDTO {
    private Long id;
    private String name;
    //private boolean validate;
    private List<SubSkillDTO> subSkills;

    public SkillDTO(Long id, String name, List<SubSkillDTO> subSkills) {
        this.id = id;
        this.name = name;
        //this.validate = validate;
        this.subSkills = subSkills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<SubSkillDTO> getSubSkills() {
        return subSkills;
    }

    public void setSubSkills(List<SubSkillDTO> subSkills) {
        this.subSkills = subSkills;
    }

//    public boolean isValidate() {
//        return validate;
//    }
//
//    public void setValidate(boolean validate) {
//        this.validate = validate;
//    }
}
