package work.xiaohh.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.xiaohh.account.mapper.AccountInfoMapper;
import work.xiaohh.account.service.IAccountInfoService;
import work.xiaohh.api.account.entity.AccountInfo;

import java.util.List;

/**
 * <p>
 * 账户信息服务接口实现
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:04:33
 * @file AccountInfoServiceImpl.java
 */
@Service
public class AccountInfoServiceImpl implements IAccountInfoService {

    /**
     * 账户信息表数据访问接口
     */
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    /**
     * 查询账户信息列表
     *
     * @param accountInfo 查询参数
     * @return 查询结果
     */
    @Override
    public List<AccountInfo> selectAccountInfo(AccountInfo accountInfo) {
        return this.accountInfoMapper.selectAccountInfo(accountInfo);
    }

    /**
     * 根据账户信息ID查询账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 查询到的账户信息
     */
    @Override
    public AccountInfo selectAccountInfoByAccountInfoId(Long accountInfoId) {
        return this.accountInfoMapper.selectAccountInfoByAccountInfoId(accountInfoId);
    }

    /**
     * 新增一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    @Override
    public int insertAccountInfo(AccountInfo accountInfo) {
        return this.accountInfoMapper.insertAccountInfo(accountInfo);
    }

    /**
     * 修改一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    @Override
    public int updateAccountInfo(AccountInfo accountInfo) {
        return this.accountInfoMapper.updateAccountInfo(accountInfo);
    }

    /**
     * 扣减账户余额
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    @Override
    public int reduceAccountInfoBalance(AccountInfo accountInfo) {
        return this.accountInfoMapper.reduceAccountInfoBalance(accountInfo);
    }

    /**
     * 删除一条账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 受影响行数
     */
    @Override
    public int deleteAccountInfoByAccountInfoId(Long accountInfoId) {
        return this.accountInfoMapper.deleteAccountInfoByAccountInfoId(accountInfoId);
    }
}
