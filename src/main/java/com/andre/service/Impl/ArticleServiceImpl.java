package com.andre.service.Impl;

import com.andre.mapper.ArticleMapper;
import com.andre.pojo.Article;
import com.andre.pojo.PageBean;
import com.andre.service.ArticleService;
import com.andre.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ArticleServiceImpl
 * Package: com.andre.service.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/8 - 10:53
 * @Version: v1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    // 新增文章
    @Override
    public void add(Article article) {
        // 補充屬性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    // 條件分頁 - 列表查詢
    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 1. 創建pageBean物件 封裝資料
        PageBean<Article> pageBean = new PageBean<>();
        // 2. 開啟分頁查詢
        PageHelper.startPage(pageNum, pageSize);
        // 3. 呼叫mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> articleList = articleMapper.list(userId, categoryId, state);

        // Page中提供了方法,可以獲取pageHelper分頁查詢後,得到的總記錄條數和當前頁面資料
        Page<Article> articlePage = (Page<Article>) articleList;

        // 把資料放到PageBean中
       pageBean.setTotal(articlePage.getTotal());
       pageBean.setItems(articlePage.getResult());

        return pageBean;
    }

    // 獲取文章詳情 - 根據ID
    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    // 更新文章
    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
