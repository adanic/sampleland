package com.adanik.oauth2.client.example.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author s Khalili
 */
public class UserInfo implements Serializable {
  private String firstName;
  private String lastName;
  private String created;
  private String email;
  private String mobile;
  private String address;
  private List<String> deposits;
  private List<TransactionModel> transactions;

  public List<TransactionModel> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<TransactionModel> transactions) {
    this.transactions = transactions;
  }

  public List<String> getDeposits() {
    return deposits;
  }

  public void setDeposits(List<String> deposits) {
    this.deposits = deposits;
  }

  public String getCreated() {
    return created.substring(0,4) + "/" + created.substring(4,6) + "/" + created.substring(6,8) + " " + created.substring(8,10) + ":" + created.substring(10,12) + ":" + created.substring(12,14);
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
