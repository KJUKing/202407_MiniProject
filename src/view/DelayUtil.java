package view;

public class DelayUtil {
	public static void delay(int milliseconds) {
		   try {
			   Thread.sleep(milliseconds);
		   }catch (InterruptedException e){
			   //예외 처리 로직
			   e.printStackTrace();
			   //현재 스레드의 인터럽트 상태를 복원
			   Thread.currentThread().interrupt();
		   }
	   }
}


	   