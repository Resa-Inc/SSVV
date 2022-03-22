package service;

import domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest_WBT {

    @BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void addStudent_Name_Null() {
        Student newStudent = new Student("3", null, 931, "newstudent@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Nume incorect!");
        }
    }

    @org.junit.jupiter.api.Test
    void addStudent_Email_Null() {
        Student newStudent = new Student("3", "somename", 931, null);
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Email incorect!");
        }
    }


    @org.junit.jupiter.api.Test
    void addStudent_Name_Empty_String() {
        Student newStudent = new Student("3", "", 931, "newstudent@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Nume incorect!");
        }
    }

    @org.junit.jupiter.api.Test
    void addStudent_Email_Empty_String() {
        Student newStudent = new Student("3", "somename", 931, "");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Email incorect!");
        }
    }

    @org.junit.jupiter.api.Test
    void addStudent_Group_Negative() {
        Student newStudent = new Student("3", "somename", -5, "somename@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Grupa incorecta!");
        }
    }


    @org.junit.jupiter.api.Test
    void addStudent_Group_Null() {
        Student newStudent = new Student("3", "somename", null, "somename@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Grupa nu poate fi null!");
        }
    }

    @org.junit.jupiter.api.Test
    void addStudent_ID_Null() {
        Student newStudent = new Student(null, "somename", 931, "somename@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Id incorect!");
        }
    }
}
