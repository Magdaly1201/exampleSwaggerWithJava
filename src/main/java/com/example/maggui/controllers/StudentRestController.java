package com.example.maggui.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maggui.dto.StudentDTO;
import com.example.maggui.exceptions.StudentNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * RestController API the pets
 * 
 * @author Magdaly Santos
 * 
 */
@RestController
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!")
@RequestMapping("/api/v1")
public class StudentRestController {

    @Autowired
    private StudentController controller;

    @GetMapping("/student")
    @ApiOperation(value = "Get list of Students in the System ", response = StudentDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
	    @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
	    @ApiResponse(code = 404, message = "not found!!!") })
    public List<StudentDTO> getStudentAll() {
	return this.controller.getStudentAll();
    }

    @GetMapping("/student/{name}")
    @ApiOperation(value = "Get student by name", response = StudentDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
	    @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
	    @ApiResponse(code = 404, message = "not found!!!") })
    public ResponseEntity<?> getStudentByName(@PathVariable(value = "name") @NotNull String name)
	    throws StudentNotFoundException {
	return new ResponseEntity<StudentDTO>(this.controller.getStudentByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/student/country/{country}")
    @ApiOperation(value = "Get list Students By Country in the System ", response = StudentDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
	    @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!") })
    public List<StudentDTO> getStudentByCountry(@PathVariable(value = "country") @NotNull String country) {
	return this.controller.getStudentByCountry(country);
    }

    @PostMapping(value = "/student")
    @ApiOperation(value = "create Student in the System ", response = StudentDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "created|OK") })
    public ResponseEntity<?> createdStudent(@RequestBody StudentDTO student) {
	return new ResponseEntity<StudentDTO>(this.controller.createdStudent(student), HttpStatus.CREATED);
    }

}
