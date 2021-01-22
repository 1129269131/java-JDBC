package com.tjh.jdbc.jdbcBase.day03;

import java.sql.Date;

/**
 * Create by koala on 2021-01-18
 */
public class Order03 {

    private int orderId;
    private String orderName;
    private Date orderDate;


    public Order03() {
        super();
    }

    public Order03(int orderId, String orderName, Date orderDate) {
        super();
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order03 [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
    }

}
