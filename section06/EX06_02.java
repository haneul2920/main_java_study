package section06;

public class EX06_02 {

	public static void main(String[] args) {
		//배열에 값 저장하기
		
		//4개의 공간을 가진 배열을 선언
		int[] arr = new int[4];
		
		//배열에 값을 삽입
		//int arr[] =  {1,2,3,4,};
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		
		System.out.println( "arr[0] = " + arr[0]);
		System.out.println( "arr[1] = " + arr[1]);
		System.out.println( "arr[2] = " + arr[2]);
		System.out.println( "arr[3] = " + arr[3]);
		
		//배열의 길이
		System.out.println("배열의 길이는 ? " + arr.length);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println("arr[+ i +] = " + arr[i]);
		}
	}

}
