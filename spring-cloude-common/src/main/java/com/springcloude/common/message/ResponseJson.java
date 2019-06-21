package com.springcloude.common.message;


import com.springcloude.common.plugin.Page;

import java.io.Serializable;

/**
 * @author merlin
 * @create 2017-07-21 上午10:14
 */
public class ResponseJson implements Serializable {

  public static final int SUCCESS = 0;

  private static final long serialVersionUID = 1L;
  private int code = 1100;

  private String msg;

  private Object data = null;


  private long currentPage;

  private long totalPage;


  private long totalResults;
  private long currentTotalResults;


  public ResponseJson() {
  }


  public ResponseJson(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ResponseJson(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public ResponseJson(int code, String msg, Object data, Page page) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    this.totalPage = page.getTotalPage();
    this.currentPage = page.getCurrentPage();
    this.totalResults = page.getCurrentTotalResults();
    this.currentTotalResults=page.getTotalResults();
  }


  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String emsg) {
    this.msg = emsg;
  }

  public Object getData() {
    return data;
  }

  public long getCurrentTotalResults() {
    return currentTotalResults;
  }

  public void setCurrentTotalResults(long currentTotalResults) {
    currentTotalResults = currentTotalResults;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public long getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(long currentPage) {
    this.currentPage = currentPage;
  }

  public long getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(long totalPage) {
    this.totalPage = totalPage;
  }

  public long getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(long totalResults) {
    this.totalResults = totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

}
