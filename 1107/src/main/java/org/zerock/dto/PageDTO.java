package org.zerock.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageDTO {
	
	private Integer bno;

	private int page;
	private int amount;
	
	private String keyword;
	private String type;

	public PageDTO(){
		this.page = 1;
		this.amount = 10;
	}

	public int getSkip() {
		return (page - 1) * this.amount;
	}
	
	public String[] getTypes() {
		if(type == null || type.trim().length() == 0)	return null;
		return type.split("");
	}
	
	public String getLink(Integer bno) {
		String result = "";
		
		try {
			result = UriComponentsBuilder.newInstance()
					.encode()
					.queryParam("bno", bno)
					.queryParam("keyword", "서울 종로 종로1가")
					.build()
					.getQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}