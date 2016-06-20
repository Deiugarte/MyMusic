package myfan.resources.base;

import java.util.List;
import myfan.resources.base.util.Comments;

public class CalificationsResponse {
		private List<Comments> comments;
		private int averageOfCalifications;
		private int totalOfComents;
		private int totalOfCalifications;
		
		public List<Comments> getComents() {
			return comments;
		}
		public int getAverageOfCalifications() {
			return averageOfCalifications;
		}
		public int getTotalOfComents() {
			return totalOfComents;
		}
		public int getTotalOfCalifications() {
			return totalOfCalifications;
		}
		public void setComents(List<Comments> comments) {
			this.comments = comments;
		}
		public void setAverageOfCalifications(int averageOfCalifications) {
			this.averageOfCalifications = averageOfCalifications;
		}
		public void setTotalOfComents(int totalOfComents) {
			this.totalOfComents = totalOfComents;
		}
		public void setTotalOfCalifications(int totalOfCalifications) {
			this.totalOfCalifications = totalOfCalifications;
		}
		
		
}
