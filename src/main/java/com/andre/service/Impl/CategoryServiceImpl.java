package com.andre.service.Impl;

import com.andre.mapper.CategoryMapper;
import com.andre.pojo.Category;
import com.andre.service.CategoryService;
import com.andre.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.andre.service.Impl
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/7 - 16:30
 * @Version: v1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 新增文章分類
    @Override
    public void add(Category category) {
        // 補充屬性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        // ID從ThreadLocal中獲取
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }

    // 列表查詢
    @Override
    public List<Category> list() {
        // 當前用戶ID
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return categoryMapper.list(userId);
    }

    // 獲取文章分類詳情 - 根據Id查詢分類訊息
    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    // 更新文章分類
    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    // 刪除文章分類 - 根據id
    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}
