package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.VO.BookVO;

@Mapper
public interface BookRepository {

	@Delete("""
			TRUNCATE TABLE book
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO book
			SET title = #{title}
			, author = #{author}
			, storeId = #{storeId}
			""")
	void insertBook(String title, String author, int storeId);

	@Select("""
			SELECT * 
			FROM book
			""")
	List<BookVO> selectBookTitle();

	@Select("""
			SELECT *, b.title
			FROM book b
			INNER JOIN bookStore bs
			ON b.storeId = bs.id
			WHERE bs.name = #{storeName};

			""")
	List<BookVO> selectKoreaBook(String storeName);

	@Delete("""
			DELETE FROM book
			WHERE author = #{author}
			""")
	void deleteBook(String author);

}
