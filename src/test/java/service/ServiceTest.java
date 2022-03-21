package service;

import domain.Student;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

        service.deleteStudent("2");
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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});

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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
    }

    @Test
    void addStudent_Group_Null() {
        Student newStudent = new Student("3", "somename", null, "somename@yahoo.com");
        StudentXMLRepo studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaXMLRepo temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        TemaValidator temaValidator = new TemaValidator();
        NotaXMLRepo notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        Service service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
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

        assertThrows(ValidationException.class,()->{service.addStudent(newStudent);});
    }

}
