package org.learnspringframework.jobboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.CompanyRequestDto;
import org.learnspringframework.jobboard.dtos.CompanyResponseDto;
import org.learnspringframework.jobboard.entities.Company;
import org.learnspringframework.jobboard.service.CompanyService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Company", description = "Api for Performing Operations On Company")
@RestController
@RequestMapping("jobboard/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Api is Working well"),
        @ApiResponse(responseCode = "404", description = "No any Company data found"),
        @ApiResponse(responseCode = "500", description = "internal Server Error")

    })
    @Operation(summary = "Retrieve All Companies", description = "Get All Companies")
    @GetMapping
    public ResponseEntity<List<CompanyResponseDto>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working well"),
            @ApiResponse(responseCode = "404", description = "Company Not found"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")

    })
    @Operation(summary = "Retrieve Company by Id", description = "Get Company By Id")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CompanyResponseDto>> getCompanyByID(@PathVariable Long id){
        CompanyResponseDto companyById = companyService.getCompanyById(id);

        EntityModel<CompanyResponseDto> entityModel = EntityModel.of(companyById);
        WebMvcLinkBuilder mvcLinkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllCompanies());
        entityModel.add(mvcLinkBuilder.withRel("All-Companies"));
        mvcLinkBuilder = WebMvcLinkBuilder.linkTo(methodOn(SkillsController.class).getAllSkills());
        entityModel.add(mvcLinkBuilder.withRel("all-Skills"));
        mvcLinkBuilder = WebMvcLinkBuilder.linkTo(methodOn(JobsPostingsController.class).getJobs("", "", "", ""));
        entityModel.add(mvcLinkBuilder.withRel("all-Jobs"));

        return ResponseEntity.ok(entityModel);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Api is Working well - Company Created"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")

    })
    @Operation(summary = "Create Company", description = "creating Company")
    @PostMapping
    public ResponseEntity<CompanyRequestDto> createCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto){


        Company newCompany = companyService.createCompany(companyRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCompany.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Company Deleted Successfully"),
            @ApiResponse(responseCode = "404", description = "Company Not found By Id"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")

    })
    @Operation(summary = "delete Company", description = "Removing Company from Record")
    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyRequestDto> deleteCompany(@PathVariable Long id){
         companyService.deleteCompany(id);
         return ResponseEntity.noContent().build();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working well"),
            @ApiResponse(responseCode = "404", description = "No any Company data found"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")

    })
    @Operation(summary = "Updating Company", description = "Update A Specific Company")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyRequestDto> updateCompany(@PathVariable Long id, @Valid @RequestBody CompanyRequestDto companyRequestDto){
        companyService.updateCompany(id, companyRequestDto);
        return ResponseEntity.ok().build();
    }





}
