/*
 * 	메서드: 한 개의 기능을 수행하기 위한 명령문의 집합
 *        ==============================
 *        재사용이 가능
 *        반복을 제거할 수 있다
 *        메서드 호출 => 메서드명(값...) => 메서드의 구현부인 {} 안에 있는 모든 내용을 수행하고 다시 호출된 위치로 복귀한다.
 *        
 *        
 *        ==============================
 *        *** 명령문
 *            int a = 10; // 10을 a라는 메모리 공간에 대입해라.
 *            int b = 20;
 *            System.out.println(a + b)
 *            
 *        형식)
 *            리턴형(결과값) 메서드명(매개변수...) {
 *            	수행할 내용을 코딩
 *            }
 *            
 *            = 리턴형(O) 매개변수(O)
 *                *** 리턴형: 사용자가 요청한 내용을 처리후에 나오는 결과값 (결과값은 반드시 하나다 !)
 *                          결과값이 여러 개일 경우: 배열이나 클래스를 사용한다.
 *                          				  ===========
 *                          = 모든 메서드는 메서드 종료를 위해서 return을 사용
 *                            return 값; (void인 경우에는 return을 생략할 수 있다)
 *                *** 매개변수: 
 *            = 리턴형(O) 매개변수(X)
 *            = 리턴형(X) 매개변수(O)
 *            = 리턴형(X) 매개변수(X)
 *            
 *        	  메서드는 소스가 많거나 복잡한 경우에 분리하기 위해 만든다.
 *            
 *        
 */
/*
 * +++ 이런 경우 사용 +++
 * 	1. 반복이 많다 *****
 * 	2. 다음에 다시 사용 *****
 * 	3. 복잡한 소스코딩 
 */
public class 메서드정리 {
	// 출력하는 메서드
	static void print(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

	// 정렬하는 메서드

	static int[] sort_asc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] > arr[k]) {
					int tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
		return arr;
	}

	static int[] sort_desc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] < arr[k]) {
					int tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
		return arr;
	}
	
	static int[] sort(int[] arr, String type) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (type.equals("DESC")){	
					if (arr[i] < arr[k]) {
						int tmp = arr[i];
						arr[i] = arr[k];
						arr[k] = tmp;
					}
				}
				else {	
						if (arr[i] > arr[k]) {
							int tmp = arr[i];
							arr[i] = arr[k];
							arr[k] = tmp;
						}
				}
		
		}
	}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 30, 20, 50, 10, 40 };
		System.out.println("===== 정렬 전=====");
		// 출력: for-each => 역순으로 출력하기 어렵다 / 역순으로 출력하려면 일반 for문을 사용하자. // 여러개의 배열을 동시 출력할
		// 수 없다. // 배열의 값을 변경할 수 없다.

		/*
		 * for (int i : arr) { System.out.print(i + " "); }
		 */
		print(arr);
		System.out.println("\n===== 정렬 후(ASC: 올림차순) =====");
		/*
		 * i 30 20 50 10 40
		 */
		/*
		 * for (int i = 0; i < arr.length - 1; i++) { for (int k = i + 1; k <
		 * arr.length; k++) { if (arr[i] > arr[k]) { int tmp = arr[i]; arr[i] = arr[k];
		 * arr[k] = tmp; } } }
		 */
		// 출력
		/*
		 * for (int i : arr) { System.out.print(i + " "); }
		 */
		int[] arr1 = sort_asc(arr);
		print(arr1);

		System.out.println("\n===== 정렬 후(DESC: 내림차순) =====");
		/*
		 * for (int i = 0; i < arr.length - 1; i++) { for (int k = i + 1; k <
		 * arr.length; k++) { if (arr[i] < arr[k]) { int tmp = arr[i]; arr[i] = arr[k];
		 * arr[k] = tmp; } } }
		 */
		int[] arr2 = sort_desc(arr);
		// 출력
		print(arr2);

	}

}
