package work.xiaohh.order.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import work.xiaohh.api.pay.entity.PayInfo;
import work.xiaohh.api.pay.remote.PayInfoRemote;
import work.xiaohh.order.entity.OrderInfo;
import work.xiaohh.order.mapper.OrderInfoMapper;
import work.xiaohh.order.service.IOrderInfoService;

import java.util.List;

/**
 * <p>
 * 订单信息服务接口实现
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 16:11:25
 * @file OrderInfoServiceImpl.java
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    /**
     * 订单信息表数据访问接口
     */
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    /**
     * 支付信息控制器远程调用
     */
    @Autowired
    private PayInfoRemote payInfoRemote;

    /**
     * 查询订单信息列表
     *
     * @param orderInfo 查询参数
     * @return 查询结果
     */
    @Override
    public List<OrderInfo> selectOrderInfo(OrderInfo orderInfo) {
        return this.orderInfoMapper.selectOrderInfo(orderInfo);
    }

    /**
     * 根据订单信息ID查询订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 查询到的订单信息
     */
    @Override
    public OrderInfo selectOrderInfoByOrderInfoId(Long orderInfoId) {
        return this.orderInfoMapper.selectOrderInfoByOrderInfoId(orderInfoId);
    }

    /**
     * 新增一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 受影响行数
     */
//    @Transactional
    @GlobalTransactional
    @Override
    public int insertOrderInfo(OrderInfo orderInfo) {
        // 调用数据库的新增接口
        int effectRows = this.orderInfoMapper.insertOrderInfo(orderInfo);
        // 创建支付信息
        var payInfo = new PayInfo();
        payInfo.setOrderInfoId(orderInfo.getOrderInfoId());
        payInfo.setPaidAmount(orderInfo.getOrderAmount());
        payInfo.setAccountInfoId(1L);
        var addPayInfoResult = this.payInfoRemote.insert(payInfo);
        if (!addPayInfoResult.getCode().equals(HttpStatus.OK.value())) {
            // 发生了错误
            throw new RuntimeException("添加支付信息发生错误");
        }
//        if (true) throw new RuntimeException("测试发生错误");
        return effectRows;
    }

    /**
     * 修改一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 受影响行数
     */
    @Override
    public int updateOrderInfo(OrderInfo orderInfo) {
        return this.orderInfoMapper.updateOrderInfo(orderInfo);
    }

    /**
     * 删除一条订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 受影响行数
     */
    @Override
    public int deleteOrderInfoByOrderInfoId(Long orderInfoId) {
        return this.orderInfoMapper.deleteOrderInfoByOrderInfoId(orderInfoId);
    }
}
