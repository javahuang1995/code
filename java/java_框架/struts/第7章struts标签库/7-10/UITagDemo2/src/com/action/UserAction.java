package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//����characters
	private String[] characters;
	//����interests
	private String[] interests;
	//characters��interests���Ե�getter��setter����
	public String[] getCharacters() {
		return characters;
	}
	public void setCharacters(String[] characters) {
		this.characters = characters;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
