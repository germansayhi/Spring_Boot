package com.vti.kshop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "accessory_details")
public class CarDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", length = 50, nullable = false)
    private String licensePlate;

    @Column(name = "repair_date", nullable = false)
    private LocalDate repairDate;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "status_damaged",length = 100, nullable = false)
    private String statusDamaged;

    @Column(name = "repair_status",length = 100, nullable = false)
    private String repiarStatus;

    @ManyToOne
    @JoinColumn(
            name = "car_id",
            referencedColumnName = "id",
            nullable = false
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}
