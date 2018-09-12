package models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
public class ItemBeanManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemBeanManager.class);
	
	@Inject
	private ItemBean itemBean;
	
	private String newItemDescription;
	private Integer idCount = 0;
	private List<ItemBean> items;
	
	public ItemBeanManager() {
	}
	
	@PostConstruct
	public void init() {
		items = new ArrayList<ItemBean>();
		ItemBean task1 = new ItemBean(idCount, "nouvelle tache pour affichage", true);
		items.add(task1);
	}
	
	public List<ItemBean> getItems(){
		return items;
	}
	
	public String createItem() {
		ItemBean newItem = new ItemBean(idCount, newItemDescription, true);
		idCount=idCount++;
		items.add(newItem);
		LOGGER.info("newItemDescription = "+ newItemDescription);
		LOGGER.info("nouvelle tache : " + newItem);
		clear();
		return "#";
	}
	
	private String deleteItem(Integer index) {
		items.remove(index);
		return "#";
	}
	
	private String updateItem(Integer index, String newDescription) {
		items.get(index).setDescription(newDescription);
		return "#";
	}
	
	private String changeStatus(Integer index) {
		items.get(index).setTodo(!itemBean.isTodo());
		return "#";
	}

	private void clear() {
		itemBean.setDescription(null);
	}
	
	public String getNewItemDescription() {
		return newItemDescription;
	}
	
	public void setNewItemDescription(String newItemDescription) {
		this.newItemDescription = newItemDescription;
	}
	
}
