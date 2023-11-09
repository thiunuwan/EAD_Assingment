package com.thiunuwan.orderservice.service;

import jakarta.annotation.PostConstruct;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Service
public class StripeService {
    @PostConstruct
    public void init() {
//        Stripe.apiKey = System.getenv("STRIPE_SECRET_KEY");
        Stripe.apiKey="sk_test_51NHa3qSHQTfZ29uMx21oWuZHx3WP2bZ5mNjuWioXr1ShiGjeKCAypZ7KBvMdm87v6BAo65Jmda8YGzeVM07rNgkP00Iav4poZM";
    }

    public PaymentIntent createPaymentIntent(long amount) throws StripeException {
        return PaymentIntent.create(new HashMap<String, Object>() {{
            put("amount", Math.round(amount * 100));
            put("currency", "INR");
            put("payment_method_types", new String[]{"card"});
//            put("metadata", Map.of("name", amount));
        }});
    }
}
