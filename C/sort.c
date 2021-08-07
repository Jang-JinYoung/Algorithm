#include <stdio.h>

#define SWAP(x,y,t) ( (t) = (x), (x) = (y), (y)=(t))
void selection_sort(int nums[], int n);

void main()
{
	int i = 0;
	int n = 100;
	int nums[100];

	for (i = 0; i < n; i++)
	{
		nums[i] = rand() % n;	// 난수 발생 범위 0~n
	}

	selection_sort(nums, n);
}

//selection sort -> O(n²)
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