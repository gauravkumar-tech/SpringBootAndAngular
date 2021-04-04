package com.example.demo.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String Upload="D:\\git repository\\GauravSpringBoot\\src\\main\\resources\\static\\image";
	
	public boolean fileUploaded(MultipartFile file) {
		boolean b= false;
		try {
			Files.copy(file.getInputStream(), Paths.get(Upload+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
}
