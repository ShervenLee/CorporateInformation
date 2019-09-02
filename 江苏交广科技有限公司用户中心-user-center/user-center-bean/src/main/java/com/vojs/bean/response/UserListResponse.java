package com.vojs.bean.response;

import com.vojs.bean.domain.User;

import java.util.List;

/**
 * Created by apple on 16/5/8.
 */
public class UserListResponse extends BaseResponse {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
