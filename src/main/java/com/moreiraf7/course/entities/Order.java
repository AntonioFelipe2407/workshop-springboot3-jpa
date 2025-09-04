package com.moreiraf7.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moreiraf7.course.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")  // Anotation para renomear a tabela no DB
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private int orderStatus;  //Está como um inteiro apenas internamente na classe, para que o DB entenda que quero guardar um número inteiro

    @ManyToOne // Instrui o JPA para tranformar a associação em chave estrangeira
    @JoinColumn(name = "client_id") // Dando o nome da chave estrangeira no banco de dados
    private User client;


    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);   // Chamando o set que converte o tipo OrderStatus para inteiro
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus); // Chama o metodo que converte o int para OrderStatus
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        /* Recebe um OrderStatus e converte para inteiro
         para que possa ser guardado internamente na classe*/
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
