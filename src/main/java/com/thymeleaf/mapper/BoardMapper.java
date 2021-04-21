package com.thymeleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.thymeleaf.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Select("select * from board order by breg_dt desc")
	List<BoardVO> getAll();

	@Insert("insert into board(bno, bsubject, bname, bcontent, breg_dt) values(s_board.nextval, #{vo.bsubject}, #{vo.bname}, #{vo.bcontent}, sysdate)")
	Integer add(@Param("vo") BoardVO vo);

	@Update("update board set bsubject = #{vo.bsubject}, bcontent = #{vo.bcontent} where bno = #{bno}")
	Integer mod(@Param("vo") BoardVO vo);

	@Delete("delete from board where bno = #{bno}")
	Integer del(@Param("bno") Integer bno);

}