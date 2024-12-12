package work.xiaohh.pay.mapper;

import work.xiaohh.api.pay.entity.PayInfo;

import java.util.List;

/**
 * <p>
 * 支付信息表数据访问接口
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:07:02
 * @file PayInfoMapper.java
 */
public interface PayInfoMapper {

    /**
     * 查询支付信息列表
     *
     * @param payInfo 查询参数
     * @return 查询结果
     */
    List<PayInfo> selectPayInfo(PayInfo payInfo);

    /**
     * 根据支付信息ID查询支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 查询到的支付信息
     */
    PayInfo selectPayInfoByPayInfoId(Long payInfoId);

    /**
     * 新增一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 受影响行数
     */
    int insertPayInfo(PayInfo payInfo);

    /**
     * 修改一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 受影响行数
     */
    int updatePayInfo(PayInfo payInfo);

    /**
     * 删除一条支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 受影响行数
     */
    int deletePayInfoByPayInfoId(Long payInfoId);
}
