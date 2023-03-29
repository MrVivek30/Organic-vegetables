package com.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organic.exception.OrderNotFoundException;
import com.organic.model.Order;
import com.organic.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addorder")
	public ResponseEntity<Order> addOrderHandler(@RequestBody Order order) {
		Order order2=orderService.addOrder(order);
		
		return new ResponseEntity<>(order2,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewOrder/{orderNo}")
	public ResponseEntity<Order>  viewOrderHandler(@PathVariable Integer orderNo) {
		Order order=orderService.viewOrder(orderNo);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<Order>  updateOrderDetailsHandler(@RequestBody Order order){
		Order order2=orderService.updateOrderDetails(order);
		return new ResponseEntity<>(order2,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewAll/{customerId}")
	public ResponseEntity<List<Order>>viewAllOrdersHandler(@PathVariable Integer customerId){
		
		List<Order>list=orderService.viewAllOrders(customerId);
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
//	public List<Order>viewAllOrdersByDate(LocalDate date)throws OrderNotFoundException;
	
	@GetMapping("/viewOrderList")
	public ResponseEntity<List<Order>>viewOrderListHandler(){
		List<Order>list=orderService.viewOrderList();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelOrder/{orderNo}")
	public ResponseEntity<Order>  cancelOrderHandler(@PathVariable Integer orderNo) {
	
	Order order=orderService.cancelOrder(orderNo);
	
	return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	
}
