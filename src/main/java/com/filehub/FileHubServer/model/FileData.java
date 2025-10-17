package com.filehub.FileHubServer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileData {
    private String fileName;
    private String filePath;
    private long fileSize;
    private long lastModified;
    private boolean isFile;
}
