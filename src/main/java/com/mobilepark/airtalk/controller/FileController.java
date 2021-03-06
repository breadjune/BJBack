package com.mobilepark.airtalk.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobilepark.airtalk.data.BoardFile;
import com.mobilepark.airtalk.service.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/rest/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    
    @Autowired
    public FileService fileService;

    @RequestMapping(value="/search.json",method = RequestMethod.POST)
    public @ResponseBody List<BoardFile> search (Model model, @RequestBody JSONObject form) {
        List<BoardFile> list = fileService.search();

        return list;

    }

    @RequestMapping(value="/create.json",method = RequestMethod.POST)
    public @ResponseBody String create (Model model, MultipartHttpServletRequest req, BoardFile boardFile) {

        String result = fileService.create(req, boardFile);

        return result;

    }

    @RequestMapping(value="/update.json",method = RequestMethod.POST)
    public @ResponseBody String update (Model model, @RequestBody JSONObject form) {
        String result = fileService.update(form);

        return result;

    }

    @RequestMapping(value="/delete.json",method = RequestMethod.POST)
    public @ResponseBody String delete (Model model, @RequestBody JSONObject form) {
        String result = fileService.delete(form);

        return result;

    }

}
