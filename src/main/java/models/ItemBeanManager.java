package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@SessionScoped
public class ItemBeanManager implements Serializable{

	private static final long serialVersionUID = 1L;

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
	
	public void createItem(AjaxBehaviorEvent event) throws AbortProcessingException {
		LOGGER.info("on est dans le create");
//		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//			LOGGER.info("newItemDescription = "+ newItemDescription);
//			ItemBean newItem = new ItemBean(idCount, newItemDescription, true);
//			idCount=idCount++;
//			items.add(newItem);
//			LOGGER.info("nouvelle tache : " + newItem);			
//		}
	}
	
//	private String deleteItem() {
//		int index = items.indexOf(itemBean);
//		items.remove(index);
//		return "#";
//	}
//
//	private void clear() {
//		setNewItemDescription(null);
//	}
	
	public String getNewItemDescription() {
		return newItemDescription;
	}
	
	public void setNewItemDescription(String newItemDescription) {
		this.newItemDescription = newItemDescription;
	}
	
}
