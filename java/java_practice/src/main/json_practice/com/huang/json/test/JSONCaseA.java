package com.huang.json.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 听 浠ｇ爜涓娇鐢ㄧ殑镙囨敞鍒嗘瀽锛?
 * 
 * 听听 @JsonProperty("xxx"):听 灏嗗綋鍓岖殑灞炴?鍚嶅湪json瀛楃涓蹭腑閲嶆柊锻藉悕涓哄綋鍓嶈缃殑杩欎釜链硷紝姣斿鍦ㄧず渚嬩腑锛屽皢age-->testa
 * 听听 @JsonIgnore听听听 灏呜镙囨敞镄勫睘镐у湪鐢熸垚json瀛楃涓茬殑镞跺?锛岀洿鎺ュ拷鐣?听听 @JsonInclude听 鏄竴涓被绾у埆镄勮缃紝
 * JsonInclude.Include.NON_EMPTY镙囱瘑鍙湁闱濶ULL镄勫?镓崭细琚撼鍏son string涔嬩腑锛屽叾浣欑殑閮借蹇界暐锛?
 * 姣斿杩欓噷镄刲ocation灞炴?锛屽苟娌℃湁鍑虹幇鍦ㄦ渶缁堢殑缁撴灉瀛楃涓蹭腑銆?
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
