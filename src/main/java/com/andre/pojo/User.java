package com.andre.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer id; // 主鍵ID
    private String username; // 用戶名

    @JsonIgnore // 讓springmvc把物件轉換成json字串的時候,忽略password,最終的json字串就沒有password這個屬性了
    private String password; // 密碼

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname; // 暱稱

    @NotEmpty
    @Email
    private String email; // 郵箱

    private String userPic; // 用戶頭像地址
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 更新時間
}
