package cn.it.shop.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction {
	private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);

	public String toAdminPage() {
		return "aindex";
	}

}
