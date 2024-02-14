package com.andre.service;

import com.andre.pojo.Article;
import com.andre.pojo.PageBean;

/**
 * ClassName: ArticleService
 * Package: com.andre.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/8 - 10:53
 * @Version: v1.0
 */
public interface ArticleService {
    // 新增文章
    void add(Article article);

    // 條件分頁 - 列表查詢
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    // 獲取文章詳情 - 根據ID
    Article findById(Integer id);

    // 更新文章
    void update(Article article);

    // 刪除文章
    void delete(Integer id);

}
