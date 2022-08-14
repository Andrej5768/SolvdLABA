package com.solvd.onlineStore.service.delivery;

import com.solvd.onlineStore.enums.OrderStatus;
import com.solvd.onlineStore.users.User;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

public class Delivery {

    public static final Logger logger = Logger.getLogger(Delivery.class);

    private Date deliveryDate;

    private final Order order;

    private final String addresse; //отримувач

    public Delivery(Order order, User owner) {
        this.order = order;
        this.addresse = owner.getLogin();

        //Плюс 3 дня на доставку з часу замовлення
        Calendar c = Calendar.getInstance();
        c.setTime(order.getDate());
        c.add(Calendar.DAY_OF_MONTH, 3);
        this.deliveryDate = c.getTime();
        this.order.setStatus(OrderStatus.PROGRESS);
        logger.info("Order in progress");
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        //доставка не швидше 2 днів
        if (deliveryDate.getTime() + 172800000 >= order.getDate().getTime()) {
            this.deliveryDate = deliveryDate;
        }
    }

    public Order getOrder() {
        return order;
    }

    public String getAddresse() {
        return addresse;
    }

    public void delivered() {
        this.order.setStatus(OrderStatus.COMPLITE);
        logger.info("Order delivered");
    }

}
