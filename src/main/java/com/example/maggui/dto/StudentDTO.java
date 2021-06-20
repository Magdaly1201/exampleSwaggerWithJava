package com.example.maggui.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.maggui.enums.EnumStateStudents;

import io.swagger.annotations.ApiModelProperty;

/**
 * class student
 * 
 * @author Magdaly Santos
 * 
 */
public class StudentDTO {

    @ApiModelProperty(value = "first name of the student", name = "name", required = true, dataType = "String", example = "Magdaly")
    @NotNull
    private String name;

    @ApiModelProperty(value = "Country of the Student", name = "country", required = true, dataType = "String", example = "Venezuela")
    @NotNull
    private String country;

    @ApiModelProperty(value = "Age of the Student", name = "age", required = true, dataType = "int", example = "27")
    @NotNull
    @Size(min = 1, max = 100)
    private int age;

    @ApiModelProperty(value = "state now of the Student", name = "state", required = true, dataType = "EnumStateStudents.class", example = "GRADUATE")
    private EnumStateStudents state;

    public StudentDTO(String name, int age, String country, EnumStateStudents state) {
	super();
	this.name = name;
	this.age = age;
	this.country = country;
	this.state = state;
    }

    /**
     * @return
     */
    public String getName() {
	return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
	return age;
    }

    /**
     * @return
     */
    public String getCountry() {
	return country;
    }

    /**
     * @return the state
     */
    public EnumStateStudents getState() {
	return state;
    }

    @Override
    public String toString() {
	return "StudentDTO [name=" + name + ", country=" + country + ", age=" + age + ", state=" + state + "]";
    }

}
