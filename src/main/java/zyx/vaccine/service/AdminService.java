package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import zyx.vaccine.entity.Admin;

public interface AdminService extends IService<Admin> {
    Admin login( QueryWrapper<Admin> queryWrapper);
}
