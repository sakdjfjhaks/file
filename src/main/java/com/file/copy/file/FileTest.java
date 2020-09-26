package com.file.copy.file;

import com.file.copy.thread.CreateFileThread;

public class FileTest {

        public static void main(String[] args) throws Exception {
           while(true){
               CreateFileThread createFileThread = new CreateFileThread("E:\\666",3);
               createFileThread.sleep(30);
               createFileThread.start();
            }
    }
}
