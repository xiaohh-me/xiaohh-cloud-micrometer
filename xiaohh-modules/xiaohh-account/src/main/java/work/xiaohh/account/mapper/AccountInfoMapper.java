package work.xiaohh.account.mapper;

import work.xiaohh.api.account.entity.AccountInfo;

import java.util.List;

/**
 * <p>
 * 账户信息表数据访问接口
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 13:57:40
 * @file AccountInfoMapper.java
 */
public interface AccountInfoMapper {

    /**
     * 查询账户信息列表
     *
     * @param accountInfo 查询参数
     * @return 查询结果
     */
    List<AccountInfo> selectAccountInfo(AccountInfo accountInfo);

    /**
     * 根据账户信息ID查询账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 查询到的账户信息
     */
    AccountInfo selectAccountInfoByAccountInfoId(Long accountInfoId);

    /**
     * 新增一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    int insertAccountInfo(AccountInfo accountInfo);

    /**
     * 修改一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    int updateAccountInfo(AccountInfo accountInfo);

    /**
     * 扣减账户余额
     *
     * @param accountInfo 账户信息实体
     * @return 受影响行数
     */
    int reduceAccountInfoBalance(AccountInfo accountInfo);

    /**
     * 删除一条账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 受影响行数
     */
    int deleteAccountInfoByAccountInfoId(Long accountInfoId);
}
