package work.xiaohh.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import work.xiaohh.api.pay.annotation.EnablePayFeignClient;

/**
 * <p>
 * 订单模块启动类
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:55:51
 * @file XiaoHHOrderApplication.java
 */
@EnablePayFeignClient
@MapperScan({"work.xiaohh.order.mapper"})
@EnableDiscoveryClient
@SpringBootApplication
public class XiaoHHOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaoHHOrderApplication.class, args);
    }
}
