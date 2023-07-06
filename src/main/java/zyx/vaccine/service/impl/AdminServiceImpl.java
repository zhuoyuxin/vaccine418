package zyx.vaccine.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zyx.vaccine.entity.Admin;
import zyx.vaccine.mapper.AdminMapper;
import zyx.vaccine.service.AdminService;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {
    public Admin login( QueryWrapper queryWrapper)
    {
       return getOne(queryWrapper);

    }
}
