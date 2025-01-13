package com.hsbc.antifraud.controller;
import com.hsbc.antifraud.entity.TransInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TransferController.class)
public class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TransInfo transInfo;

    @InjectMocks
    private TransferController transferController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testSubmitTransfer() throws Exception {
        // Mock the TransInfo object
        when(transInfo.getfromAccount()).thenReturn("123456");
        when(transInfo.gettoAccount()).thenReturn("654321");
        when(transInfo.getBalance()).thenReturn("1000");

        // Create a TransInfo object and convert it to JSON
        String transInfoJson = objectMapper.writeValueAsString(transInfo);

        // Perform POST request and validate the response
        mockMvc.perform(post("/transfer/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(transInfoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(1))
                .andExpect(jsonPath("$.message").value("转账操作成功"))
                .andExpect(jsonPath("$.fromAccount").value("123456"))
                .andExpect(jsonPath("$.toAccount").value("654321"))
                .andExpect(jsonPath("$.balance").value(1000.0));

        // Verify the interactions with the mocked TransInfo
        verify(transInfo, times(1)).getfromAccount();
        verify(transInfo, times(1)).gettoAccount();
        verify(transInfo, times(1)).getBalance();
    }
}
