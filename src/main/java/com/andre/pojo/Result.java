package com.andre.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code; // 業務狀態碼  0-成功  1-失敗
    private String message; // 提示訊息
    private T data; // 響應的data

    // 快速返回操作成功的響應結果(攜帶響應的data)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //  快速返回操作成功的響應結果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }
    // 失敗訊息
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
