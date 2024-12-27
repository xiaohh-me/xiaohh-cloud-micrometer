package work.xiaohh.common.http.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import work.xiaohh.common.http.entity.ResponseEntity;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:10:46
 * @file GlobalExceptionHandler.java
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 日志记录
     */
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 捕捉所有异常
     *
     * @param e 异常实体
     * @return 统一的异常返回
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Void> handleThrowable(Throwable e) {
        log.error("系统发生未知异常", e);
        return ResponseEntity.failed(e.getCause().getMessage());
    }
}
