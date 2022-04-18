#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>
#define MAX_LINKEDSTACK_SIZE 100

typedef struct StackNode { // 스택노드 구조체 정의
    char data[10]; // 데이터 타입
    struct StackNode* link; // 다음 노드 참조
}StackNode; 

typedef struct LinkedStackType{ // 스택 구조체 정의
    StackNode* top; // 스택 상단부
}LinkedStackType;


char prefix[50][10]; // 전위 표기
char postfix[50][10]; // 후위 표기

/*
    함수명 : init
    인  자 : LinkedStackType *s
    리턴형 : void
    설  명 : 스택을 초기화 한다.
*/
void init(LinkedStackType* s)
{
    s->top = NULL; // 스택 초기화
}

/*
    함수명 : is_empty
    인  자 : LinkedStackType* s
    리턴형 : int
    설  명 : 스택이 비어있는지 유무를 판별한다.
*/
int is_empty(LinkedStackType* s)
{
    return (s->top == NULL); // 스택 상단이 비어있는지 판별
}

/*
    함수명 : push
    인  자 : LinkedStackType* s, char data[]
    리턴형 : void
    설  명 : 스택에 노드를 삽입한다. (상단부에)
*/
void push(LinkedStackType* s, char data[])
{
    StackNode* temp = (StackNode*)malloc(sizeof(StackNode)); // 노드 선언 및 할당
    strcpy(temp->data, data); // 노드 데이터 삽입
    temp->link = s->top; // 노드 삽입
    s->top = temp; // 새로운 노드를 상단부로 지정
}

/*
    함수명 : pop
    인  자 : LinkedStackType* s
    리턴형 : char*
    설  명 : 스택 상단 노드를 반환하고, 동적할당 해제하며, 상단부를 재정의 한다.
*/
char* pop(LinkedStackType* s)
{
    static char data[10];
    if (is_empty(s)) { // 비어있는지 유무 판별
        fprintf(stderr, "스택이 비어있음\n");
        exit(1);
    }
    else {
        StackNode* temp = s->top; // 상단 노드를 가져온다.
        strcpy(data, temp->data); // 데이터 가져온다.
        s->top = s->top->link; // 상단 아래 노드를 상단노드로 지정한다.
        free(temp); // 동적할당 해제
        return data; // 데이터를 반환한다.
    }
}

/*
    함수명 : peek
    인  자 : LinkedStackType* s
    리턴형 : char*
    설  명 : 스택 상단 노드 데이터를 반환한다.
*/
char* peek(LinkedStackType* s)
{
    static char data[10];
    if (is_empty(s)) {
        fprintf(stderr, "스택이 비어있음\n");
        exit(1);
    }
    else {
        strcpy(data, s->top->data); // 데이터 가져온다.
        return data; // 데이터를 반환한다.
    }
}

/*
    함수명 : isNumber
    인  자 : char data[10]
    리턴형 : int
    설  명 : 숫자인지 아닌지를 확인한다.
*/
int isNumber(char data[10]) 
{
    // 연산기호들 +,-,*,/,(,) 일시 0 반환
    if (strcmp(data, "+") == 0 || strcmp(data, "-") == 0|| strcmp(data, "*") == 0 || 
        strcmp(data, "/") == 0 || strcmp(data, "(") == 0 || strcmp(data, ")") == 0)
        return 0;
    else // 숫자 일시 1 반환
        return 1;

}

/*
    함수명 : prec
    인  자 : char op[]
    리턴형 : int
    설  명 : 우선순위 여부를 확인하며 반환한다.
*/
int prec(char op[])
{
    if (strcmp(op, "(") == 0 || strcmp(op, ")") == 0)
        return 0;
    else if (strcmp(op, "+") == 0 || strcmp(op, "-") == 0)
        return 1;
    else if (strcmp(op, "*") == 0 || strcmp(op, "/") == 0)
        return 2;
    else
        return -1;
}

/*
    함수명 : infix_to_prefix
    인  자 : LinkedStackType* s
    리턴형 : int
    설  명 : 중위를 전위로 바꾸며 리턴형은 노드의 개수다.
*/
int infix_to_prefix(LinkedStackType* s)
{
    LinkedStackType temp;
    init(&temp);

    int j = 0;
    char data[10];
    char top_op[10];

    while (!is_empty(s)) {
        strcpy(data, pop(s));

        if (strcmp(data, "+") == 0 || strcmp(data, "-") == 0 || strcmp(data, "*") == 0 || strcmp(data, "/") == 0) 
        {
            while (!is_empty(&temp) && (prec(data) < prec(peek(&temp)))) {
                strcpy(prefix[j++], pop(&temp));
            }
            push(&temp, data);
        }
        else if (strcmp(data, ")") == 0)
        {
            push(&temp, data);
        }
        else if (strcmp(data, "(") == 0)
        {
            strcpy(top_op, pop(&temp));
            while (strcmp(top_op, ")") != 0) {
                strcpy(prefix[j++], top_op);
                strcpy(top_op, pop(&temp));
            }
        }
        else
        {
            strcpy(prefix[j++], data);
        }
    }

    while (!is_empty(&temp)) {
        strcpy(prefix[j++], pop(&temp));
    }

    for (int k = j-1; k >= 0; k--) {
        printf("%s ", prefix[k]);
    }

    return j;
}

