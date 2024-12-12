package work.xiaohh.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xiaohh.api.pay.entity.PayInfo;
import work.xiaohh.common.http.entity.ResponseEntity;
import work.xiaohh.pay.service.IPayInfoService;

import java.util.List;

/**
 * <p>
 *     支付信息前端控制器
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:14:16
 * @file PayInfoController.java
 */
@RestController
@RequestMapping("/payInfo")
public class PayInfoController {

    /**
     * 支付信息服务接口
     */
    @Autowired
    private IPayInfoService payInfoService;

    /**
     * 查询支付信息列表
     *
     * @param payInfo 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PayInfo>> list(PayInfo payInfo) {
        return ResponseEntity.success(this.payInfoService.selectPayInfo(payInfo));
    }

    /**
     * 根据支付信息ID查询支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 查询到的支付信息
     */
    @GetMapping("/{payInfoId}")
    public ResponseEntity<PayInfo> get(@PathVariable("payInfoId") Long payInfoId) {
        return ResponseEntity.success(this.payInfoService.selectPayInfoByPayInfoId(payInfoId));
    }

    /**
     * 新增一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 处理结果
     */
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PayInfo payInfo) {
        return ResponseEntity.conditionWithEffectRows(this.payInfoService.insertPayInfo(payInfo));
    }

    /**
     * 修改一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 处理结果
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PayInfo payInfo) {
        return ResponseEntity.conditionWithEffectRows(this.payInfoService.updatePayInfo(payInfo));
    }

    /**
     * 删除一条支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 处理结果
     */
    @DeleteMapping("/{payInfoId}")
    public ResponseEntity<Void> delete(@PathVariable("payInfoId") Long payInfoId) {
        return ResponseEntity.conditionWithEffectRows(this.payInfoService.deletePayInfoByPayInfoId(payInfoId));
    }
}
