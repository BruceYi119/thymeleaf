package com.thymeleaf.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private Integer bno;
	private String bsubject, bname, bcontent;
	private Date breg_dt;
}