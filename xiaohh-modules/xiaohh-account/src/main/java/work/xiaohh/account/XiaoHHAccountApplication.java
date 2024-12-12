package work.xiaohh.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * 账户模块启动类
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 13:31:05
 * @file XiaoHHAccountApplication.java
 */
@EnableDiscoveryClient
@MapperScan({"work.xiaohh.account.mapper"})
@SpringBootApplication
public class XiaoHHAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaoHHAccountApplication.class, args);
    }
}
