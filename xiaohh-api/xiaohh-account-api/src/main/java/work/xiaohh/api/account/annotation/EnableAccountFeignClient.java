package work.xiaohh.api.account.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * <p>
 * 启用账户模块的远程调用
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:51:14
 * @file EnableAccountFeignClient.java
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@EnableFeignClients(basePackages = {"work.xiaohh.api.account.remote"})
public @interface EnableAccountFeignClient {
}
