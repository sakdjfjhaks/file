package com.file.copy.file;


import com.file.copy.utils.SnowFlakeId;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileCopyUtil {

    /**
     * 无限复制文件到磁盘存满
     */
    public static void fileCopyInfinite(String outFilePath) throws IOException {
        Long startTime = System.currentTimeMillis();   //获取开始时间
        ClassPathResource classPathResource = new ClassPathResource("static/video/test.mp4");
        InputStream inputStream = classPathResource.getInputStream();
        File inFile = File.createTempFile("test", ".mp4");
        try {
            FileUtils.copyInputStreamToFile(inputStream, inFile);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        String inFilePath =  inFile.getPath();
        String inFileType = inFilePath.substring(inFilePath.lastIndexOf(".") + 1);
        Boolean doBoolean = true;
        while (doBoolean) {
            String outFilePath1 = outFilePath + "\\" + SnowFlakeId.generateID() + "." + inFileType;
            File outFile = new File(outFilePath1);
            try {
                FileUtils.copyFile(inFile, outFile);
            } catch (IOException e) {
                e.printStackTrace();
                doBoolean = false;
                Long endTime = System.currentTimeMillis(); //获取结束时间
                System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
                System.out.println("存满报错");
            }
        }
    }

    /**
     * 根据路径删除文件以及文件夹
     */
    public static void deleteFolder(String filePath) {
        deleteFile(filePath);
    }

    /**
     * 删除文件夹以及子文件
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File fileDelete : files) {
                    if (fileDelete.isDirectory()) {
                        deleteFile(fileDelete.getPath());
                    }
                    fileDelete.delete();
                }
            }
        }
        file.delete();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file =  ResourceUtils.getFile("classpath:static/video/test.mp4");

        System.out.println(file.getPath());
    }
}
