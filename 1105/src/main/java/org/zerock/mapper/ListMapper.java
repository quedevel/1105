package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ListMapper<E> {
	
	public List<E> selectList(@Param("page") int page, @Param("amount") int amount);
	
}
