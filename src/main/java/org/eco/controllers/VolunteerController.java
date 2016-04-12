package org.eco.controllers;

import java.io.IOException;
import java.util.List;

import org.eco.configs.XLSParser;
import org.eco.repo.IVolunteer;
import org.ecoevolution.model.VolounteerParams;
import org.ecoevolution.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "/group", produces = "application/json")
public class VolunteerController {
	@Autowired
	private IVolunteer repo;
	@Autowired
	private XLSParser parser;

	public IVolunteer getRepo() {
		return repo;
	}

	public void setRepo(IVolunteer repo) {
		this.repo = repo;
	}

	@RequestMapping("/getAll")
	public List<org.ecoevolution.model.Volunteer> getAll() {
		List<Volunteer> volunteers = repo.getAll();
		return volunteers;
	}

	@RequestMapping(path = "/getAllByParams", method = RequestMethod.POST)
	public List<org.ecoevolution.model.Volunteer> add(@RequestBody VolounteerParams params) {
		List<Volunteer> volunteers = repo.getAllBy(params);
		return volunteers;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/exportData")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				repo.clean();
				repo.insertBatch(parser.exportDataVolunteers(file.getInputStream()));
				return "Success!";
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "File is empty";
		}
	}
}
