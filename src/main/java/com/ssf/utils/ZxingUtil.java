package com.ssf.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

/**
 * 条形码和二维码编码解码
 * 
 */
public class ZxingUtil {
	/**
	 * 条形码编码
	 * 
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	public static void encode(String contents, int width, int height, String imgPath) {
		int codeWidth = 3 + // start guard
				(7 * 6) + // left bars
				5 + // middle guard
				(7 * 6) + // right bars
				3; // end guard
		codeWidth = Math.max(codeWidth, width);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.EAN_13, codeWidth, height, null);

			MatrixToImageWriter
					.writeToFile(bitMatrix, "png", new File(imgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 条形码解码
	 * 
	 * @param imgPath
	 * @return String
	 */
	public static String decode(String imgPath) {
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File(imgPath));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			result = new MultiFormatReader().decode(bitmap, null);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 二维码编码
	 * 
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	public static void encode2(String contents, int width, int height, String imgPath) {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.QR_CODE, width, height, hints);

			MatrixToImageWriter
					.writeToFile(bitMatrix, "png", new File(imgPath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 二维码解码
	 * 
	 * @param imgPath
	 * @return String
	 */
	public static String decode2(String imgPath) {
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File(imgPath));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "GBK");

			result = new MultiFormatReader().decode(bitmap, hints);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 可以使用微信扫描
	 * @param args
	 */
	public static void main(String[] args) {

		// 条形码
		System.out.println("-----------解析条形码------------");
		String imgPath = "target\\zxing_EAN13.png";
		String contents = "6923450657713";
		int width = 105, height = 50;
		
		ZxingUtil.encode(contents, width, height, imgPath);
		System.out.println("编码内容:"+contents);
		//System.out.println("finished zxing EAN-13 encode.");

		String decodeContent = ZxingUtil.decode(imgPath);
		System.out.println("解码内容如下：" + decodeContent);
		//System.out.println("finished zxing EAN-13 decode.");
		//Assert.state(contents.equals(decodeContent));
		Assert.assertTrue(contents.equals(decodeContent));
		
		System.out.println("-----------二维码------------");
		// 二维码
		String imgPath2 = "target\\zxing.png";
//		String contents2 = "Hello Gem, welcome to Zxing!"
//				+ "\nBlog [ http://www.baidu.com ]"
//				+ "\nEMail [ help@ygcr8.com ]";
		
		String url = "http://www.baidu.com"; //微信对http的链接会自动跳转
		String contents2 = "<!DOCTYPE html>"+
		"<html>"+
		"<body>"+
		"<script type='text/javascript'>"+
		"	window.location.href='"+url+"';"+
		"</script>"+
		"</body>"+
		"</html>";
		contents2 = url;
		int width2 = 300, height2 = 300;
		System.out.println("编码内容:"+contents2);
		ZxingUtil.encode2(contents2, width2, height2, imgPath2);
		//System.out.println("finished zxing encode.");

		String decodeContent2 = ZxingUtil.decode2(imgPath2);
		System.out.println("解码内容如下：" + decodeContent2);
		//System.out.println("finished zxing decode.");
		
	}
}
