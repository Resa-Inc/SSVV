package service;

import domain.Student;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

class ServiceTest {


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void addStudent_ID_In_Database() {
        Student newStudent = new Student("1", "abc", 936, "abc@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        Student addStudent = service.addStudent(newStudent);

        assert !addStudent.getNume().equals(newStudent.getNume());
        assert !addStudent.getEmail().equals(newStudent.getEmail());
        assert addStudent.getGrupa() != (newStudent.getGrupa());

    }

    @org.junit.jupiter.api.Test
    void addStudent_ID_Not_In_Database() {
        Student newStudent = new Student("2", "student", 931, "student@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        Student addStudent = service.addStudent(newStudent);

        assert addStudent == null;
    }
}
