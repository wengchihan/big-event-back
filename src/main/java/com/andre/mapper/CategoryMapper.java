package com.andre.mapper;

import com.andre.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: CategoryMapper
 * Package: com.andre.mapper
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/7 - 16:30
 * @Version: v1.0
 */
@Mapper
public interface CategoryMapper {

    // 新增
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            "values (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    // 查詢所有
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);

    // 獲取文章分類詳情 - 根據Id查詢分類訊息
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    // 更新文章分類
    @Update("update category set category_name=#{categoryName}, category_alias=#{categoryAlias}, update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    // 刪除文章分類 - 根據id
    @Delete("delete from category where id=#{id}")
    void delete(Integer id);
}
