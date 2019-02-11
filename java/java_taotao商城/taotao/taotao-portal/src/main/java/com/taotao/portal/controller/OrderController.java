package com.taotao.portal.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	/**
	 * 上一个页面是购物车页面。 这里进入订单结算页面，使用前需要登录，这里是/order的入口 1.设置收货人信息 2.支付方式 3.送货清单。
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/order-cart")
	public String showOrderCart(HttpServletRequest request, HttpServletResponse response, Model model) {

		String token = UUID.randomUUID().toString();// 创建令牌
		request.getSession().setAttribute("token", token); // 在服务器使用session保存token(令牌)

		// 从Cookie中取购物车商品列表
		List<CartItem> list = cartService.getCartItemList(request, response);
		// 传递给页面
		model.addAttribute("cartList", list);

		return "order-cart";
	}

	/**
	 * 在购物车页面点击确认提交订单，会提交到这里 这里提交订单出现了传说中的重复提交表单问题。。需要解决一下。。
	 * 
	 * @param order
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/create")
	public String createOrder(Order order, Model model, HttpServletRequest request,HttpServletResponse response) {
		try {
			String clientToken = request.getParameter("token");
			String sessionToken = (String) request.getSession().getAttribute("token");
			if (clientToken != null && sessionToken != null && clientToken.equals(sessionToken)) {
				// 从Request中取用户信息
				TbUser user = (TbUser) request.getAttribute("user");
				// 在order对象中补全用户信息
				order.setUserId(user.getId());
				order.setBuyerNick(user.getUsername());
				// 调用服务
				String orderId = orderService.createOrder(order);
				model.addAttribute("orderId", orderId);
				model.addAttribute("payment", order.getPayment());
				model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
				request.getSession().removeAttribute("token");//移除session中的token
				CookieUtils.deleteCookie(request, response, "TT_CART");//删除原来的购物车数据
				return "success";//这里因为要传递订单信息给success.jsp，所以使用的是请求转发。
			} else {
				return "index";// 重复提交，直接让你去首页算了。。
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "创建订单出错。请稍后重试！");
			return "error/exception";
		}
	}

}
