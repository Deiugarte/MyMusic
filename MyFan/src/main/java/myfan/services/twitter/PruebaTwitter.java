package myfan.services.twitter;

import myfan.domain.IConstansts;
import myfan.domain.PostTwitter;

public class PruebaTwitter implements IConstansts {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		 PostTwitter twitter1 =new PostTwitter();
		 twitter1.postStatusTwitter("Stiven", "Justin Bieber",STATUS_RATE);
	}

}
