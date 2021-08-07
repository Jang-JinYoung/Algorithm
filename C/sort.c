#include <stdio.h>

#define SWAP(x,y,t) ( (t) = (x), (x) = (y), (y)=(t))

void selection_sort(int nums[], int n);
void insertion_sort(int nums[], int n);
void bubble_sort(int nums[], int n);

void main()
{
	int i = 0;
	int n = 100;
	int nums[100];

	for (i = 0; i < n; i++)
	{
		nums[i] = rand() % n;	// 난수 발생 범위 0~n
	}

	//selection_sort(nums, n);

	//insertion_sort(nums, n);

	bubble_sort(nums, n);


}

//선택 정렬 -> O(n²)
void selection_sort(int nums[], int n)
{

	int i, j, least, temp;

	for (int i = 0; i < n - 1; i++) {
		least = i;
		for (int j = i + 1; j < n; j) {
			if (nums[j] < nums[least])
				least = j;
			SWAP(nums[i], nums[least], temp);
		}
	}

}

//삽입 정렬 -> 최선 O(n) 최악 O(n²)
void insertion_sort(int nums[], int n)
{
	int i, j, key;

	for (i = 1; i < n; i++)
	{
		key = nums[i];
		for (j = i - 1; j >= 0 && nums[j] > key; j--)
		{
			nums[j + 1] = nums[j];
		}
		nums[j + 1] = key;
	}
}

//버블 정렬 -> O(n²)
void bubble_sort(int nums[], int n)
{
	int i, j, temp;

	for (int i = n - 1; i > 0; i--)
	{
		for (int j = 0; j < 1; j++) {
			if (nums[j] > nums[j + 1])
			{
				SWAP(nums[j], nums[j + 1], temp);
			}
		}
	}
}
