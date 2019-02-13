package stackjava.com.demojsf.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class CommonController {

	private Part image;

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public void doUpLoad() {
		System.out.println("upload");
		try {
			InputStream in = image.getInputStream();
			System.out.println(image.getSubmittedFileName());
			File f = new File("C:/Users/toila/Desktop/images/" + image.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			System.out.println("ok");
			out.close();
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
