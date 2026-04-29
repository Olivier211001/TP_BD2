package com.example.library.repository;

import com.example.library.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<Log, Long> {
}
