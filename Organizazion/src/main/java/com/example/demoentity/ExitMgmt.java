package com.example.demoentity;

import javax.persistence.*;

@Entity
@Table(name="exitMgmt")
public class ExitMgmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stage")
    private String stage;
    @Column(name = "currentStatus")
    private String currentStatus;
    @Column(name = "remarks")
    private String remarks;

    public ExitMgmt() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
