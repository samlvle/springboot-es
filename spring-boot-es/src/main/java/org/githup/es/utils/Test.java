package org.githup.es.utils;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	public static void main(String args[])
	{
		int arr[]={5,3,1,8,9,5,6};	
		Test.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));		
		//ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		tobreak:
		while (true) {
		for (int i = 0; i < 100; i++) {			
				final int index = i;
				if(index==10)
				{
					break tobreak;
				}
				singleThreadExecutor.execute(new Runnable() {
					@Override
					public void run() {
						try {
							System.out.println(index + Thread.currentThread().getName());
							//Thread.sleep(1000);
						} catch (Exception e) {						
							e.printStackTrace();
						}
					}
				});
			}
		}	
		System.out.println("okoko");
	}
	
	public static void sort(int arr[],int low ,int hight)
	{
		
		
		if(low>hight)return;
		int i=low;
		int j=hight;
		int key=arr[low];
		
		while(i<j)
		{
			while(i<j &&arr[j]>key)
			{
				j--;
			}
			while(i<j && arr[i]<=key)
			{
				i++;
			}
			
			if(i<j)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		//交换key
		int temp=arr[i];
		arr[i]=arr[low];
		arr[low]=temp;
		
		sort(arr,low ,i-1);
		sort(arr,i+1 ,hight);
	}
}
