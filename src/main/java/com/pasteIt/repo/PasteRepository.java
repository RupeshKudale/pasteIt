package com.pasteIt.repo;

import com.pasteIt.model.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasteRepository extends MongoRepository<Paste, String> {
    public Optional<Paste> getPasteBySlug(String pasteId);
}
