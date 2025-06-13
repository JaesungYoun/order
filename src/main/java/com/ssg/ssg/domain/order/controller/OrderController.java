package com.ssg.ssg.domain.order.controller;

import com.ssg.ssg.domain.order.dto.request.CancelOrderItemRequest;
import com.ssg.ssg.domain.order.dto.request.CreateOrderRequest;
import com.ssg.ssg.domain.order.dto.response.CancelOrderItemResponse;
import com.ssg.ssg.domain.order.dto.response.CreateOrderResponse;
import com.ssg.ssg.domain.order.dto.response.GetOrderResponse;
import com.ssg.ssg.domain.order.facade.OrderServiceFacade;
import com.ssg.ssg.domain.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController implements OrderControllerDoc {

    private final OrderService orderService;
    private final OrderServiceFacade orderServiceFacade;

    @Override
    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @PostMapping("/{orderId}/cancel/{itemId}")
    public ResponseEntity<CancelOrderItemResponse> cancelOrderItem(@RequestBody @Valid CancelOrderItemRequest request) throws InterruptedException {
        return ResponseEntity.ok(orderServiceFacade.cancelOrderItem(request));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
}


