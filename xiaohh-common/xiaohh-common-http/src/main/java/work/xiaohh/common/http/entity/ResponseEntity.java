package work.xiaohh.common.http.entity;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:08:45
 * @file ResponseEntity.java
 */
public class ResponseEntity<T> implements Serializable {
    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 返回的消息
     */
    private String message;

    /**
     * 返回时服务器的时间戳
     */
    private Long timestamp;

    /**
     * 无参构造，设置时间戳
     */
    public ResponseEntity() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 除了时间戳以外的全参构造
     *
     * @param code    响应编码
     * @param data    返回的数据
     * @param message 返回的消息
     */
    public ResponseEntity(Integer code, T data, String message) {
        this();
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 获取成功响应实体
     *
     * @param <T> 响应数据类型，调用此方法的时候响应数据为空
     * @return 成功响应实体
     */
    public static <T> ResponseEntity<T> success() {
        return success(null);
    }

    /**
     * 获取成功响应实体
     *
     * @param data 响应的数据体
     * @param <T>  响应数据类型
     * @return 成功响应实体
     */
    public static <T> ResponseEntity<T> success(T data) {
        // HttpStatus.OK.value() = 200
        return new ResponseEntity<>(HttpStatus.OK.value(), data, "操作成功");
    }

    /**
     * 获取失败响应实体
     *
     * @param <T> 响应数据类型，调用此方法的时候响应数据为空
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed() {
        // HttpStatus.INTERNAL_SERVER_ERROR.value() = 500
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "操作失败");
    }

    /**
     * 获取失败响应实体
     *
     * @param data 响应的数据体
     * @param <T>  响应数据类型
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed(T data) {
        // HttpStatus.INTERNAL_SERVER_ERROR.value() = 500
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), data, "操作失败");
    }

    /**
     * 获取失败响应实体
     *
     * @param code 响应编码
     * @param <T>  响应数据类型，调用此方法的时候响应数据为空
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed(Integer code) {
        return new ResponseEntity<>(code, null, "操作失败");
    }

    /**
     * 获取失败响应实体
     *
     * @param message 响应编码
     * @param <T>     响应数据类型，调用此方法的时候响应数据为空
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed(String message) {
        // HttpStatus.INTERNAL_SERVER_ERROR.value() = 500
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, message);
    }

    /**
     * 获取失败响应实体
     *
     * @param code    响应编码
     * @param message 响应编码
     * @param <T>     响应数据类型，调用此方法的时候响应数据为空
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed(Integer code, String message) {
        return new ResponseEntity<>(code, null, message);
    }

    /**
     * 获取失败响应实体
     *
     * @param code    响应编码
     * @param data    响应的数据体
     * @param message 响应编码
     * @param <T>     响应数据类型
     * @return 失败响应实体
     */
    public static <T> ResponseEntity<T> failed(Integer code, T data, String message) {
        return new ResponseEntity<>(code, data, message);
    }

    /**
     * 根据受影响行数判断返回成功还是失败
     *
     * @param effectRows 受影响行数
     * @param <T>        响应数据类型，调用此方法的时候响应数据为空
     * @return 判断结果
     */
    public static <T> ResponseEntity<T> conditionWithEffectRows(int effectRows) {
        return effectRows > 0 ? success() : failed();
    }

    public Integer getCode() {
        return code;
    }

    public ResponseEntity<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEntity<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
