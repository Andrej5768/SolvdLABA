package com.solvd.onlineStore.service.delivery;

import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import com.solvd.onlineStore.enums.OrderStatus;
import com.solvd.onlineStore.users.User;

public class Delivery implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Delivery.class);

    private Date deliveryDate;

    private Order order;

    private String addresse; //отримувач

    //thread
    private final Courier courier1 = new Courier();

    private final Courier courier2 = new Courier();

    public Delivery() {
    }

    public Delivery(Order order, User owner) {
        this.order = order;
        this.addresse = owner.getLogin();

        //Плюс 3 дня на доставку з часу замовлення
        Calendar c = Calendar.getInstance();
        c.setTime(order.getDate());
        c.add(Calendar.DAY_OF_MONTH, 3);
        this.deliveryDate = c.getTime();
        this.order.setStatus(OrderStatus.PROGRESS);
        LOGGER.info("Order in progress");
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
        LOGGER.info("Order delivered");
    }

    public void doDelivery1() {
        synchronized (courier1) {
            LOGGER.info("Courier take order");
            synchronized (courier2) {
                LOGGER.info("Courier give order");
            }
        }
    }

    public void doDelivery2() {
        synchronized (courier2) {
            LOGGER.info("Courier take order");
            synchronized (courier1) {
                LOGGER.info("Courier give order");
            }
        }
    }

    @Override
    public void run() {
        doDelivery1();
        doDelivery2();
    }
}
