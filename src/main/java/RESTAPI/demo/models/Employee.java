package RESTAPI.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Employee")
public class Employee {
    @Id
    String id;
    @Field(name="name")
    String EmployeeName;
    @Field(name="des")
    Designation EmployeeDesignation;
    @Field(name="team")
    String EmployeeTeam;
    @Field(name="exp")
    int Experience;

    public Employee(String id, String EmployeeName, Designation EmployeeDesignation, String EmployeeTeam, int Experience) {
        this.id = id;
        this.EmployeeName = EmployeeName;
        this.EmployeeDesignation = EmployeeDesignation;
        this.EmployeeTeam = EmployeeTeam;
        this.Experience = Experience;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public Designation getEmployeeDesignation() {
        return EmployeeDesignation;
    }

    public String getEmployeeTeam() {
        return EmployeeTeam;
    }

    public int getExperience() {
        return Experience;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public void setEmployeeDesignation(Designation employeeDesignation) {
        this.EmployeeDesignation = employeeDesignation;
    }

    public void setEmployeeTeam(String employeeTeam) {
        this.EmployeeTeam = employeeTeam;
    }

    public void setExperience(int experience) {
        this.Experience = experience;
    }
}
