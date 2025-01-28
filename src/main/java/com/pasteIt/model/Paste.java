package com.pasteIt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paste {
    @Id
    private String id;
    private String slug;
    private String title;
    private String description;
    private boolean isPrivate;
    private LocalDateTime createdDate;
    private LocalDateTime expiryDate;
}
