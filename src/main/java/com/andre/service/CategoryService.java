package com.andre.service;

import com.andre.pojo.Category;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.andre.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/7 - 16:30
 * @Version: v1.0
 */
public interface CategoryService {

    // 新增分類
    void add(Category category);

    // 列表查詢
    List<Category> list();

    // 獲取文章分類詳情 - 根據Id查詢分類訊息
    Category findById(Integer id);

    // 更新文章分類
    void update(Category category);

    // 刪除文章分類 - 根據id
    void delete(Integer id);
}
