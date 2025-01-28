package com.pasteIt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasteResponseDto {
    private String title;
    private String description;
    private String createdDate;
}
