package com.example.demoentity;

import javax.persistence.*;

@Entity
@Table(name="leaves")

public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id", nullable = true)
    private Long id;
    @Column(name = "leavesTaken")
    private String leavesTaken;
    @Column(name = "leavesRemaining")
    private String leavesRemaining;

    public Leaves() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(String leavesTaken) {
        this.leavesTaken = leavesTaken;
    }

    public String getLeavesRemaining() {
        return leavesRemaining;
    }

    public void setLeavesRemaining(String leavesRemaining) {
        this.leavesRemaining = leavesRemaining;
    }
}
