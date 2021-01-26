package com.zhyue.consumer.model;

import com.zhyue.consumer.client.model.provider.User;
import com.zhyue.consumer.entity.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhyue
 * @version 1.0
 * @date 2021/1/26 14:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Title_User extends Title {
    private User user;

    public Title_User(User user, Title title) {
        this.user = user;
        this.setId(title.getId());
        this.setUserId(title.getUserId());
        this.setNumber(title.getNumber());
        this.setName(title.getName());
    }
}
