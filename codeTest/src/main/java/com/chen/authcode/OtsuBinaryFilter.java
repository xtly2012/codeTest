package com.chen.authcode;

import java.awt.Color;
import java.awt.image.BufferedImage;  
import java.io.File;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

public class OtsuBinaryFilter {  
      
    public OtsuBinaryFilter()  
    {  
        System.out.println("Otsu Threshold Binary Filter...");  
    }  
  
    /**
     * 计算像素灰度<br>
     * 将彩色图像转化成为灰度图像的过程成为图像的灰度化处理。彩色图像中的每个像素的颜色有R、G、B三个分量决定，
     * 而每个分量有255中值可取，这样一个像素点可以有1600多万（255*255*255）的颜色的变化范围。而灰度图像是
     * R、G、B三个分量相同的一种特殊的彩色图像，其一个像素点的变化范围为255种，所以在数字图像处理种一般先将各
     * 种格式的图像转变成灰度图像以使后续的图像的计算量变得少一些。灰度图像的描述与彩色图像一样仍然反映了整幅图像
     * 的整体和局部的色度和亮度等级的分布和特征。图像的灰度化处理可用两种方法来实现。
	 * 第一种方法使求出每个像素点的R、G、B三个分量的平均值，然后将这个平均值赋予给这个像素的三个分量。
	 * 第二种方法是根据YUV的颜色空间中，Y的分量的物理意义是点的亮度，由该值反映亮度等级，根据RGB和YUV颜色空间的
	 * 变化关系可建立亮度Y与R、G、B三个颜色分量的对应：Y=0.3R+0.59G+0.11B，以这个亮度值表达图像的灰度值。
     * 
     * @param color
     * 
     * @return gray
     */
    public Integer getGray(int argb) {
    	int red = (argb & 0xff0000) >> 16;
    	int green = (argb & 0xff00) >> 8;
    	int blue = (argb & 0xff);
    	Double gray = 0.299 * red + 0.587 * green + 0.114 * blue;
    	BigDecimal grayDec = new BigDecimal(gray.toString());
    	grayDec = grayDec.setScale(0, BigDecimal.ROUND_HALF_DOWN);
    	return grayDec.intValue();
    }
  
    /**
     * 获取图像直方图
     * @param img
     */
    public double[] getImageGrayHistogram(BufferedImage img) {
    	int height = img.getHeight();
    	int width = img.getWidth();
    	double[] histogramArr = new double[256];
    	for (int y = 0; y < height; y++) {
    		for (int x = 0; x< width; x++) {
    			histogramArr[getGray(img.getRGB(x, y))]++;
    		}
    	} 
    	
    	return histogramArr;
    }
    
    public int getMaxVariance(BufferedImage img) {
    	int totalPixel = img.getHeight() * img.getWidth();
    	double[] histogramArr = getImageGrayHistogram(img);
    	for (int i = 0; i < 256; i++) {
    		histogramArr[i] = histogramArr[i] / totalPixel;  //归一化直方图 
    	}
    	
    	double maxAvgValue = 0;
    	for (int i = 0; i < 256; i++) {
    		maxAvgValue = i * histogramArr[i]; //总的灰度均值，其实在这里可将其设为0   

    	}
    	
    	double forePro = 0; // 灰度A出现的概率
    	double backPro = 0; // 灰度B出现的概率
    	double foreGrayValue = 0; // 灰度A均值
    	double backGrayValue = 0; // 灰度B均值
    	double maxVariance = 0;
    	double variance;
    	int threshold = 0;
    	
    	for (int i = 0; i < 256; i++) {
    		forePro += histogramArr[i];
    		backPro = 1 - forePro;
    		foreGrayValue += i * histogramArr[i];
    		backGrayValue += maxAvgValue - foreGrayValue;
    		
    		variance = forePro * (foreGrayValue -maxAvgValue) * (foreGrayValue -maxAvgValue)
    				+backPro * (backGrayValue -maxAvgValue) * (backGrayValue -maxAvgValue);
    	
    		if (variance > maxVariance) {
    			maxVariance = variance;
    			threshold = i;
    		}
    	}
    	
    	return threshold;
    }
    
    public static void main(String[] argus) throws Exception {
    	BufferedImage img = ImageIO.read(new File("img//1234567.jpg")); 
    	OtsuBinaryFilter filter = new OtsuBinaryFilter();
    	int maxVar = filter.getMaxVariance(img);
    	int height = img.getHeight();
    	int width = img.getWidth();
    	for (int y = 0; y < height; y++) {
    		for (int x = 0; x < width; x++) {
    			int gray = filter.getGray(img.getRGB(x, y));
    			if (gray < maxVar) {
    				img.setRGB(x, y, Color.BLACK.getRGB());
    			} else {
    				img.setRGB(x, y, Color.WHITE.getRGB());
    			}
    		}
    	}
    	ImageIO.write(img, "JPG", new File("result//otsu12.jpg"));  
    }
}  