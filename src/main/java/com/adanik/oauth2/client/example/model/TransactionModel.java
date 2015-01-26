package com.adanik.oauth2.client.example.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author s Khalili
 */
public class TransactionModel implements Serializable {
  private String amount;
  private String date;
  private String detail;
  private String type;
  private String category;
  private String deposit;
  private List<String> tags;

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDeposit() {
    return deposit;
  }

  public void setDeposit(String deposit) {
    this.deposit = deposit;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getDate() {
    return date.substring(0,4) + "/" + date.substring(4,6) + "/" + date.substring(6,8) + " " + date.substring(8,10) + ":" + date.substring(10,12) + ":" + date.substring(12,14);
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
