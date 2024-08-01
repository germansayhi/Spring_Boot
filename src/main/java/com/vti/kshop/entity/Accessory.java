package com.vti.kshop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter
@Setter
@Entity
@Table(name = "accessory")
public class Accessory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "status_damaged",length = 100, nullable = false)
    private String statusDamaged;

    @Column(name = "repair_status",length = 100, nullable = false)
    private String repairStatus;

    @ManyToOne
    @JoinColumns(
            value = {
                    @JoinColumn(
                            name = "license_plate",
                            referencedColumnName = "license_plate",
                            nullable = false
                    ),
                    @JoinColumn(
                            name = "repair_date",
                            referencedColumnName = "repair_date",
                            nullable = false
                    )
            },
            foreignKey = @ForeignKey(
                    value = ConstraintMode.PROVIDER_DEFAULT,
                    foreignKeyDefinition = "foreign key (license_plate, repair_date) references car(license_plate, repair_date) on update cascade"
            )
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}
