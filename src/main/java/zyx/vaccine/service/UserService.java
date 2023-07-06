package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zyx.vaccine.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserService extends IService<User> {
    boolean saveUser(User user);

    User userLogin(String username,String password);

    User userRegister(User userDTO);

    User getUserByUsername(String username);

    Page<User> findPage(Page<User> objectPage, QueryWrapper queryWrapper);
}
