package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.VO.BookStoreVO;

@Mapper
public interface BookStoreRepository {

	@Delete("""
			TRUNCATE TABLE bookStore
			""")
	void truncateTable();

	
	@Insert("""
			INSERT INTO bookStore
			SET `name` = #{storeName}
			""")
	void insertBookStore(String storeName);


	@Select("""
			SELECT * 
			FROM bookStore
			""")
	List<BookStoreVO> selectBookStore();


	@Update("""
			UPDATE bookStore
			SET `name` = #{storeName}
			WHERE id = #{id}
			""")
	void modifyBookStore(int id, String storeName);

}
