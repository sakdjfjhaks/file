package com.file.copy.file;

import com.file.copy.thread.CreateFileThread;
import com.file.copy.utils.SnowFlakeId;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @Version 2020-05-07 14:53
 * @Version 1.0
 * @Description FileCreatUtil单纯的测试使用, 单位是M
 */
public class FileCreatUtil {

    //随机产生指定大小的文件,纯数字
    public static void createNewFile(String path, int sizeM) throws Exception {
        File file = new File(path+"\\"+SnowFlakeId.generateID() + ".txt" );
        int size = sizeM;
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            CompletableFuture<StringBuilder> c = oneM();
            c.whenComplete((x, y) -> {
                if (x != null) {
                    try {
                        osw.append(x);
                        osw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        osw.close();
    }

    private static CompletableFuture<StringBuilder> oneM() {
        Random r = new Random();
        CompletableFuture<StringBuilder> c = CompletableFuture.supplyAsync(() -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1024 * 1024; i++) {
                sb.append(r.nextInt(10));
            }
            return sb;
        });
        return c;
    }

//    public static void main(String[] args) throws Exception {
//        //几M
////        String string = createString(3);
//        System.out.println(1);
//        FileCreatUtil.createNewFile("E:\\666\\2.txt", 3);
//    }


}

