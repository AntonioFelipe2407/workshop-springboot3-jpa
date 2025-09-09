package com.moreiraf7.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    @ManyToMany // Muitos para muitos
    @JoinTable(name = "tb_product_category", // Dando o nome a tabela
            joinColumns = @JoinColumn(name = "product_id"), // Nome da chave estrangeira referente a tabela Product
            inverseJoinColumns = @JoinColumn(name = "category_id")) // Nome da chave estrangeira referente a tabela Category
    private Set<Category> categories = new HashSet<>(); // Utilizei o set para garantir que um produto não tenha a mesma categoria mais de uma vez

    @OneToMany(mappedBy = "id.product") // Instrui o JPA para tranformar a associação em chave estrangeira
    private Set<OrderItem> items = new HashSet<>(); //Coleção de items

    public Product() {
    }

    public Product(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    //get dos pedidos em que contém o produto
    @JsonIgnore // Para que o metodo seja ignorado e não apareça no json
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        // Para cada item x eu adiciono ao set o pedido que contêm o item
        for(OrderItem x : items){
            set.add(x.getOrder());
        }
        return set; // Retorno a coleção com todos os pedidos que contêm o item
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
