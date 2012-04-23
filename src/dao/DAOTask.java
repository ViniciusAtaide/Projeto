package dao;

import java.util.List;

import model.Task;

public class DAOTask extends DAOJPA<Task> {
	public DAOTask() {
		super();
	}
	//Specific Queries
	@SuppressWarnings("unchecked")
	public List<Task> findByName(String name) {
		return (List<Task>) super.findAllByQuery("select t from Task t where p.name like'" + name +"%' ");
	}
	@SuppressWarnings("unchecked")
	public void deleteByName(String name) {
		List<Task> tasks = super.findAllByQuery("select t from Task t where p.name like'" + name +"%' ");
		for (Task task : tasks) {
			super.remove(task);
		}		
	}
	@SuppressWarnings("unchecked")
	public void updateByName(String name) {
		List<Task> tasks = super.findAllByQuery("select t from Task t where p.done like'" + name +"%' ");
		for (Task task : tasks) {
			super.refresh(task);
		}	
	}
}
