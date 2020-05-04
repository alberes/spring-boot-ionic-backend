package com.nelioalves.cursomc.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nelioalves.cursomc.services.exception.FileException;

@Service
public class ImageService {

	public BufferedImage getJpgImageFromFile(MultipartFile multipartFile) {
		String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		if(!"png".equals(ext) && !"jpg".equals(ext)) {
			throw new FileException("Somente imagens PNG ou JPGsão permitidas");
		}
		try {
			BufferedImage img = ImageIO.read(multipartFile.getInputStream());
			if("png".equals(ext)) {
				img = pngToJpg(img);
			}
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileException("Erro ao ler o arquivo");
		}
	}

	private BufferedImage pngToJpg(BufferedImage img) {
		BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
		return jpgImage;
	}
	
	public InputStream getInputStream(BufferedImage img, String extension) {
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(img, extension, os);
			return new ByteArrayInputStream(os.toByteArray());
		}catch(IOException e) {
			e.printStackTrace();
			throw new FileException("Erro ao ler o arquivo");
		}
	}
}
