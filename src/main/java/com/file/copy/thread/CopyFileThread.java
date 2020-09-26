package com.file.copy.thread;

import com.file.copy.file.FileCopyUtil;

public class CopyFileThread extends Thread {
    private String outFilePath;

    public CopyFileThread(String outFilePath) {
        this.outFilePath = outFilePath;
    }

    @Override
    public void run() {
        try{
            FileCopyUtil.fileCopyInfinite( outFilePath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
