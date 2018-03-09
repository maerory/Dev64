package net.n1books.dev.di03;

import org.springframework.stereotype.Component;

@Component
public class OrangeSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("OrangeSpeaker : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("OrangeSpeaker : 소리를 줄입니다.");
	}

}
