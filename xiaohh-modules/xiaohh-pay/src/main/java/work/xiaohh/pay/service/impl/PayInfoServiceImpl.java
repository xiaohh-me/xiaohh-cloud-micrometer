package work.xiaohh.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import work.xiaohh.api.account.entity.AccountInfo;
import work.xiaohh.api.account.remote.AccountInfoRemote;
import work.xiaohh.api.pay.entity.PayInfo;
import work.xiaohh.pay.mapper.PayInfoMapper;
import work.xiaohh.pay.service.IPayInfoService;

import java.util.List;

/**
 * <p>
 * 支付信息服务接口实现
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 15:11:37
 * @file PayInfoService.java
 */
@Service
public class PayInfoServiceImpl implements IPayInfoService {

    /**
     * 支付信息表数据访问接口
     */
    @Autowired
    private PayInfoMapper payInfoMapper;

    /**
     * 账户信息控制器远程调用
     */
    @Autowired
    private AccountInfoRemote accountInfoRemote;

    /**
     * 查询支付信息列表
     *
     * @param payInfo 查询参数
     * @return 查询结果
     */
    @Override
    public List<PayInfo> selectPayInfo(PayInfo payInfo) {
        return this.payInfoMapper.selectPayInfo(payInfo);
    }

    /**
     * 根据支付信息ID查询支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 查询到的支付信息
     */
    @Override
    public PayInfo selectPayInfoByPayInfoId(Long payInfoId) {
        return this.payInfoMapper.selectPayInfoByPayInfoId(payInfoId);
    }

    /**
     * 新增一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 受影响行数
     */
    @Override
    public int insertPayInfo(PayInfo payInfo) {
        // 扣减账户余额
        var accountInfo = new AccountInfo();
        accountInfo.setAccountInfoId(payInfo.getAccountInfoId());
        accountInfo.setBalance(payInfo.getPaidAmount());
        var reduceBalanceResult = this.accountInfoRemote.reduceBalance(accountInfo);
        if (!reduceBalanceResult.getCode().equals(HttpStatus.OK.value())) {
            // 发生了错误
            return 0;
        }
        return this.payInfoMapper.insertPayInfo(payInfo);
    }

    /**
     * 修改一条支付信息
     *
     * @param payInfo 支付信息实体
     * @return 受影响行数
     */
    @Override
    public int updatePayInfo(PayInfo payInfo) {
        return this.payInfoMapper.updatePayInfo(payInfo);
    }

    /**
     * 删除一条支付信息
     *
     * @param payInfoId 支付信息ID
     * @return 受影响行数
     */
    @Override
    public int deletePayInfoByPayInfoId(Long payInfoId) {
        return this.payInfoMapper.deletePayInfoByPayInfoId(payInfoId);
    }
}
