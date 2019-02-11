package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

/**
 * 购物车Controller
 * <p>Title: CartController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月15日下午3:12:59
 * @version 1.0
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	/**
	 * 添加商品到购物车
	 * 有2个地方会用到这里，第一是在商品界面上，添加到购物车，就会刷新整个页面。。跳转到添加购物车成功页面。
	 * 第二是在购物车界面上，调整商品数量的时候，也会到这里，但是是ajax请求，不会刷新整个页面，而是刷新金额。
	 * 我不知道为什么这里要用重定向。。可以防止重复提交。。
	 */
	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable Long itemId, 
			@RequestParam(defaultValue="1")Integer num, 
			HttpServletRequest request, HttpServletResponse response) {
		TaotaoResult result = cartService.addCartItem(itemId, num, request, response);
		return "redirect:/cart/success.html";
	}
	
	/**
	 * 删除购物车里面的一个商品 
	 */
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
		cartService.deleteCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
	
	/**
	 * 添加商品或者删除商品成功之后，重定向到这里，这里跳转到cartSuccess.jsp
	 * 表示添加/删除商品成功。。
	 * @return
	 */
	@RequestMapping("/success")
	public String showSuccess() {
		return "cartSuccess";
	}
	
	/**
	 *这里是展示购物车界面 cart.jsp 展示购物车，点击去购物车结算，到这里。 
	 *购物车界面->核对订单信息->成功提交订单。
	 */
	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CartItem> list = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}
	

	
}
