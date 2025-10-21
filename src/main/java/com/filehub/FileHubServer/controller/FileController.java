package com.filehub.FileHubServer.controller;

import com.filehub.FileHubServer.FMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FMUtil FMUtil;

    public FileController(FMUtil FMUtil)
    {
        this.FMUtil = FMUtil;
    }


    @GetMapping("/filelist")
    public ResponseEntity<?> getFileList(@RequestParam String filePath)
    {
        return FMUtil.getFilesList(filePath);
    }

    @GetMapping("downloadfile")
    public ResponseEntity<?> sendFile(@RequestParam String filePath)
    {
        return FMUtil.getFile(filePath);
    }

    @PostMapping(value = "/uploadfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam String toPath, @RequestParam("file") MultipartFile file) {
        return FMUtil.putFile(toPath,file);
    }
}
