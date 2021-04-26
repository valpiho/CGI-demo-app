package com.cgi.dentistapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "dentist")
    private List<DentistVisitEntity> dentistVisitEntityList;

    public Dentist() {
    }

    public Dentist(String fullName) {
        this.fullName = fullName;
        this.dentistVisitEntityList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<DentistVisitEntity> getDentistVisitEntityList() {
        return dentistVisitEntityList;
    }

    public void setDentistVisitEntityList(List<DentistVisitEntity> dentistVisitEntityList) {
        this.dentistVisitEntityList = dentistVisitEntityList;
    }
}
