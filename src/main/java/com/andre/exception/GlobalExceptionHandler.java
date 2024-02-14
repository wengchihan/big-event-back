package com.andre.exception;

import com.andre.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.andre.exception
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/5 - 5:29
 * @Version: v1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace(); // 輸出例外訊息
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失敗");
    }
}
