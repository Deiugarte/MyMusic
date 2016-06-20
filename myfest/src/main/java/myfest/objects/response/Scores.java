package myfest.objects.response;

public class Scores {
	private int score;
	private int voters;
	private int commentsAmount;

	public Scores() {
		score = 0;
		voters = 0;
		commentsAmount = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getVoters() {
		return voters;
	}

	public void setVoters(int voters) {
		this.voters = voters;
	}

	public int getCommentsAmount() {
		return commentsAmount;
	}

	public void setCommentsAmount(int commentsAmount) {
		this.commentsAmount = commentsAmount;
	}

}
