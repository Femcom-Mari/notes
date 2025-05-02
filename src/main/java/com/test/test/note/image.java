package com.test.test.note;

import org.hibernate.annotations.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "images")
public class image {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String type;

    @Lob
    private byte [] imageData;
}
