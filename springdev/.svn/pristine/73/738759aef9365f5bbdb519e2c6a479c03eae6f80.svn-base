package net.n1books.dev.di03;

public class LgTV implements TV {
	private Speaker speaker;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("LgTV : 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("LgTV : 전원을 끕니다.");
	}
	public void channelUp() {
		System.out.println("LgTV : 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("LgTV : 채널을 내립니다.");
	}
	public void soundUp() {
		if (speaker == null) {
			System.out.println("LgTV : 소리를 키웁니다.");
		} else {
			speaker.soundUp();
		}
	}
	public void soundDown() {
		if (speaker == null) {
			System.out.println("LgTV : 소리를 줄입니다.");
		} else {
			speaker.soundDown();
		}
	}
}
