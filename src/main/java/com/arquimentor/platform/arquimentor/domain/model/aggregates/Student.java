package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Password;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.StudentName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
public class Student extends AbstractAggregateRoot<Student> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private StudentName name;

    @Embedded
    @Getter
    private EmailAddress email;

    @Embedded
    private Password password;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Student(String firstName, String lastName, String email, String password) {
        this.name = new StudentName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.password = new Password(password);
    }

    public Student() {

    }
    //DDD => lenguaje ubicuo y no obliga al exterior a crear un parámetro.
    public void updateEmail(String email){
        this.email= new EmailAddress(email);
    }

    public void updatePassword(String password){
        this.password = new Password(password);
    }
    public String getStudentName(){
        return this.name.getFullName();
    }
}
