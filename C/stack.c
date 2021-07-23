#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FALSE 0
#define TRUE 1


typedef struct Node {
	int num;
	struct Node* next;
}Node;

typedef struct Stack {
	struct Node* top;
}Stack;


//스택 시작
void init(Stack* stack);
//스택이 비어있는지 없는지 확인하는 함수
int isEmpty(Stack* stack);
//스택에 넣는 함수
void push(Stack* stack, char c);
//스택에서 꺼내는 함수
char pop(Stack* stack);
//스택 최상위를 보는 함수 (보기만 함 삭제 xxx)
char peek(Stack* stack);

int main() {

	Stack s;

	char word[10] = "banana";
	int size = strlen(word);
	int count = 0;


	//시작
	init(&s);

	//push - 삽입
	for (int i = 0; i < size; i++) {
		push(&s, word[i]);
	}

	//pop & peek - 삭제 & 최상위 노드 보기 
	while (!isEmpty(&s)) {
		printf("최상위 노드 : %c\n", peek(&s));
		printf("삭제 : %c\n", pop(&s));
		printf("-------------------------\n");
	}
}

void init(Stack* stack) {

	stack->top = NULL;
}

int isEmpty(Stack* stack) {

	//스택이 비어있으면
	if (stack->top == NULL) {
		return TRUE;
	}
	else
		return FALSE;
}

void push(Stack* stack, int num) {

	Node* node = (Node*)malloc(sizeof(Node));

	node->num = num;
	node->next = stack->top;

	stack->top = node;
}

char pop(Stack* stack) {

	Node* node;
	char c;

	if (isEmpty(stack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	c = stack->top->num;
	node = stack->top;
	stack->top = stack->top->next;

	free(node);

	return c;

}

char peek(Stack* stack) {

	if (isEmpty(stack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	return stack->top->num;
}