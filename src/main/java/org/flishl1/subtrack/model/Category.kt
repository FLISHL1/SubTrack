package org.flishl1.subtrack.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.PrimaryKeyJoinColumn
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Generated
import org.hibernate.annotations.NaturalId
import java.util.*

@Entity(name = "Categories")
data class Category(
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    val uuid: UUID,
    @NaturalId
    @Column(name = "c_name", nullable = false)
    val name: String,
    @Column(name = "icon")
    val icon: String,
    @ColumnDefault("false")
    @Column(name = "is_user_defined", nullable = false)
    val isUserDefined: Boolean,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "user_id")
    val user: User,
)
