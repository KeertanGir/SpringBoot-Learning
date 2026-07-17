package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CompanyRequestDto {

    @NotBlank(message = "Company name Field is Required")
    @Size( min = 2, message = "name must have at-least 2 latters")
    private String name;

    @Size(min = 10, message = "description should have at-least 10 latters")
    private String description;

    @Pattern(regexp = "^(https?://).*", message = "Website Should have Valid URL staring with : http:// or https://")
    private String companySite;

    public CompanyRequestDto(String name, String description, String companySite) {
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
