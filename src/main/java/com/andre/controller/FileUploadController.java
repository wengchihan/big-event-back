package com.andre.controller;

import com.andre.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName: FileUploadController
 * Package: com.andre.controller
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/10 - 10:08
 * @Version: v1.0
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        // 把文件的內容儲存到本地
        String originalFilename = file.getOriginalFilename();
        // 保證文件的名字是唯一的,防止文件被覆蓋
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String filePath = "C:" + File.separator + "Users" + File.separator + "翁志安" + File.separator + "Desktop"
                + File.separator + "files" + File.separator + fileName;
        File destFile = new File(filePath);
        file.transferTo(destFile);
        // 本地的文件不能直接訪問, 並沒有url地址
        // 存儲到第三方伺服器上
        return Result.success();
    }
}
