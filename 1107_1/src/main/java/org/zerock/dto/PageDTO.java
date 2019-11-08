package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageDTO {
	
	private int page, amount;
	
	public PageDTO() {
		this.page = 1;
		this.amount = 10;
	}

}
