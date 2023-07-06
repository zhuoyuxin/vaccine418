package zyx.vaccine.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zyx.vaccine.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity zyx.vaccine.entity.User
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(String username);

    Page<User> findPage(Page<User> objectPage, String username, String age, String nickname);
}




