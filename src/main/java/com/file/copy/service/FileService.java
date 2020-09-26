package com.file.copy.service;

import com.file.copy.constant.FileEnum;
import com.file.copy.thread.CopyFileThread;
import com.file.copy.thread.CreateFileThread;

public class FileService {
    public static void copyFileRun()  {
        Thread thread1 = new CopyFileThread(FileEnum.D_PATH.getFilePath());
        Thread thread2 = new CopyFileThread(FileEnum.E_PATH.getFilePath());
        Thread thread3 = new CopyFileThread(FileEnum.F_PATH.getFilePath());

        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void createdFileRun() throws InterruptedException {
        while(true){
            CreateFileThread createFileThread = new CreateFileThread("E:\\666",3);
            createFileThread.sleep(30);
            createFileThread.start();
        }
    }
}
