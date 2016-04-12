package org.eco.controllers;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.eco.configs.XLSParser;
import org.eco.repo.IMember;
import org.ecoevolution.model.Member;
import org.ecoevolution.model.MemberParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.enterprise.inject.Model;

@RestController
@RequestMapping(value = "/member", produces = "application/json")
public class MemberController {
    @Autowired
    private IMember repo;
    @Autowired
    private XLSParser parser;

    public IMember getRepo() {
        return repo;
    }

    public void setRepo(IMember repo) {
        this.repo = repo;
    }

    @RequestMapping("/getAll")
    public List<org.ecoevolution.model.Member> getAll() {
        List<Member> members = repo.getAll();
        return members;
    }

    @RequestMapping(path = "/getAllByParams", method = RequestMethod.POST)
    public List<org.ecoevolution.model.Member> add(@RequestBody MemberParams params) {
        List<Member> members = repo.getAllBy(params);
        return members;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exportData")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                repo.clean();
                repo.insertBatch(parser.exportDataMembers(file.getInputStream()));
                return "Success!";
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return "File is empty";
        }
    }
}
