package com.file.copy.constant;

public enum FileEnum {
    IN_FILE_PATH("F:\\测试文件\\test.mp4"),
    IN_FILE_BIG_PATH("F:\\测试文件\\666.mp4"),
    OUT_MIDER_PATH("F:\\file_copy_test_2"),
    D_PATH("D:\\666"),
    E_PATH("E:\\666"),
    F_PATH("F:\\666"),
    OUT_MIDER_PATH_2("G:");
    private String filePath;

    FileEnum(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
