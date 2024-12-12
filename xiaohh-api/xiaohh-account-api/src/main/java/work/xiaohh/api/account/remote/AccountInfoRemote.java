package work.xiaohh.api.account.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import work.xiaohh.api.account.entity.AccountInfo;
import work.xiaohh.common.http.entity.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 账户信息远程调用接口
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:45:44
 * @file AccountInfoRemote.java
 */
@FeignClient(name = "xiaohh-account", contextId = "AccountInfoRemote", path = "/accountInfo")
public interface AccountInfoRemote {

    /**
     * 查询账户信息列表
     *
     * @param accountInfo 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    ResponseEntity<List<AccountInfo>> list(AccountInfo accountInfo);

    /**
     * 根据账户信息ID查询账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 查询到的账户信息
     */
    @GetMapping("/{accountInfoId}")
    ResponseEntity<AccountInfo> get(@PathVariable("accountInfoId") Long accountInfoId);

    /**
     * 新增一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PostMapping
    ResponseEntity<Void> insert(@RequestBody AccountInfo accountInfo);

    /**
     * 修改一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PutMapping
    ResponseEntity<Void> update(@RequestBody AccountInfo accountInfo);

    /**
     * 扣减账户余额
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PutMapping("/reduce")
    ResponseEntity<Void> reduceBalance(@RequestBody AccountInfo accountInfo);

    /**
     * 删除一条账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 处理结果
     */
    @DeleteMapping("/{accountInfoId}")
    ResponseEntity<Void> delete(@PathVariable("accountInfoId") Long accountInfoId);
}
