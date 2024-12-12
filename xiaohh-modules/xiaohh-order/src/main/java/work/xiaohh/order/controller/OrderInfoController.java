package work.xiaohh.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xiaohh.common.http.entity.ResponseEntity;
import work.xiaohh.order.entity.OrderInfo;
import work.xiaohh.order.service.IOrderInfoService;

import java.util.List;

/**
 * <p>
 * 订单信息前端控制器
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 16:12:55
 * @file OrderInfoController.java
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    /**
     * 订单信息服务接口
     */
    @Autowired
    private IOrderInfoService orderInfoService;

    /**
     * 查询订单信息列表
     *
     * @param orderInfo 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<OrderInfo>> list(OrderInfo orderInfo) {
        return ResponseEntity.success(this.orderInfoService.selectOrderInfo(orderInfo));
    }

    /**
     * 根据订单信息ID查询订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 查询到的订单信息
     */
    @GetMapping("/{orderInfoId}")
    public ResponseEntity<OrderInfo> get(@PathVariable("orderInfoId") Long orderInfoId) {
        return ResponseEntity.success(this.orderInfoService.selectOrderInfoByOrderInfoId(orderInfoId));
    }

    /**
     * 新增一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 处理结果
     */
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody OrderInfo orderInfo) {
        return ResponseEntity.conditionWithEffectRows(this.orderInfoService.insertOrderInfo(orderInfo));
    }

    /**
     * 修改一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 处理结果
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody OrderInfo orderInfo) {
        return ResponseEntity.conditionWithEffectRows(this.orderInfoService.updateOrderInfo(orderInfo));
    }

    /**
     * 删除一条订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 处理结果
     */
    @DeleteMapping("/{orderInfoId}")
    public ResponseEntity<Void> delete(@PathVariable("orderInfoId") Long orderInfoId) {
        return ResponseEntity.conditionWithEffectRows(this.orderInfoService.deleteOrderInfoByOrderInfoId(orderInfoId));
    }
}
