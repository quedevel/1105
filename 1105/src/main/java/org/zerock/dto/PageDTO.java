package org.zerock.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class PageDTO {
	private int page, amount;
	private String keyword;
	private String type;
	
	public PageDTO() {
		this.page = 1;
		this.amount = 10;
	}
	// mybatis는 get메서드와 set메서드를 따진다.
	// mybatis는 메서드 위주로 진행되어 page 로 해도 #{skip} 에서 getSkip()을 가져온다
	
	public int getSkip() {
		log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaGETSKIPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		return (this.page-1) * this.amount;
	}
	
	public String[] getTypes() {
		log.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbGETTYPESSSSSSSSSSSSSSSSSSSSSSSSSSS");
		String[] arr = this.type.split("");
		return arr;
	}
	
}
