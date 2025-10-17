package com.filehub.FileHubServer.controller;

import com.filehub.FileHubServer.Util;
import com.filehub.FileHubServer.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private Util util;

    public FileController(Util util)
    {
        this.util = util;
    }


    @GetMapping("/filelist")
    public ResponseEntity<?> getFileList(@RequestParam String filePath)
    {
        return util.getFilesList(filePath);
    }

    @GetMapping("downloadfile")
    public ResponseEntity<?> sendFile(@RequestParam String filePath)
    {
        return util.getFile(filePath);
    }

    @PostMapping(value = "/uploadfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam String toPath, @RequestParam("file") MultipartFile file) {
        return util.putFile(toPath,file);
    }
}
