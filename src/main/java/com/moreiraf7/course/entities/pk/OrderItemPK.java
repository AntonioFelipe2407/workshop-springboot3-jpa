package com.moreiraf7.course.entities.pk;

import com.moreiraf7.course.entities.Order;
import com.moreiraf7.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable //...
public class OrderItemPK implements Serializable {

    // REFERÊNCIA PARA O PRODUTO E O PEDIDO
    @ManyToOne
    @JoinColumn(name = "order_id") // Nome da chave estrangeira na tabela referente a tabela Order
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id") // Nome da chave estrangeira na tabela referente a tabela Product
    private Product product;

    /*ESSA CLASSE EM ESPECIAL NÃO IRÁ POSSUIR CONSTRUTORES */


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
