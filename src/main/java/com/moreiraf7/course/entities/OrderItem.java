package com.moreiraf7.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moreiraf7.course.entities.pk.OrderItemPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    //CHAVE PRIMÁRIA
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // Sempre que for criar id compostos é necessário instanciar o objeto

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }
    /*
        Ao invés de colocar o id como parâmetro no construtor,
        é colocado o pedido e o produto.

        Para atribuir os parâmetros passados no construtor ao id, é chamado o metodo
        set onde passamos os parâmetros recebidos pelo construtor.
    */
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore // Como essa classe não possui o atributo Order direto, é passado a anotation no get
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
