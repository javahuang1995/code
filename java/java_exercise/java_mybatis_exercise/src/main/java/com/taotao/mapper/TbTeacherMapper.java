package com.taotao.mapper;

import com.taotao.pojo.TbTeacher;

import java.util.List;

public interface TbTeacherMapper {
	
	/**
	 * 查询的花样是最多的
	 * @param studentID
	 * @return
	 */
	public TbTeacher getTeacher(String id);
	
	public List<TbTeacher> getTeacherAll();
	
	
	/**
	 * 插入，删除，更新。
	 * @param entity
	 */
	public void insertTeacher(TbTeacher entity);
	
	public void deleteTeacher(TbTeacher entity);
	
	public void updateTeacher(TbTeacher entity);
}
