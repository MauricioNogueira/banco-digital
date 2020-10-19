package com.zup.banco.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.iot.model.CannedAccessControlList;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
	@Autowired
	private AmazonS3 s3Client;
	
	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	public void uploadFile(String localFilePath) {
		File file = new File(localFilePath);
		
		System.out.println("Realizando upload");
		this.s3Client.putObject(new PutObjectRequest(localFilePath, "texto.txt", file));
		System.out.println("Sucesso");
	}
}
