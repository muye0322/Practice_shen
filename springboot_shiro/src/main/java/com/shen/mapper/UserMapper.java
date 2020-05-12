package com.shen.mapper;

import com.shen.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @创建人 shentong
 * @创建时间 2020/5/12
 * @描述
 */
@Repository
public interface UserMapper {
    User findById(String id);

    User findByName(String name);

}
