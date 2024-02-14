package com.andre.mapper;

import com.andre.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ArticleMapper
 * Package: com.andre.mapper
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/8 - 10:53
 * @Version: v1.0
 */
@Mapper
public interface ArticleMapper {

    // 新增文章
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    // 分頁的動態sql 不要用註解的形式寫, 用xml
    List<Article> list(Integer userId, Integer categoryId, String state);

    // 獲取文章詳情 - 根據ID
    @Select("select * from article where id= #{id}")
    Article findById(Integer id);

    // 更新文章
    @Update("update article set title=#{title}, content=#{content}, cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId}, update_time=#{updateTime} where id=#{id}")
    void update(Article article);

    // 刪除文章
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);
}
