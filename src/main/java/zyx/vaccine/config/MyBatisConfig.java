package zyx.vaccine.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2022/10/8.
 */
@Configuration
@MapperScan("zyx.vaccine.mapper")
public class MyBatisConfig {
}

