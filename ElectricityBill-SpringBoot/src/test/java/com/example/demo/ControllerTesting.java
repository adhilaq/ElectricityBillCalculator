package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.controllers.AdminController;
import com.example.demo.controllers.ConsumerController;
import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Rate;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.repos.RateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = AdminController.class)
public class ControllerTesting 
{ 
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private ConsumerController consumerController;
  
  @MockBean
  private AdminController adminController;
  
  @MockBean
  ConsumerRepository consumerRepository;
  
  @MockBean
  BillRepository billRepository;
  
  @MockBean
  RateRepository rateRepository;
  
  
  ObjectMapper mapToJson = new ObjectMapper();

  


  @Test
  public void getAllConsumers() throws Exception 
  {
	  Rate r1 = new Rate("Domestic", 2);
	  r1.setRateId(1);
      Consumer c1 = new Consumer("Adhil", "Kochi", "Eloor", r1, "test", "adhilaq@gmail.com");
      c1.setConsumerId(1);
      
      Bill b1 = new Bill(2022, 12, 200, 400, c1);
      b1.setBillId(1);
      Bill b2 = new Bill(2022, 11, 300, 600, c1);
      b2.setBillId(2);
      Bill b3 = new Bill(2022, 10, 400, 800, c1);
      b3.setBillId(3);
      
      List<Bill> billList  = List.of(b1, b2, b3);
 
	  when(adminController.getAllConsumerBill()).thenReturn(billList); 
	  
	  this.mockMvc.perform(get("/consumers")).andExpect(status().isOk())
        .andDo(print());
  }
 
  @Test
  public void getConsumerBillByCityTest() throws Exception 
  {
	  Rate r1 = new Rate("Domestic", 2);
	  r1.setRateId(1);
      Consumer c1 = new Consumer("Adhil", "Kochi", "Eloor", r1,"test", "adhilaq@gmail.com");
      c1.setConsumerId(1);
      
      Consumer c2 = new Consumer("Pavan", "Chennai", "Nungambakkam", r1,"test", "pavan@gmail.com");
      c2.setConsumerId(2);
      
      Bill b1 = new Bill(2022, 12, 200, 400, c1);
      b1.setBillId(1);
      Bill b2 = new Bill(2022, 11, 300, 600, c1);
      b2.setBillId(2);
      Bill b3 = new Bill(2022, 10, 400, 800, c2);
      b3.setBillId(3);
      
      List<Bill> billList  = List.of(b3);
      
	  when(adminController.getConsumerBillByCity("Chennai")).thenReturn(billList); 
      MvcResult result = this.mockMvc.perform(get("/consumers/city")
			  .param("city", "Chennai"))
	  .andExpect(status().isOk())
        .andReturn();
      
      String expectedJson = this.mapToJson.writeValueAsString(billList);
      String outputJson = result.getResponse().getContentAsString();
      assertThat(outputJson).isEqualTo(expectedJson);
      
  }
  
  @Test
  public void getConsumerBillByAreaTest() throws Exception 
  {
	  Rate r1 = new Rate("Domestic", 2);
	  r1.setRateId(1);
      Consumer c1 = new Consumer("Adhil", "Kochi", "Eloor", r1,"test", "adhilaq@gmail.com");
      c1.setConsumerId(1);
      
      Consumer c2 = new Consumer("Pavan", "Chennai", "Nungambakkam", r1,"test", "pavan@gmail.com");
      c2.setConsumerId(2);
      
      Bill b1 = new Bill(2022, 12, 200, 400, c1);
      b1.setBillId(1);
      Bill b2 = new Bill(2022, 11, 300, 600, c1);
      b2.setBillId(2);
      Bill b3 = new Bill(2022, 10, 400, 800, c2);
      b3.setBillId(3);
      
      List<Bill> billList  = new ArrayList<Bill>();
      billList.add(b1);
//      billList.add(b2);
      
	  when(adminController.getConsumerBillByArea("Eloor")).thenReturn(billList); 
      MvcResult result = this.mockMvc.perform(get("/consumers/area")
			  .param("area", "Eloor"))
	  .andExpect(status().isOk())
        .andReturn();
      
      String expectedJson = this.mapToJson.writeValueAsString(billList);
      String outputJson = result.getResponse().getContentAsString();
      assertThat(outputJson).isEqualTo(expectedJson);
      
  }
  
  @Test
  public void getConsumerBillByYearAndMonthTest() throws Exception 
  {
	  Rate r1 = new Rate("Domestic", 2);
	  r1.setRateId(1);
      Consumer c1 = new Consumer("Adhil", "Kochi", "Eloor", r1,"test", "adhilaq@gmail.com");
      c1.setConsumerId(1);
      
      Consumer c2 = new Consumer("Pavan", "Chennai", "Nungambakkam", r1,"test", "pavan@gmail.com");
      c2.setConsumerId(2);
      
      Bill b1 = new Bill(2022, 12, 200, 400, c1);
      b1.setBillId(1);
      Bill b2 = new Bill(2022, 11, 300, 600, c1);
      b2.setBillId(2);
      Bill b3 = new Bill(2022, 10, 400, 800, c2);
      b3.setBillId(3);
      
      List<Bill> billList  = new ArrayList<Bill>();
      billList.add(b1);
      
	  when(adminController.getConsumerBillByYearAndMonth(2022, 12)).thenReturn(billList); 
      MvcResult result = this.mockMvc.perform(get("/consumers/date")
			  .param("year", "2022").param("month", "12"))
	  .andExpect(status().isOk())
        .andReturn();
      
      String expectedJson = this.mapToJson.writeValueAsString(billList);
      String outputJson = result.getResponse().getContentAsString();
      assertThat(outputJson).isEqualTo(expectedJson);
      
  }
  



  
  
}