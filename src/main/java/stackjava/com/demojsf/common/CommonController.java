package stackjava.com.demojsf.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.google.common.primitives.Bytes;

public class CommonController {
	private Part image;

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	/**
	 * @param folder
	 * @param imageName
	 */
	public void doUpLoad(String folder, String imageName, Part image) {
		System.out.println("upload");
		try {
			Calendar cal = Calendar.getInstance();
			Date date = new Date();
			cal.setTime(date);
			int day = Integer.valueOf(cal.get(5));

			int month = Integer.valueOf(cal.get(2) + 1);
			int year = Integer.valueOf(cal.get(1));

			String relativeWebPath = "/resources";
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String absoluteDiskPath = facesContext.getExternalContext().getRealPath(relativeWebPath);
			System.out.println(absoluteDiskPath);
			String directory = absoluteDiskPath + "/img/" + folder + "/" + year + "/" + month + "/" + day + "/";

			File file = new File(directory);
			String absolutePath = file.getAbsolutePath();
			System.out.println("absolutePath" + absolutePath);
			final Path destination = Paths
					.get(absoluteDiskPath + "/img/" + folder + "/" + year + "/" + month + "/" + day + "/");
			if (!Files.exists(destination)) {
				try {
					Files.createDirectories(destination);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
			InputStream bytes = null;

			try {
				bytes = image.getInputStream();
				System.out.println("bytes"+ bytes.toString());
				try {
					System.out.println("coppy");
					Files.copy(bytes, destination);
				} catch (Exception e) {
					System.out.println("co loi");
					System.out.println("==========>"+e.getMessage());
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
