package com.khipu.auth;

import com.khipu.Pair;
import com.khipu.ApiClient;

import java.util.Map;
import java.util.List;

import java.io.UnsupportedEncodingException;
import javax.xml.bind.DatatypeConverter;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T12:32:42.192-03:00")
public class HttpBasicAuth implements Authentication {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void applyToParams(ApiClient apiClient, String basePath, String path, String method, List<Pair> queryParams, Map<String, String> headerParams, Map<String, Object> formParams) {
    String str = (username == null ? "" : username) + ":" + (password == null ? "" : password);
    try {
      headerParams.put("Authorization", "Basic " + DatatypeConverter.printBase64Binary(str.getBytes("UTF-8")));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
