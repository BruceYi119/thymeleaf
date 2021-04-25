package com.thymeleaf.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.thymeleaf.mapper.BoardMapper;
import com.thymeleaf.vo.BoardVO;

@Controller
public class Test {

	@Autowired
	private BoardMapper boardMapper;

	@RequestMapping("/test/re")
	public String re(RedirectAttributes rediAttributes) {
		rediAttributes.addFlashAttribute("vo", boardMapper.getOne(24));
		System.out.println("1");
		return "redirect:/test/redir";
	}

	@RequestMapping("/test/redir")
	public void redir(HttpServletRequest request) {
		BoardVO vo = null;
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);

		if (flashMap != null)
			vo = (BoardVO) flashMap.get("vo");

		System.out.println("2");
		System.out.println(vo);
	}

	@RequestMapping("/test")
	public void test() throws IOException {
//		String home = System.getProperty("user.home");
//		String dir = System.getProperty("user.dir");
	}

//	public static void main(String[] args) throws IOException {
//		String dir = System.getProperty("user.dir");
//		String baseDir = dir + "/src/main/resources/";
////		String fname = "application.properties";
//		String fname = "test.txt";
//		String wBaseDir = dir + "/test/cert/";
//		String wFname = "test.properties";
//
//		Path p = Paths.get(wBaseDir);
//
//		if (!Files.isDirectory(p))
//			Files.createDirectories(p);
//
////		Files.readString(Paths.get(baseDir, fname), StandardCharsets.ISO_8859_1)
//
////		Files.write(Paths.get(wBaseDir, wFname),
////				StandardCharsets.UTF_8.decode(null),
////				StandardOpenOption.CREATE);
//
////		FileChannel fc = FileChannel.open(Paths.get(baseDir, fname), StandardOpenOption.READ);
////		ByteBuffer bb = ByteBuffer.allocate((int) fc.size());
//
////		fc.read(bb);
////		bb.flip();
//
////		Files.write(Paths.get(wBaseDir, wFname),
////				StandardCharsets.UTF_8.decode(bb).toString().getBytes(StandardCharsets.UTF_8),
////				StandardOpenOption.CREATE);
//	}

}