package org.learnspringframework.jobboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.UsersRequestDto;
import org.learnspringframework.jobboard.dtos.UsersResponseDto;
import org.learnspringframework.jobboard.entities.Users;
import org.learnspringframework.jobboard.service.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(
        name = "Users",
        description = "Api for Managing Users"
)
@RestController
@RequestMapping("jobboard/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create User", description = "Make a new User")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Api is Working Well, User Created Successfully"),
            @ApiResponse(responseCode = "409", description = "Email is Already in Use, Try new Another one"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<UsersRequestDto> createUser(@Valid @RequestBody UsersRequestDto usersRequestDto){
        Users savedUser =  userService.createUser(usersRequestDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update User", description = "Update User By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "409", description = "Email is Already in Use, Try new Another one"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsersRequestDto> updateUser(@PathVariable Long id, @Valid @RequestBody UsersRequestDto usersRequestDto){
        userService.updateUser(id, usersRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Retrieve All", description = "Get all The Users")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "API is Working Well"),
            @ApiResponse(responseCode = "404", description = "No Any data found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> getAllUsers(){
        List<UsersResponseDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @Operation(summary = "Retrieve By Id", description = "Get User By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsersResponseDto>> getUserById(@PathVariable Long id){
        UsersResponseDto usersResponseDto =  userService.getUserById(id);

        EntityModel<UsersResponseDto> entityModel = EntityModel.of(usersResponseDto);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(linkBuilder.withRel("All-users"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(ApplicationController.class).getAllApplications());
        entityModel.add(linkBuilder.withRel("all-Applications"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(CompanyController.class).getAllCompanies());
        entityModel.add(linkBuilder.withRel("All-Companies"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(SkillsController.class).getAllSkills());
        entityModel.add(linkBuilder.withRel("all-Skills"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(JobsPostingsController.class).getJobs("", "", "", ""));
        entityModel.add(linkBuilder.withRel("all-Jobs"));

        return ResponseEntity.ok(entityModel);

    }

    @Operation(summary = "Delete User", description = "Delete User By Id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Api is Working Well"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UsersResponseDto> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


}
