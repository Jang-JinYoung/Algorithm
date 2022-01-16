#include <stdio.h>
#define MAX_ELEMENT 200

typedef struct {
	int key;
}element;

typedef struct {
	element heap[MAX_ELEMENT];
	int heap_size;
}HeapType;

//초기화 함수
init(HeapType* h) {
	h->heap_size = 0;
}

//삽입 함수
void insert_min_heap(HeapType* h, element item) {
	int i;
	i = ++(h->heap_size);

	// 트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
	while ((i != 1) && (item.key < h->heap[i / 2].key)) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;
}

//삭제 함수
element delete_max_heap(HeapType* h) {
	int parent, child;
	element item, temp;

	item = h->heap[1];
	temp = h->heap[(h->heap_size)--];
	parent = 1;

	child = 2;
	while (child <= h->heap_size) {
		//현재 노드의 자식 노드 중 더 큰 자식 노드를 찾는다.
		if ((child < h->heap_size) && (h->heap[child].key) > h->heap[child + 1].key)
			child++;
		if (temp.key <= h->heap[child].key)
			break;

		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}

// 출력 함수
void print_heap(HeapType* h) {

	for (int i = 1; i <= h->heap_size; i++) {
		printf("%d ", h->heap[i]);
	}
	printf("\n");
}

//메인 함수
int main() {
	element e1 = { 10 }, e2 = { 5 }, e3 = { 30 };
	element e4, e5, e6;
	HeapType heap;

	init(&heap);

	insert_min_heap(&heap, e1);
	insert_min_heap(&heap, e2);
	insert_min_heap(&heap, e3);
	print_heap(&heap);

	e4 = delete_max_heap(&heap);
	printf("< %d >\n", e4.key);
	e5 = delete_max_heap(&heap);
	printf("< %d >\n", e5.key);
	e6 = delete_max_heap(&heap);
	printf("< %d >\n", e6.key);

}