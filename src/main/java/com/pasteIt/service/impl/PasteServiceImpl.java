package com.pasteIt.service.impl;

import com.pasteIt.model.Paste;
import com.pasteIt.model.PasteDto;
import com.pasteIt.repo.PasteRepository;
import com.pasteIt.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PasteServiceImpl implements PasteService {
    @Autowired
    PasteRepository pasteRepository;
    @Override
    public Paste createPaste(PasteDto pasteDto) {
        Paste paste = new Paste();
        paste.setDescription(pasteDto.getDescription());
        paste.setTitle(pasteDto.getTitle());
        paste.setSlug(pasteDto.getSlug());
        paste.setPrivate(pasteDto.isPrivate());
        paste.setCreatedDate(LocalDateTime.now());
        paste.setExpiryDate(setPasteExpiryDate(pasteDto.getExpiryDate(), paste.getCreatedDate()));

        return pasteRepository.save(paste);
    }

    private LocalDateTime setPasteExpiryDate(String expiryDate, LocalDateTime createdDate) {
        if(expiryDate.isEmpty()) {
            return createdDate.plusDays(5);
        }
        return LocalDateTime.parse(expiryDate);
    }


    @Override
    public Paste getPaste(String pasteId) {
        return pasteRepository.getPasteBySlug(pasteId).orElse(null);
    }

    @Override
    public void deletePaste(String pasteId) {
        Paste paste = getPaste(pasteId);
        pasteRepository.delete(paste);
    }
}
