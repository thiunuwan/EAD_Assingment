package com.thiunuwan.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "shopping_cart_id")
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;

    private int userId;
    private double total;


    //Warning
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "shoppingCart")
    private List<ShoppingCartItems> shoppingCartItems=new ArrayList<>();


}