/*
    함수명 : infix_to_postfix
    인  자 : LinkedStackType* s
    리턴형 : int
    설  명 : 중위를 후위로 바꾸며 리턴형은 노드의 개수다.
*/
int infix_to_postfix(LinkedStackType *s)
{
    LinkedStackType infix;
    LinkedStackType temp;
    init(&infix);
    init(&temp);

    int j = 0;
    char data[10];
    char top_op[10];

    while (!is_empty(s)) {
        push(&infix, pop(s));
    }

    while (!is_empty(&infix)) {
        strcpy(data, pop(&infix));

        if (strcmp(data, "+") == 0 || strcmp(data, "-") == 0 || strcmp(data, "*") == 0 || strcmp(data, "/") == 0)
        {
            while (!is_empty(&temp) && (prec(data) <= prec(peek(&temp))))
                strcpy(postfix[j++], pop(&temp));
            push(&temp, data);
        }
        else if (strcmp(data, "(") == 0) 
        {
            push(&temp, data);
        }
        else if (strcmp(data, ")") == 0)
        {
            strcpy(top_op, pop(&temp));
            while (strcmp(top_op, "(") != 0) {
                strcpy(postfix[j++], top_op);
                strcpy(top_op, pop(&temp));
            }
        }
        else
        {
            strcpy(postfix[j++], data);
        }
    }

    while (!is_empty(&temp)) {
        strcpy(postfix[j++], pop(&temp));
    }

    for (int k = 0; k < j; k++) {
        printf("%s ", postfix[k]);
    }


    return j;
}

/*
    함수명 : eval
    인  자 : len = postfixSize
    리턴형 : double
    설  명 : 후위표기수식을 계산한다.
*/
double eval(int len)
{
    double op1, op2;
    int i = 0;
    LinkedStackType temp;
    char data[10];
    double result = 0;

    init(&temp);

    for (i = 0; i < len; i++) {
        strcpy(data, postfix[i]);

        // 연산자
        if (strcmp(data, "+") == 0 || strcmp(data, "-") == 0 || strcmp(data, "*") == 0 || strcmp(data, "/") == 0) {
            op2 = atof(pop(&temp)); // atof = 문자열을 실수형으로 변환한다.
            op1 = atof(pop(&temp));
            if (strcmp(data, "+") == 0) sprintf(data, "%f", op1 + op2); // sprintf 실수형을 문자열로 변환한다.
            else if (strcmp(data, "-") == 0) sprintf(data, "%f", op1 - op2);
            else if (strcmp(data, "*") == 0) sprintf(data, "%f", op1 * op2);
            else if (strcmp(data, "/") == 0) sprintf(data, "%f", op1 / op2);
            push(&temp, data);
        }
        else {// 피연산자
            push(&temp, data);
        }
    }

    return atof(pop(&temp));
}

int main() 
{
    char infix[MAX_LINKEDSTACK_SIZE] = "5*(3.5-2)+4.68/3";
    LinkedStackType s;
    int i = 0, j = 0, index = 0;
    char data[10];
    int prefixSize, postfixSize;

    init(&s);

    for (i = 0; i < strlen(infix); i++) { //
        if (infix[i] == '.') {
            LinkedStackType s2;
            char ints[10] = "";
            char floats[10] = "";
            init(&s2);

            /* 정수부 시작 */
            while (isNumber(peek(&s))) { // 상단부가 숫자인지 아닌지를 판별하면서 loop를 실행한다.
                push(&s2, pop(&s));
            }

            while (!is_empty(&s2)) { // 새로운 스택노드가 제거될때까지 loop를 돌리며, 문자열을 만들어준다
                strcat(ints, pop(&s2));
            }
            /* 정수부 끝*/

            strcat(ints, ".");

            /* 소수부 시작 */
            for (j = i + 1; j < strlen(infix); j++) {
                if ('0' <= infix[j] && infix[j] <= '9')
                {
                    floats[index++] = infix[j];
                }
                else 
                {
                    break;
                }
            }
            floats[index] = '\0';
            i = j-1;
            index = 0;
            /* 소수부 끝 */
            strcat(ints, floats);
            push(&s, ints);
        }
        else {
            data[0] = infix[i];
            data[1] = '\0';
            push(&s, data);
        }
    }

    //출력용
    //while (!is_empty(&s)) {
    //    printf("%s\n", pop(&s));
    //}


    // 중위 -> 전위
    printf("전위식: ");
    prefixSize = infix_to_prefix(&s);

    printf("\n");
    for (i = 0; i < strlen(infix); i++) { //
        if (infix[i] == '.') {
            LinkedStackType s2;
            char ints[10] = "";
            char floats[10] = "";
            init(&s2);

            /* 정수부 시작 */
            while (isNumber(peek(&s))) { // 상단부가 숫자인지 아닌지를 판별하면서 loop를 실행한다.
                push(&s2, pop(&s));
            }

            while (!is_empty(&s2)) { // 새로운 스택노드가 제거될때까지 loop를 돌리며, 문자열을 만들어준다
                strcat(ints, pop(&s2));
            }
            /* 정수부 끝*/

            strcat(ints, ".");

            /* 소수부 시작 */
            for (j = i + 1; j < strlen(infix); j++) {
                if ('0' <= infix[j] && infix[j] <= '9')
                {
                    floats[index++] = infix[j];
                }
                else
                {
                    break;
                }
            }
            floats[index] = '\0';
            i = j - 1;
            index = 0;
            /* 소수부 끝 */
            strcat(ints, floats);
            push(&s, ints);
        }
        else {
            data[0] = infix[i];
            data[1] = '\0';
            push(&s, data);
        }
    }


    // 중위 -> 후위
    printf("후위식: ");
    postfixSize = infix_to_postfix(&s);

    printf("\n");
    printf("계산결과 : %f", eval(postfixSize));

    return 0;

}