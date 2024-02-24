package lambda;

public class ThreadsEx {
	
	public static void main(String[] args) {
		
		Runnable work1 = new Work1();
		Runnable work2 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Task #02");
					try {
						Thread.sleep(450);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		};
		
		Runnable work3 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Task #03");
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		
		Runnable work4 = ThreadsEx::work3;
		
		Thread thread1 = new Thread(work1);
		Thread thread2 = new Thread(work2);
		Thread thread3 = new Thread(work3);
		Thread thread4 = new Thread(work4);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	static void work3() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Task #04");
			try {
				Thread.sleep(350);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}