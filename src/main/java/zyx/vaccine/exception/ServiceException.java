package zyx.vaccine.exception;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException {
    private long code;

    public ServiceException(long code, String msg) {
        super(msg);
        this.code = code;
    }
}
