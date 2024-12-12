package work.xiaohh.order.mapper;

import work.xiaohh.order.entity.OrderInfo;

import java.util.List;

/**
 * <p>
 * 订单信息表数据访问接口
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 16:08:27
 * @file OrderInfoMapper.java
 */
public interface OrderInfoMapper {

    /**
     * 查询订单信息列表
     *
     * @param orderInfo 查询参数
     * @return 查询结果
     */
    List<OrderInfo> selectOrderInfo(OrderInfo orderInfo);

    /**
     * 根据订单信息ID查询订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 查询到的订单信息
     */
    OrderInfo selectOrderInfoByOrderInfoId(Long orderInfoId);

    /**
     * 新增一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 受影响行数
     */
    int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 修改一条订单信息
     *
     * @param orderInfo 订单信息实体
     * @return 受影响行数
     */
    int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 删除一条订单信息
     *
     * @param orderInfoId 订单信息ID
     * @return 受影响行数
     */
    int deleteOrderInfoByOrderInfoId(Long orderInfoId);
}
