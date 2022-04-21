package cn.limitless.separationoffrontandbackends.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@AllArgsConstructor
@Getter
public enum ExceptionType {

    /**
     * 枚举运行时状态
     */
    INNER_ERROR(500, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    NAME_PASS_ERROR(500101, "账号或密码错误"),
    FORBIDDEN(403, "无权操作"),
    CHECK_ERROR(500030, "校验错误"),
    NOT_FOUND(404, "未找到");


    private final Integer code;

    private final String message;

}
