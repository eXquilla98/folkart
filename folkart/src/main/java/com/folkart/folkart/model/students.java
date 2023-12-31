package com.folkart.folkart.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Parent;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students" )
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "nameIni")
    private String nameIni;
    @Column(name = "email")
    private  String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private parents parent;
    public students(){
        // Default constructor
        // No-args constructor required by JPA - a huge error occurs without using this and try to get the jason respose for connecting mysql table lol
    }

    public students(String fullName, String nameIni, String email,parents parent) {
        this.fullName = fullName;
        this.nameIni = nameIni;
        this.email = email;
        this.parent=parent;
    }

    public parents getParent() {
        return parent;
    }

    public void setParent(parents parent) {
        this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameIni() {
        return nameIni;
    }

    public void setNameIni(String nameIni) {
        this.nameIni = nameIni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nameIni='" + nameIni + '\'' +
                ", email='" + email + '\'' +
                ", parent=" + parent +
                '}';
    }
}
