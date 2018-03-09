package net.n1books.dev.di03;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.web.bind.annotation.RestController;

@RestController("tv")
public class SamsungTV implements TV {
	@Inject								// = Autowired
	@Resource(name = "orangeSpeaker")	// = Qualifier
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("SamsungTV : 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV : 전원을 끕니다.");
	}
	public void channelUp() {
		System.out.println("SamsungTV : 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("SamsungTV : 채널을 내립니다.");
	}
	public void soundUp() {
		if (speaker == null) {
			System.out.println("SamsungTV : 소리를 키웁니다.");
		} else {
			speaker.soundUp();
		}
	}
	public void soundDown() {
		if (speaker == null) {
			System.out.println("SamsungTV : 소리를 줄입니다.");
		} else {
			speaker.soundDown();
		}
	}
}
