package com.springcloud.server1.controller.base;

import com.springcloude.common.message.ResponseJson;
import com.springcloude.common.message.ResponseOAJson;
import com.springcloude.common.plugin.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BaseController {

  @Autowired
  private MessageSource messageSource;

  protected Logger logger = LoggerFactory.getLogger(BaseController.class);

  public ResponseJson responseMsg(int code) {
    return new ResponseJson(code, MSG(code));
  }

  public ResponseJson responseMsg(int code, String msg) {
    return new ResponseJson(code, msg);
  }

  public ResponseOAJson responseOAJson(int msgCode, String msg){
    return new ResponseOAJson(msgCode,msg);
  }

  public ResponseJson responseMsg(int code, Object data) {
    return new ResponseJson(code, MSG(code), data);
  }

  public ResponseJson responseMsg(int code, Object data, Page page) {
    return new ResponseJson(code, MSG(code), data,page);

  }

  public String MSG(int key) {
    Locale currentLocale = LocaleContextHolder.getLocale();
    return messageSource.getMessage("responseMsg.map." + key, null, currentLocale);
  }

  /**
   * 实体校验跳转到错误页面
   */
  public String showErrorPage(Model model, BindingResult result) {
    List<FieldError> list = result.getFieldErrors();
    List<String> errors = new ArrayList<String>();
    for (int i = 0; i < list.size(); i++) {
      FieldError fieldError = list.get(i);
      errors.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
    }

    model.addAttribute("errors", errors);
    return "error_message";
  }

  public ResponseJson showErrorJson(BindingResult result) {

    FieldError error = result.getFieldErrors().get(0);

    return new ResponseJson(1016, error.getField() + ":" + error.getDefaultMessage());

  }

}
