package com.andre.pojo;


import com.andre.anno.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id; // 主鍵ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title; // 文章標題
    @NotEmpty
    private String content; // 文章內容
    //@NotEmpty
    @URL
    private String coverImg; // 封面圖像
    @State
    private String state; // 發佈狀態 已發佈 | 草稿
    //@NotNull
    private Integer categoryId; // 文章分類ID
    private Integer createUser; // 創建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; // 創建時間
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; // 更新時間

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
