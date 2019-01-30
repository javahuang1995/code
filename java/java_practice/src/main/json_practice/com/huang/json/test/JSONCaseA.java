package com.huang.json.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *   代码中使用的标注分析�?
 * 
 *    @JsonProperty("xxx"):  将当前的属�?名在json字符串中重新命名为当前设置的这个值，比如在示例中，将age-->testa
 *    @JsonIgnore    将被标注的属性在生成json字符串的时�?，直接忽�?   @JsonInclude  是一个类级别的设置，
 * JsonInclude.Include.NON_EMPTY标识只有非NULL的�?才会被纳入json string之中，其余的都被忽略�?
 * 比如这里的location属�?，并没有出现在最终的结果字符串中�?
 * 
 * @author huang
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JSONCaseA {

	@JsonProperty("testa")
	private int age;

	@JsonIgnore
	private String unknownAttr;

	private String location;

	private String city;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUnknownAttr() {
		return unknownAttr;
	}

	public void setUnknownAttr(String unknownAttr) {
		this.unknownAttr = unknownAttr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.age+this.city;
	}

}
