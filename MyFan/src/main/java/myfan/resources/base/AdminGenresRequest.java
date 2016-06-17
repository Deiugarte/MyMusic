package myfan.resources.base;

import java.util.ArrayList;

public class AdminGenresRequest {
	private ArrayList<String> musicalGenres; /*opcional*/

	public ArrayList<String> getMusicalGenres() {
		return musicalGenres;
	}

	public void setMusicalGenres(ArrayList<String> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}
	
}
