package com.pasteIt.controller;

import com.pasteIt.model.*;
import com.pasteIt.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/paste")
public class PasteController {

    @Autowired
    PasteService pasteService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewPaste(@RequestBody PasteDto pasteDto) {
        Paste newPaste = pasteService.createPaste(pasteDto);
        if(newPaste != null) {
            CreatePasteResponseDto responseDto = new CreatePasteResponseDto();
            responseDto.setSlug(newPaste.getSlug());
            responseDto.setTitle(newPaste.getTitle());
            return ResponseEntity.ok(responseDto);
        }

        PasteErrorResponseDto responseDto = new PasteErrorResponseDto();
        responseDto.setMessage("Something went wrong, Please try again later.");
        responseDto.setStatus("500");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

    @GetMapping("/{pasteSlug}")
    public ResponseEntity<?> getPaste(@PathVariable String pasteSlug) {
        Paste paste = pasteService.getPaste(pasteSlug);
        if(paste != null) {
            PasteResponseDto responseDto = new PasteResponseDto();
            responseDto.setDescription(paste.getDescription());
            responseDto.setTitle(paste.getTitle());
            responseDto.setCreatedDate(paste.getCreatedDate().toString());

            return ResponseEntity.ok(responseDto);
        }

        PasteErrorResponseDto responseDto = new PasteErrorResponseDto();
        responseDto.setMessage("Paste did not found.");
        responseDto.setStatus("404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }
}
