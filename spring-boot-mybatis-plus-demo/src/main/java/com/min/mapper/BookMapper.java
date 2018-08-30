package com.min.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.min.entity.Book;
@Mapper
public interface BookMapper extends BaseMapper<Book>{
	
}
