package models;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class ItemBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private boolean todo;
	
	public ItemBean(Integer id, String description, boolean todo) {
		this.id = id;
		this.description = description;
		this.todo = todo;
	}
	
	public ItemBean() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "ItemBean [description=" + description + "]";
	}
	
	
	
}
