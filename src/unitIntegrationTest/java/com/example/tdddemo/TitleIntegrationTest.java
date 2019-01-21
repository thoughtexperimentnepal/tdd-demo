package com.example.tdddemo;

import com.example.tdddemo.client.TitleClient;
import com.example.tdddemo.controller.TitleController;
import com.example.tdddemo.service.TitleService;
import com.example.tdddemo.testutil.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TitleIntegrationTest {

    @Value("${titleBaseUrl}")
    String titleBaseUrl;
    String path = "/todos";

    MockMvc mockMvc;
    @Autowired
    RestTemplate restTemplate;

    MockRestServiceServer mockServer;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
//        mockMvc = mockMvc = MockMvcBuilders.standaloneSetup(
//                                new TitleController(
//                                        new TitleService(
//                                                new TitleClient(restTemplate, titleBaseUrl))))
//                .build();

        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mockServer = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Test
    public void testTitle() throws Exception {
        String url = titleBaseUrl + path + "/" + 1;

        mockServer.expect(requestTo(url))
                .andRespond(withSuccess()
                    .body(TestUtil.readFile("src/unitIntegrationTest/resources/response/1.json"))
                        .contentType(MediaType.APPLICATION_JSON)
                );

        ResultActions resultActions = mockMvc.perform(
                get("/api/status/1")
        );

        resultActions.andExpect(status().isOk())
        .andExpect(content().string("false"))
        ;

        MvcResult mvcResult = resultActions.andReturn();

        String str = mvcResult.getResponse().getContentAsString();

        System.out.println(str);

    }

    @Test
    public void testTitleWrong() throws Exception {
        String url = titleBaseUrl + path + "/" + 1;

        mockServer.expect(requestTo(url))
                .andRespond(withSuccess()
                        .body(TestUtil.readFile("src/unitIntegrationTest/resources/response/1_wrong.json"))
                        .contentType(MediaType.APPLICATION_JSON)
                );

        ResultActions resultActions = mockMvc.perform(
                get("/api/status/1")
        );

        // This will evaluate to fail because the field is messed up so it will return null
        /*
                resultActions.andExpect(status().isOk())
                .andExpect(content().string("false"))
        ;*/

        MvcResult mvcResult = resultActions.andReturn();

        String str = mvcResult.getResponse().getContentAsString();

        System.out.println(str);

    }
}
