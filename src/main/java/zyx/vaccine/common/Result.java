package zyx.vaccine.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor


@Data
public class Result {

    private long code;
    private String msg;
    private Object data;



    public static Result success(String msg) {
        return new Result(ResultCode.SUCCESS.getCode(), msg, null);
    }

    public static Result success(Object data,String msg) {
        return new Result(ResultCode.SUCCESS.getCode(), msg, data);
    }


    public static Result error(long code, String msg) {
        return new Result(ResultCode.FAILED.getCode(), msg, null);
    }

    public static Result error() {
        return new Result(ResultCode.FAILED.getCode(), "系统错误", null);
    }


    /**
     * 参数验证失败返回结果
     */
    //public static <T> Result<T> validateFailed() {
    //    return error(Constants.CODE_400,"参数验证失败");
   // }

}
