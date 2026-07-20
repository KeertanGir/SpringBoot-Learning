package org.learnspringframework.jobboard.dtos;

public class SkillsResponseDto {

    private Long id;
    private String skillName;

    public SkillsResponseDto(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
