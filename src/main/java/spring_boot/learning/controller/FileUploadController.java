package spring_boot.learning.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
* @author DexterPoker
* @date 2017年1月23日-上午9:09:03
**/
@RestController
@RequestMapping("/file")
public class FileUploadController {

		@RequestMapping(value = "/upload", method = RequestMethod.POST)
		public Map<String,String> upload(@RequestParam("file") MultipartFile file){
			Map<String, String> ret = new HashMap<>();
			if(!file.isEmpty()){
				BufferedOutputStream out;
				try {
					FileOutputStream fileOutSteam = new FileOutputStream(file.getOriginalFilename());
					out =  new BufferedOutputStream(fileOutSteam);
		            out.write(file.getBytes());
		            out.flush();
		            out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					ret.put("respCode", "2001");
					ret.put("respDesc", e.getMessage());
					return ret;
					
				} catch (IOException e) {
					e.printStackTrace();
					ret.put("respCode", "2001");
					ret.put("respDesc", e.getMessage());
					return ret;
				}
				ret.put("respCode", "0000");
				ret.put("respDesc", "上传成功");
				return ret;
			}
			else{
				ret.put("respCode", "2002");
				ret.put("respDesc", "文件为空");
				return ret;
			}
		}
	
		@RequestMapping(value = "/batchUpload",method = RequestMethod.POST)
		public Map<String,String> batchUpload(HttpServletRequest request){
			Map<String, String> ret = new HashMap<>();
			List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
			MultipartFile file = null;
			BufferedOutputStream outSteam = null;
			for(int i = 0; i < files.size(); i++ ){
				file = files.get(i);
				if(!file.isEmpty()){
					FileOutputStream fileOutSteam;
					try {
						fileOutSteam = new FileOutputStream(file.getOriginalFilename());
						outSteam =  new BufferedOutputStream(fileOutSteam);
						outSteam.write(file.getBytes());
						outSteam.flush();
						outSteam.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						ret.put("respCode", "2001");
						ret.put("respDesc", "文件" + i + "失败，" + e.getMessage());
						return ret;
					} catch (IOException e) {
						e.printStackTrace();
						ret.put("respCode", "2001");
						ret.put("respDesc", "文件" + i + "失败，" + e.getMessage());
						return ret;
					}
					
				}else{
					ret.put("respCode", "2002");
					ret.put("respDesc",  "文件" + i +"为空");
					return ret;
				}
			}
			ret.put("respCode", "0000");
			ret.put("respDesc", "上传成功");
			return ret;
		}
		
}
