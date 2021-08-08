#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct Node {
	int num;
	struct Node* next;
}Node;

typedef struct LinkedList {
	int size;
	struct Node *Head;
}LinkedList;

//링크드리스트 만드는 함수
void init(LinkedList *list) {

	list->Head = NULL;
	list->size = 0;

}

//비어있는지 확인하는 함수
int isEmpty(LinkedList* list)
{
	if (list->size == 0) {
		return TRUE;
	}
	else {
		return FALSE;
	}
}

//노드 추가하는 함수
void add(LinkedList* list, int num)
{
	Node* node = (Node*)malloc(sizeof(Node));
	node->num = num;
	node->next = NULL;
	
	if (isEmpty(list)) {
		list->Head = node;
	}
	else {
		Node* ptr = list->Head;
		while (ptr->next != NULL) {
			ptr = ptr->next;
		}
		ptr->next =  node;
	}

	list->size++;
	
}

//노드 제거하는 함수
int remove(LinkedList* list)
{
	Node* ptr = list->Head;
	Node* removed;

	if (isEmpty(list)) {
		printf("REMOVE ERROR\n");
	}
	else {
		
		if (ptr->next == NULL) {
			removed = ptr;
			list->Head = NULL;
			free(removed);
		}
		else {
			for (int i = 0; i < list->size - 2; i++) {
				ptr = ptr->next;
			}

			removed = ptr->next;
			ptr->next = NULL;
			free(removed);
		}


		list->size--;

	}
}

//노드 순서대로 출력하는 함수
void show(LinkedList* list)
{
	Node* ptr;

	if (isEmpty(list)) {
		printf("SHOW ERROR");
	}
	else {
		for (ptr = list->Head; ptr != NULL; ptr = ptr->next) {
			printf("%d\n", ptr->num);
		}
	}
}

//링크드리스트 사이즈를 구하는 함수
int size(LinkedList* list)
{
	printf("size = %d\n", list->size);

	return list->size;
}

void get(LinkedList* list, int index)
{
	if (index > list->size) {
		printf("GET ERROR");
	}
	else {
		Node* ptr = list->Head;
		for (int i = 0; i < index; i++) {
			ptr = ptr->next;
		}
		printf("%d\n", ptr->num);
	}
}

void main() 
{

	LinkedList list;

	init(&list);


	add(&list, 8);
	add(&list, 10);
	add(&list, 12);

	remove(&list);

	show(&list);
}

