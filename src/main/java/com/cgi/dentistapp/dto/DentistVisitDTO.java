package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DentistVisitDTO {

    Long dentistId;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date visitTime;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(Long dentistId, Date visitTime) {
        this.dentistId = dentistId;
        this.visitTime = visitTime;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
