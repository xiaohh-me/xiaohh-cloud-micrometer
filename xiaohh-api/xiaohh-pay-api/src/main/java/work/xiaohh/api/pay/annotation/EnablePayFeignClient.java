package work.xiaohh.api.pay.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * <p>
 * 启用支付模块的远程调用
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 16:02:33
 * @file EnablePayFeignClient.java
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@EnableFeignClients(basePackages = {"work.xiaohh.api.pay.remote"})
public @interface EnablePayFeignClient {
}
