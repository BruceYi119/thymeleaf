package com.thymeleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.thymeleaf.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Select({
			"select bno, bsubject, bname, bcontent, breg_dt from (select seq, tt.* from (select rownum seq, t.* from (select * from board order by breg_dt desc) t) tt where seq >= #{start}) where rownum <= #{end}" })
	@Result(property = "bcontent", column = "bcontent", jdbcType = JdbcType.CLOB, javaType = String.class)
	List<BoardVO> getAll(@Param("start") Integer start, @Param("end") Integer end);

	@Select("select * from board where bno = #{bno}")
	@Result(property = "bcontent", column = "bcontent", jdbcType = JdbcType.CLOB, javaType = String.class)
	BoardVO getOne(@Param("bno") Integer bno);

	@Select("select count(*) from board")
	Integer getTotal();

	@Insert("insert into board(bno, bsubject, bname, bcontent, breg_dt) values(s_board.nextval, #{vo.bsubject}, #{vo.bname}, #{vo.bcontent}, sysdate)")
	Integer add(@Param("vo") BoardVO vo);

	@Update("update board set bsubject = #{vo.bsubject}, bcontent = #{vo.bcontent} where bno = #{vo.bno}")
	Integer mod(@Param("vo") BoardVO vo);

	@Delete("delete from board where bno = #{bno}")
	Integer del(@Param("bno") Integer bno);

}