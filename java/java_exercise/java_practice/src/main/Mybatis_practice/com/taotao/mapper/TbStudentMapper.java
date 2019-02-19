package com.taotao.mapper;

import java.util.List;
import java.util.Map;

import com.taotao.pojo.TbStudent;

public interface TbStudentMapper {
	
	/**
	 * 查询的花样是最多的
	 * @param studentID
	 * @return
	 */
	public TbStudent getStudent(String studentID);
	public TbStudent getStudentByName(String name);
	
	public TbStudent getStudentAndClass(String studentID);
	
	public List<TbStudent> getStudentAll();
	
	public List<TbStudent> getStudentByMap(Map<String,Object> param);
	
	/**
	 * 插入，删除，更新。
	 * @param entity
	 */
	public void insertStudent(TbStudent entity);
	
	public void deleteStudent(TbStudent entity);
	
	public void updateStudent(TbStudent entity);
}
