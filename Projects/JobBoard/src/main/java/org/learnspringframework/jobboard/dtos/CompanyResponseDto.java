package org.learnspringframework.jobboard.dtos;

public class CompanyResponseDto {

    private String name;
    private String description;
    private String companySite;

    public CompanyResponseDto(String name, String description, String companySite) {
        this.name = name;
        this.description = description;
        this.companySite = companySite;
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
