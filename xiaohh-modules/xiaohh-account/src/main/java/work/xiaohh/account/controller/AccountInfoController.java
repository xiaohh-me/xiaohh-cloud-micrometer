package work.xiaohh.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xiaohh.account.service.IAccountInfoService;
import work.xiaohh.api.account.entity.AccountInfo;
import work.xiaohh.common.http.entity.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 账户信息前端控制器
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:06:09
 * @file AccountInfoController.java
 */
@RestController
@RequestMapping("/accountInfo")
public class AccountInfoController {

    /**
     * 账户信息服务接口
     */
    @Autowired
    private IAccountInfoService accountInfoService;

    /**
     * 查询账户信息列表
     *
     * @param accountInfo 查询参数
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<AccountInfo>> list(AccountInfo accountInfo) {
        return ResponseEntity.success(this.accountInfoService.selectAccountInfo(accountInfo));
    }

    /**
     * 根据账户信息ID查询账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 查询到的账户信息
     */
    @GetMapping("/{accountInfoId}")
    public ResponseEntity<AccountInfo> get(@PathVariable("accountInfoId") Long accountInfoId) {
        return ResponseEntity.success(this.accountInfoService.selectAccountInfoByAccountInfoId(accountInfoId));
    }

    /**
     * 新增一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody AccountInfo accountInfo) {
        return ResponseEntity.conditionWithEffectRows(this.accountInfoService.insertAccountInfo(accountInfo));
    }

    /**
     * 修改一条账户信息
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody AccountInfo accountInfo) {
        return ResponseEntity.conditionWithEffectRows(this.accountInfoService.updateAccountInfo(accountInfo));
    }

    /**
     * 扣减账户余额
     *
     * @param accountInfo 账户信息实体
     * @return 处理结果
     */
    @PutMapping("/reduce")
    public ResponseEntity<Void> reduceBalance(@RequestBody AccountInfo accountInfo) {
        return ResponseEntity.conditionWithEffectRows(this.accountInfoService.reduceAccountInfoBalance(accountInfo));
    }

    /**
     * 删除一条账户信息
     *
     * @param accountInfoId 账户信息ID
     * @return 处理结果
     */
    @DeleteMapping("/{accountInfoId}")
    public ResponseEntity<Void> delete(@PathVariable("accountInfoId") Long accountInfoId) {
        return ResponseEntity.conditionWithEffectRows(this.accountInfoService.deleteAccountInfoByAccountInfoId(accountInfoId));
    }
}
