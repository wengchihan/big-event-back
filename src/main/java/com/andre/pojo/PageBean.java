package com.andre.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 分頁返回結果的物件
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T>{
    private Long total; // 總條數
    private List<T> items; // 當前頁數據集合
}
