import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GrayScale {

   BufferedImage  image;
   int width;
   int height;
   
   public GrayScale(String fileName) throws IOException {

		File dest = new File("output.stl");
		File source = new File(fileName);
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
   }

   
   static public void main(String args[]) throws Exception 
   {
      GrayScale obj = new GrayScale(args[0]);
   }
}