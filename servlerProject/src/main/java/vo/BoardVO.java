package vo;

public class BoardVO {
	private String title;
	private String writer;
	private int bidx;
	private String content;
	private String wdate;
	private int hit;
	
	
	public BoardVO(String title, String writer) {
		this.title = title;
		this.writer = writer;
	}
	
	public BoardVO() {
		
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String contetn) {
		this.content = contetn;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getBidx() {
		return bidx;
	}

	public void setBidx(int bidx) {
		this.bidx = bidx;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}
}
