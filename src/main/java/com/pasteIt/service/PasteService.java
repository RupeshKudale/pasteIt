package com.pasteIt.service;

import com.pasteIt.model.Paste;
import com.pasteIt.model.PasteDto;
import org.springframework.stereotype.Service;

@Service
public interface PasteService {

    public Paste createPaste(PasteDto pasteDto);

    public Paste getPaste(String pasteId);

    public void deletePaste(String pasteId);
}
