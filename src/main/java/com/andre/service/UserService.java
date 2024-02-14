package com.andre.service;

import com.andre.pojo.User;

/**
 * ClassName: UserService
 * Package: com.andre.service
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/5 - 3:58
 * @Version: v1.0
 */
public interface UserService {

    // 根據用戶名查詢用戶
    User findByUserName(String username);

    // 註冊
    void register(String username, String password);

    // 更新
    void update(User user);

    // 更新頭像
    void updateAvatar(String avatarUrl);

    // 更新密碼
    void updatePwd(String newPwd);
}
