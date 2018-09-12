package front;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import models.ItemBean;
import models.ItemBeanManager;

@Named
public class DynamicsBean {

	@Inject
	private ItemBeanManager itemBeanManager;
	
	@Inject
	private ItemBean itemBean;
	
	public DynamicsBean() {
		
	}
	
	public String listStatus() {
		List<ItemBean> list = itemBeanManager.getItems();
		if(list.isEmpty()) {
			return null;
		} else {
			return "assets/images/arrow.png";
		}
	}
	
	public String tickStatus() {
		if (itemBean.isTodo()) {
			return "assets/images/tick-todo.png";
		} else {
			return "assets/images/tick-done.png";
		}
	}
	
	public void selectAll() {
		
	}
	
}
