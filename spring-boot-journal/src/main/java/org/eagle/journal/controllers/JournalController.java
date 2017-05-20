package org.eagle.journal.controllers;

import java.util.List;

import org.eagle.journal.domain.Journal;
import org.eagle.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JournalController {
	
	@Autowired 
	private JournalRepository journalRepo; 
	
	@RequestMapping(value="/journal",produces={MediaType.APPLICATION_JSON_UTF8_VALUE},  method=RequestMethod.GET)
	public @ResponseBody List<Journal> getJournal(){
		return journalRepo.findAll();
	}
	
	@RequestMapping(value="/journal/add", method=RequestMethod.POST)
	public @ResponseBody String addJournal(@RequestBody List<Journal> journalEntries){
		String result = "";
		if(journalEntries != null && !journalEntries.isEmpty()){
			for(Journal journal: journalEntries)
			   journalRepo.saveAndFlush(journal);
			
			result = journalEntries.size()+" Journal Entries were added to repository";
		}else{
			result = "No entries to the journal entries";
		}
		return result;
	}
	
	
}
