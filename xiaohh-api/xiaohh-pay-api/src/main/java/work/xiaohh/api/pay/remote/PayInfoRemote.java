package work.xiaohh.api.pay.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import work.xiaohh.api.pay.entity.PayInfo;
import work.xiaohh.common.http.entity.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 支付信息控制器远程调用
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:59:38
 * @file PayInfoRemote.java
 */
@FeignClient(name = "xiaohh-pay", contextId = "PayInfoRemote", path = "/payInfo")
public interface PayInfoRemote {

    /**
     * 查询支付信息列表
     *
     * @param payInfo 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    ResponseEntity<List<PayInfo>> list(PayInfo payInfo);

    /**
     * 根据支付信息ID查询支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 查询到的支付信息
     */
    @GetMapping("/{payInfoId}")
    ResponseEntity<PayInfo> get(@PathVariable("payInfoId") Long payInfoId);

    /**
     * 新增一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 处理结果
     */
    @PostMapping
    ResponseEntity<Void> insert(@RequestBody PayInfo payInfo);

    /**
     * 修改一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 处理结果
     */
    @PutMapping
    ResponseEntity<Void> update(@RequestBody PayInfo payInfo);

    /**
     * 删除一条支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 处理结果
     */
    @DeleteMapping("/{payInfoId}")
    ResponseEntity<Void> delete(@PathVariable("payInfoId") Long payInfoId);
}
