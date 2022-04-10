package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import java.time.LocalDate;

class ServiceIntegrationTest {
    StudentXMLRepo studentFileRepository;
    StudentValidator studentValidator;
    TemaXMLRepo temaFileRepo;
    TemaValidator temaValidator;
    NotaXMLRepo notaFileRepo;
    NotaValidator notaValidator;
    Service service;


    @BeforeEach
    void setUp() {
        this.studentFileRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        this.studentValidator = new StudentValidator();
        this.temaFileRepo = new TemaXMLRepo("fisiere/Teme.xml");
        this.temaValidator = new TemaValidator();
        this.notaFileRepo = new NotaXMLRepo("fisiere/Note.xml");
        this.notaValidator = new NotaValidator(studentFileRepository, temaFileRepo);
        this.service = new Service(studentFileRepository, studentValidator, temaFileRepo, temaValidator, notaFileRepo, notaValidator);

    }

    @Test
    void addStudent() {
        Student newStudent = new Student(null, "somename", 0, "somename@yahoo.com");
        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Id incorect!");
        }
    }

    @Test
    void addTema() {
        Tema newTema = new Tema(null, "newtema", 1, 4);
        try{
            service.addTema(newTema);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Numar tema invalid!");
        }
    }

    @Test
    void addNota() {
        Nota newNota =new Nota("1005","2001","1",10.0, LocalDate.now());
        try{
            service.addNota(newNota,"great job");
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Studentul nu exista!");
        }
    }

    @Test
    void addAllInOne(){
        Student newStudent = new Student(null, "somename", 0, "somename@yahoo.com");
        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Id incorect!");
        }

        Tema newTema = new Tema(null, "newtema", 1, 4);
        try{
            service.addTema(newTema);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Numar tema invalid!");
        }

        Nota newNota =new Nota("1005","2001","1",10.0, LocalDate.now());
        try{
            service.addNota(newNota,"great job");
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Studentul nu exista!");
        }
    }

    @Test
    void addStudentIncremental() {
        Student newStudent = new Student("", "somename", 0, "somename@yahoo.com");
        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Id incorect!");
        }
    }

    @Test
    void addStudentAssignmentIncremental() {
        Student newStudent = new Student("", "somename", 0, "somename@yahoo.com");
        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception) {
            assert exception.getMessage().equals("Id incorect!");
        }

        Tema newTema = new Tema("", "newtema", 1, 4);
        try{
            service.addTema(newTema);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Numar tema invalid!");
        }
    }

    @Test
    void addStudentAssignmentGradeIncremental() {
        Student newStudent = new Student("", "somename", 0, "somename@yahoo.com");
        try{
            service.addStudent(newStudent);
        }catch (ValidationException exception) {
            assert exception.getMessage().equals("Id incorect!");
        }

        Tema newTema = new Tema("", "newtema", 1, 4);
        try{
            service.addTema(newTema);
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Numar tema invalid!");
        }

        Nota newNota =new Nota("","2001","1",10.0, LocalDate.now());
        try{
            service.addNota(newNota,"great job");
        }catch (ValidationException exception){
            assert exception.getMessage().equals("Studentul nu exista!");
        }
    }

}
