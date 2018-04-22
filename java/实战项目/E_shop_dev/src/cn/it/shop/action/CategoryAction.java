package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;


@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6445830341919409852L;

	public String update() {
		System.out.println("----update----");
		System.out.println(categoryService);// �����Ѿ���Spring���ϣ����Կ����õ����categoryService�ˣ���ӡ�����Ͳ���null��
		categoryService.update(model); // �¼�һ����䣬���������ݿ�
		return "index";
	}

	public String save() {
		System.out.println("----save----");
		System.out.println(categoryService);// ����ǰ�������ͬ
		System.out.println(model);
		return "index";
	}

	public String query() {
		// �������һ��������Ӧ��mapȡ��ԭ�������ö���������jspû�����������Ǵ������Ƚϴ�
		// ActionContext.getContext().put("categoryList",
		// categoryService.query()); //�ŵ�request����
		// ActionContext.getContext().getSession().put("categoryList",
		// categoryService.query()); //�ŵ�session����
		// ActionContext.getContext().getApplication().put("categoryList",
		// categoryService.query()); //�ŵ�application����

		// �����������ʵ����Ӧ�Ľӿ�(RequestAware,SessionAware,ApplicationAware)������Ӧ��mapע��
		request.put("categoryList", categoryService.query());
		session.put("categoryList", categoryService.query());
		application.put("categoryList", categoryService.query());
		return "index";
	}
}