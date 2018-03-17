package com.action;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DownloadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//文件路径
	private String path;	 
	//path属性getter方法
	public String getPath() {
		return path;
	}
	//path属性setter方法
	public void setPath(String path) {
		this.path = path;
	}
	//返回inputstream，文件下载关键方法
	public java.io.InputStream getDownloadFile()throws Exception {
	 InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());
	 return in;
	}
	public String execute() throws Exception {
	return SUCCESS;
}

}
