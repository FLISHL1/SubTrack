package org.flishl1.subtrack.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.NaturalId;

import java.util.UUID;

@Entity(name = "Categories")
public class Category {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    public UUID uuid;
    @NaturalId
    @Column(name = "c_name", nullable = false)
    public String name;
    @Column(name = "icon")
    public String icon;
    @ColumnDefault("false")
    @Column(name = "is_user_defined", nullable = false)
    public Boolean isUserDefined;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    public User user;

    public Category() {
    }
}
