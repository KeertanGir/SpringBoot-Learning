package org.learnspringframework.jobboard.dtos;

public class CompanyResponseDto {

    private Long id;
    private String name;
    private String description;
    private String companySite;

    public CompanyResponseDto(Long id, String name, String description, String companySite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.companySite = companySite;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanySite() {
        return companySite;
    }

    public void setCompanySite(String companySite) {
        this.companySite = companySite;
    }
}
