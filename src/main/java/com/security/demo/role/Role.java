package com.security.demo.role;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.demo.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id @GeneratedValue
    Integer id;
    @Column(unique = true)
    String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    List<User> users;


    @CreatedDate
    @Column(nullable = false,updatable = false)
    LocalDate createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    LocalDate lastModifiedDate;
}
