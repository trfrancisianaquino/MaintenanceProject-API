package com.twistresources.MaintenanceProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
@JsonPropertyOrder(value = {"id", "title", "author", "publisher", "genre"})
@JsonIgnoreProperties(value = {"modified_date", "added_date", "is_deleted", "hibernateLazyInitializer", "handler"})
//@JsonIgnoreProperties(value = {"modified_date", "added_date", "is_deleted"})
@SQLDelete(sql =
        "UPDATE books " +
                "SET is_deleted = true " +
                "WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

//    @Embedded
//    @Valid
//    private Details details;

    @Valid
    @NotBlank(message = "title is required")
    @JsonProperty(value = "title")
    private String title;

    @Valid
    @NotBlank(message = "author is required")
    @JsonProperty(value = "author")
    private String author;

    @Valid
    @NotBlank(message = "publisher is required")
    @JsonProperty(value = "publisher")
    private String publisher;

    @Valid
    @NotBlank(message = "genre is required")
    @JsonProperty(value = "genre")
    private String genre;

    @UpdateTimestamp
    @JsonProperty(value = "modified_date")
    private Date modified_date;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonProperty(value = "added_date")
    private Date added_date;

    @JsonProperty(value = "is_deleted")
    private Boolean is_deleted = false;

}