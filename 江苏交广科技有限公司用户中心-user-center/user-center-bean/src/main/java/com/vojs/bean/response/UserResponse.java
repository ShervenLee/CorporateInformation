package com.vojs.bean.response;

import com.vojs.bean.domain.User;

/**
 * Created by apple on 16/4/24.
 */
public class UserResponse extends BaseResponse {

    /**
     * 用户信息
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
