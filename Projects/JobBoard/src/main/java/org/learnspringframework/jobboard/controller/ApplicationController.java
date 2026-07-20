package org.learnspringframework.jobboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.ApplicationResponseDto;
import org.learnspringframework.jobboard.dtos.ApplicationsRequestDto;
import org.learnspringframework.jobboard.entities.Applications;
import org.learnspringframework.jobboard.service.ApplicationService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(
        name = "Applications",
        description = "Api for Managing Applications"
)
@RestController
@RequestMapping("jobboard/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Retrieve All", description = "Get all The Applications")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "API is Working Well"),
            @ApiResponse(responseCode = "404", description = "No Any data found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping()
    public ResponseEntity<List<ApplicationResponseDto>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @Operation(summary = "Retrieve By Id", description = "Get Application By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "Application Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ApplicationResponseDto>> getApplicationById(@PathVariable Long id){

        ApplicationResponseDto byId = applicationService.getById(id);

        EntityModel<ApplicationResponseDto> entityModel = EntityModel.of(byId);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllApplications());
        entityModel.add(linkBuilder.withRel("all-Applications"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(CompanyController.class).getAllCompanies());
        entityModel.add(linkBuilder.withRel("All-Companies"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(SkillsController.class).getAllSkills());
        entityModel.add(linkBuilder.withRel("all-Skills"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(JobsPostingsController.class).getJobs("", "", "", ""));
        entityModel.add(linkBuilder.withRel("all-Jobs"));

        return ResponseEntity.ok(entityModel);
    }

    @Operation(summary = "Create Application", description = "Make a new Application")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Api is Working Well, Application Created Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<ApplicationsRequestDto> createApplications(@Valid @RequestBody ApplicationsRequestDto applicationsRequestDto){
        Applications savedApplication = applicationService.createApplication(applicationsRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedApplication.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Delete Application", description = "Delete Application By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "Application Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ApplicationResponseDto> deleteApplicationById( @PathVariable Long id){
        applicationService.deleteApplicationById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update Application", description = "Update Application By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "Application Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationsRequestDto> updateApplication(@PathVariable Long id, @Valid @RequestBody ApplicationsRequestDto applicationsRequestDto ){
        applicationService.updateApplication(id, applicationsRequestDto);
        return ResponseEntity.ok().build();
    }

}
