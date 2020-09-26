package com.file.copy.thread;

import com.file.copy.file.FileCreatUtil;

public class CreateFileThread extends Thread {
    private String outFilePath;
    private  Integer fileSize;
    public CreateFileThread(String outFilePath,Integer fileSize){
        this.outFilePath = outFilePath;
        this.fileSize = fileSize;
    }
    @Override
    public void run() {
        try {
            FileCreatUtil.createNewFile(outFilePath, fileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
