package org.eagle.journal.repository;

import org.eagle.journal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long>{
	
}
