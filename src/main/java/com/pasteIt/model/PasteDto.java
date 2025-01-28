package com.pasteIt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasteDto {

    private String title;
    private String description;
    private boolean isPrivate;
    private String expiryDate;
    private String slug;
}
