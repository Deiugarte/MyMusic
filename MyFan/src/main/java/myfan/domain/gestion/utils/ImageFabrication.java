package myfan.domain.gestion.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class ImageFabrication {

  public String saveFile(InputStream profilePicture, FormDataContentDisposition fileDetail) {
    String pathFileProfilePicture = "";
    OutputStream outputStream = null;
    String nameFile = java.util.UUID.randomUUID().toString();
    String nameFileWithExtension;
    if (profilePicture != null && fileDetail.getFileName() != null) {
      try {
        // write the inputStream to a FileOutputStream
        File file;
        boolean isPNGExtension = fileDetail.getFileName().contains("png");
        if (isPNGExtension) {
          nameFileWithExtension ="img/"+ nameFile + ".png";
          file = new File( "src/main/webapp/" +nameFileWithExtension);
          outputStream = new FileOutputStream(file);
        } else {
          nameFileWithExtension = "img/"+nameFile + ".jpg";
          file = new File("src/main/webapp/"+nameFileWithExtension);
          outputStream = new FileOutputStream(file);
        }
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = profilePicture.read(bytes)) != -1) {
          outputStream.write(bytes, 0, read);
        }
        pathFileProfilePicture = nameFileWithExtension;
         System.out.println("Done!");
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
        if (profilePicture != null) {
          try {
            profilePicture.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (outputStream != null) {
          try {
            // outputStream.flush();
            outputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
      return pathFileProfilePicture;
    } else {
      return null;
    }
  }
}
