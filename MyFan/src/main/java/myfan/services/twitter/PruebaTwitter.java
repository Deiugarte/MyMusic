package myfan.services.twitter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import myfan.domain.IConstansts;
import myfan.domain.PostTwitter;
import myfan.domain.User;

public class PruebaTwitter implements IConstansts {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		 PostTwitter twitter1 =new PostTwitter();
		 Image imagen=new Image() {
			
			@Override
			public int getWidth(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ImageProducer getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getProperty(String name, ImageObserver observer) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getHeight(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Graphics getGraphics() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		 User user = new User("Javier","23/02/1991/","M","javesp","12345678","Costa Rica",imagen);
		
		// twitter1.postStatusTwitter("Javier", "The Beatles",STATUS_FOLLOW);
	}

}
