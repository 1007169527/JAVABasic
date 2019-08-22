package com.rtfsc;
public class Rotator {
	private String images[] = {"images/book1.png","images/book2.jpg","images/book3.jpg"};
	private String links[] = {"https://item.jd.com/31107521323.html",
		"https://item.jd.com/12547986.html","https://item.jd.com/12464037.html"};
	private int selectIndex = 0;
	
	public String getImage() {
		return images[selectIndex];
	}
	
	public String getLink() {
		return links[selectIndex];
	}
	
	public void nextAd() {
		selectIndex = (selectIndex + 1) % images.length;
	}    
}
