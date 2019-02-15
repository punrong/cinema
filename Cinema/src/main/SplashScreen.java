package main;

public class SplashScreen {
	
	public SplashScreen() throws InterruptedException {
		
		Splash splash = new Splash();
		for(int i = 0 ; i < 101; i ++) {
			Thread.sleep(50);
			splash.setVisible(true);
			splash.lblLoading.setText("Loading.." + i + "%");
			splash.progressBarLoading.setValue(i);
			
			if(i == 100) {
				SignInOptions frame = new SignInOptions();
				Thread.sleep(30);
				frame.setVisible(true);
				splash.setVisible(false);
			}
		}
	}
	
}
