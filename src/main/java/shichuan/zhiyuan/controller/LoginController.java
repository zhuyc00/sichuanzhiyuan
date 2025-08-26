package shichuan.zhiyuan.controller;

import org.springframework.web.bind.annotation.RestController;
import shichuan.zhiyuan.entity.vo.ResponseVO;

import shichuan.zhiyuan.enums.ResponseCodeEnum;

import shichuan.zhiyuan.exception.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import shichuan.zhiyuan.entity.query.LoginInfo;

@RestController
public class LoginController  extends ABaseController {
    @RequestMapping("/login")
    public ResponseVO Login(@RequestBody LoginInfo info) {
        return getSuccessResponseVO("success");
    }
}