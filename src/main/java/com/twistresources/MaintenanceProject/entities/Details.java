package com.twistresources.MaintenanceProject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data
public class Details {

    @NotBlank(message = "title is required")
    @JsonProperty(value = "Title")
    private String title;

    @NotBlank(message = "author is required")
    @JsonProperty(value = "Author")
    private String author;

    @NotBlank(message = "publisher is required")
    @JsonProperty(value = "Publisher")
    private String publisher;

    @NotBlank(message = "genre is required")
    @JsonProperty(value = "Genre")
    private String genre;
}