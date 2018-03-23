package net.n1books.dev.file;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("file")
public class FileController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FileController.class);
	
	@Value("${upload.dir}")
	private String uploadUrl;
	
	//GET을 따로 지정해둬서 보안성 유지?
	@RequestMapping(value="upload", method=RequestMethod.GET)
	public void upload() {}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public ModelAndView upload(FileUploadCommand fuc) throws IOException {
		CommonsMultipartFile cmf = fuc.getUpFile(); //CMF wraps the file thats going to be uploaded
		long fileSize = cmf.getSize();
		String originalName = cmf.getOriginalFilename();
		
		logger.info("upload file type : " + cmf.getContentType());
		boolean isImage = cmf.getContentType().substring(0,5).toLowerCase().equals("image");
		boolean isAudio = cmf.getContentType().substring(0,5).toLowerCase().equals("audio");
		
		File file = new File(uploadUrl, originalName);
		try {
			cmf.transferTo(file); //Transfer the given file to CMF destination file
		} catch (FileNotFoundException e) {
			System.out.println("업로드 디렉토리가 없을걸? : " + e.getMessage());
			try {
				new File(uploadUrl).mkdirs();
				cmf.transferTo(file);
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isImage) {
				createThumbnailImage(originalName);
			}
		}
		ModelAndView mav = new ModelAndView("file/upload_action");
		mav.addObject("fileSize", fileSize);
		mav.addObject("originalName", originalName);
		mav.addObject("isImage", isImage);
		mav.addObject("isAudio", isAudio);
		return mav;
	}
	
	//이미지 크기를 줄여서 텀네일화 해줍니다
	public void createThumbnailImage(String originalName) throws IOException {
		logger.info("createThumbnailImage()");
		String ext = originalName.substring(originalName.lastIndexOf(".") + 1);
		ParameterBlock pb = new ParameterBlock();
		pb.add(uploadUrl + "/" + originalName);
		RenderedOp rOp = JAI.create("fileload", pb);
		BufferedImage bi = rOp.getAsBufferedImage();
		BufferedImage thumb = 
				new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = thumb.createGraphics();
		g.drawImage(bi,  0, 0, 100, 100, null);
		File file = new File(uploadUrl + "/thumb_" + originalName);
		ImageIO.write(thumb,  ext,  file);
	}
	
	@RequestMapping("download")
	public void download(
			String fileName, HttpServletResponse response) throws IOException{
	
		File file = new File(uploadUrl, fileName);
		response.setContentType("application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader(
				"Content-Disposition", "attachent; fileName=\"" +
				URLEncoder.encode(fileName,"UTF-8") + "\"");
		
		InputStream is = null; //Set up inputstream and outputstream to download!
		OutputStream os = response.getOutputStream();
		
		is = new FileInputStream(file);
		FileCopyUtils.copy(is, os);
		try {
			is.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
