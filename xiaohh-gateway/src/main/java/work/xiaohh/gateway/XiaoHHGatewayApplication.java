package work.xiaohh.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * 网关模块启动类
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 13:42:29
 * @file XiaoHHGatewayApplication.java
 */
@EnableDiscoveryClient
@SpringBootApplication
public class XiaoHHGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaoHHGatewayApplication.class, args);
    }
}
