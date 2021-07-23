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


//���� ����
void init(Stack* stack);
//������ ����ִ��� ������ Ȯ���ϴ� �Լ�
int isEmpty(Stack* stack);
//���ÿ� �ִ� �Լ�
void push(Stack* stack, char c);
//���ÿ��� ������ �Լ�
char pop(Stack* stack);
//���� �ֻ����� ���� �Լ� (���⸸ �� ���� xxx)
char peek(Stack* stack);

int main() {

	Stack s;

	char word[10] = "banana";
	int size = strlen(word);
	int count = 0;


	//����
	init(&s);

	//push - ����
	for (int i = 0; i < size; i++) {
		push(&s, word[i]);
	}

	//pop & peek - ���� & �ֻ��� ��� ���� 
	while (!isEmpty(&s)) {
		printf("�ֻ��� ��� : %c\n", peek(&s));
		printf("���� : %c\n", pop(&s));
		printf("-------------------------\n");
	}
}

void init(Stack* stack) {

	stack->top = NULL;
}

int isEmpty(Stack* stack) {

	//������ ���������
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