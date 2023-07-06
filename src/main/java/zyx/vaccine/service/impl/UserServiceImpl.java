package zyx.vaccine.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.User;
import zyx.vaccine.exception.ServiceException;
import zyx.vaccine.service.RedisService;
import zyx.vaccine.service.UserService;
import zyx.vaccine.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    private static final Log LOG = Log.get();

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate redisTemplate;

    public boolean saveUser(User user){
        return saveOrUpdate(user);
    }

    public User userLogin(String username,String password) {
//        //根据用户名及密码判定用户是否存在
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        String key = "LoginUserInfo:" + userDTO.getUserName();
//        //判断redis里面是否有用户数据
//        User u = (User) valueOperations.get(key);
//        //如果redis当中存在登陆的用户信息，就从redis拿数据
//        if (u != null) {
//            userDTO = u;
//            LOG.info("使用redis获取登录用户数据");
//            return userDTO;
//        } else {  //如果redis当中不存在登陆的用户信息，就从数据库拿数据，并存入redis当中
//            User one = getUserInfo(userDTO);
//            if (one != null) {
//                BeanUtil.copyProperties(one, userDTO, true);
//                valueOperations.set(key, userDTO);
//                LOG.info("使用数据库获取用户信息");
//                return userDTO;
//            }

        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_name",username);
        queryWrapper.eq("user_password",password);
        return  getOne(queryWrapper);
    }

    @Override
    public User userRegister(User userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(ResultCode.FAILED.getCode(), "用户已存在");
        }
        return one;
    }

    private User getUserInfo(User userDTO)
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userDTO.getUserName());
        queryWrapper.eq("user_password",userDTO.getUserPassword());
        User one;
        //处理异常情况
        try
        {
            one = getOne(queryWrapper);
        }catch (Exception e)
        {
            LOG.error(e);
            throw new ServiceException(ResultCode.FAILED.getCode(),"系统错误");

        }
        return  one;
    }

    public User getUserByUsername(String username)
    {
        return userMapper.selectByUsername(username);
    }

    public Page<User> findPage(Page<User> objectPage, QueryWrapper queryWrapper)
    {
        return page(objectPage,queryWrapper);


    }
//        public Result addOrder()
//        {
//            String lockkey ="lock"+1;
//            Boolean result=redisTemplate.opsForValue().setIfAbsent(lockkey,"hua");
//            if(!result)
//            {
//                return Result.error(500,"请稍后再试");
//            }
//            String produce_id="传参。。。";
//            int stock =Integer.parseInt((String) redisTemplate.opsForValue().get(produce_id));
//
//
//        }

}




