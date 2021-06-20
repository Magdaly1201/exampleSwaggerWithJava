package com.example.maggui.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

import com.example.maggui.dto.StudentDTO;
import com.example.maggui.enums.EnumStateStudents;
import com.example.maggui.exceptions.StudentNotFoundException;

/**
 * Controller the Student
 * 
 * @author Magdaly Santos
 * 
 */
@Controller
public class StudentController {

    List<StudentDTO> students = new ArrayList<StudentDTO>();
    {
	students.add(new StudentDTO("Magdaly", 26, "Venezuela", EnumStateStudents.GRADUATE));
	students.add(new StudentDTO("Jose", 24, "Venezuela", EnumStateStudents.NOT_ASSIGNED));
	students.add(new StudentDTO("Pedro", 25, "EEUU", EnumStateStudents.NOT_GRADUATE));
	students.add(new StudentDTO("Lucas", 20, "Argentina", EnumStateStudents.GRADUATE));
    }

    public StudentDTO getStudentByName(String name) throws StudentNotFoundException {
	System.out.println("Searching Student by name : " + name);
	StudentDTO student = students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst()
		.orElseThrow(() -> new StudentNotFoundException());
	System.out.println(students);
	return student;
    }

    public List<StudentDTO> getStudentAll() {
	return students;
    }

    public List<StudentDTO> getStudentByCountry(String country) {
	System.out.println("Searching Student in country : " + country);
	List<StudentDTO> studentsByCountry = students.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
		.collect(Collectors.toList());
	System.out.println(studentsByCountry);
	return studentsByCountry;
    }

    public StudentDTO createdStudent(StudentDTO student) {
	students.add(student);
	System.out.println(student);
	return student;
    }

}
