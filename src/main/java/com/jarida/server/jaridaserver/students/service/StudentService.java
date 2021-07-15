package com.jarida.server.jaridaserver.students.service;

import com.jarida.server.jaridaserver.students.model.Student;
import com.jarida.server.jaridaserver.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists"
            );
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exists"

                ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        } else {
            throw new IllegalStateException("name is required");
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        } else {
            throw new IllegalStateException("email is required");
        }

    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findStudentById(studentId);
    }

    /*  public List<Student> getStudent() {
        return List.of(
                new Student(
                        1L,
                        "Mariam",
                        "mariam.adams@gmail.com",
                        LocalDate.of(2001, Month.APRIL, 5),
                        21)
        );
    }*/
}
