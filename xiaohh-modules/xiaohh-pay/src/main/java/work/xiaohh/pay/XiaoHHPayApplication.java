package work.xiaohh.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import work.xiaohh.api.account.annotation.EnableAccountFeignClient;

/**
 * <p>
 * 支付模块启动类
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:05:26
 * @file XiaoHHPayApplication.java
 */
@EnableAccountFeignClient
@EnableDiscoveryClient
@MapperScan({"work.xiaohh.pay.mapper"})
@SpringBootApplication
public class XiaoHHPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaoHHPayApplication.class, args);
    }
}
