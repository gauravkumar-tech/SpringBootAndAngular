package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.FileUploadHelper;

@RestController
public class FileUploadingController {

	@Autowired
	private FileUploadHelper fileuploadhelper;

	@PostMapping("/fileupload")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

		try {

			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Cannot be fullfilled");
			}

			if (!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("File must be png");
			}

			// file upload code
			boolean b = fileuploadhelper.fileUploaded(file);
			if (b) {
				return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded Succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded Succesfully");
	}
}
