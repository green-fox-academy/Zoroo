package com.greenfox.zoroo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.greenfox.zoroo.ZoroobackendApplication;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZoroobackendApplication.class)
@WebAppConfiguration
public class LoginControllerTest {

  public static final String LOGIN_PARAM_NAME_FOR_USERNAME = "username";
  public static final String LOGIN_PARAM_NAME_FOR_PASSWORD = "password";
  public static final String TEST_USERNAME_CORRECT = "Mully";
  public static final String TEST_PASSWORD_CORRECT = "12345";
  private static final MediaType CONTENT_TYPE_HTML = new MediaType(MediaType.TEXT_HTML.getType(),
      MediaType.TEXT_HTML.getSubtype(),
      Charset.forName("utf8"));
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void getLoginPage_pathWithoutEndingSlash() throws Exception {
    mockMvc.perform(get("/login"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }

  @Test
  public void getLoginPage_pathWithEndingSlash() throws Exception {
    mockMvc.perform(get("/login/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }

  @Test
  public void processLoginForm_pathWithoutEndingSlash() throws Exception {
    mockMvc.perform(post("/login")
        .param(LOGIN_PARAM_NAME_FOR_USERNAME, TEST_USERNAME_CORRECT)
        .param(LOGIN_PARAM_NAME_FOR_PASSWORD, TEST_USERNAME_CORRECT))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }

  @Test
  public void processLoginForm_pathWitEndingSlash() throws Exception {
    mockMvc.perform(post("/login/")
        .param(LOGIN_PARAM_NAME_FOR_USERNAME, TEST_USERNAME_CORRECT)
        .param(LOGIN_PARAM_NAME_FOR_PASSWORD, TEST_USERNAME_CORRECT))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }

  @Test
  public void getRegisterPage_pathWithoutEndingSlash() throws Exception {
    mockMvc.perform(get("/register"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }

  @Test
  public void getRegisterPage_pathWithEndingSlash() throws Exception {
    mockMvc.perform(get("/register/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE_HTML))
        .andDo(print());
  }
}
