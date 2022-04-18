 stdio.h stdlib.h string.h 이외의 라이브러리는 사용할 수 없다 - 명세서 7
#include stdio.h
#include string.h
#include stdlib.h

char postfix[50][10];  후위 표기

typedef struct Node {
	char data[5];  피연산자는 1~99 사이 
	struct Node link;
}Node;

typedef struct LinkedStackType{
	Node top;
}LinkedStackType;

void init(LinkedStackType s)
{
    s-top = NULL;
}

int is_empty(LinkedStackType s)
{
    return (s-top == NULL);
}

void push(LinkedStackType s, char data[])
{
	Node temp = (Node)malloc(sizeof(Node));  노드 선언 및 할당
    strcpy(temp-data, data);  노드 데이터 삽입
    temp-link = s-top;  노드 삽입
    s-top = temp;  새로운 노드를 상단부로 지정
}

char pop(LinkedStackType s)
{
    static char data[10];
    if (is_empty(s)) {  비어있는지 유무 판별
        return 1;
    }
    else {
        Node temp = s-top;  상단 노드를 가져온다.
        strcpy(data, temp-data);  데이터 가져온다.
        s-top = s-top-link;  상단 아래 노드를 상단노드로 지정한다.
        free(temp);  동적할당 해제
        return data;  데이터를 반환한다.
    }
}

char peek(LinkedStackType s)
{
    static char data[10];
    if (is_empty(s)) {
        fprintf(stderr, 스택이 비어있음n);
        exit(1);
    }
    else {
        strcpy(data, s-top-data);  데이터 가져온다.
        return data;  데이터를 반환한다.
    }
}

int checkDigit(char s) {
	int len = strlen(s);  문자열길이
	int i;
	char ch;

	for (i = 0; i  len; i++) {
		ch = s[i];
		인자로 전달받은 문자열 수식 속에는 피연산자, 사칙연산자(+ - ), 괄호 기호만 등장한다. 괄호 기호는 소괄호만 사용한다.
		if (('0' = ch && ch = '9') 
			(ch == '+'  ch == '-'  ch == ''  ch == '') 
			(ch == '('  ch == ')')) {
			continue;
		}
		else {
			return 0;
		}
	}
	
	return 1;
}

int matchBracket(char s) {
    LinkedStackType stack;
    init(&stack);
    int len = strlen(s);
    int i;
    char data[5];

     오류조건 정리
     1. 문자가 )일때 스택이 비어있는 경우
     2. 문자를 끝까지 정리했을때 스택이 비어있지 않는경우
    for (i = 0; i  len; i++) {
        if (s[i] == '(') {  '(' 여는 부호라면 스택 삽입
            data[0] = s[i];
            data[1] = '0';
            push(&stack, data);
        }
        else if (s[i] == ')') { ')' 닫는 부호라면 스택 제거
            if (is_empty(&stack)) {  오류조건 1
                printf(괄호 검사 오류 1n);
                return 0;
            }
            else {
                pop(&stack);
            }
        }
    }

    if (!is_empty(&stack)) {  오류 조건2
        while (!is_empty(&stack)) {  메모리 누수방지를 위해 동적할당 해제시켜준다.
            pop(&stack);
        }
        printf(괄호 검사 오류 2n);
        return 0;
    }

    return 1;
}

int isNumber(char data[]) 
{
     연산기호들 +,-,,,(,) 일시 0 반환
    if (strcmp(data, +) == 0  strcmp(data, -) == 0 strcmp(data, ) == 0  
        strcmp(data, ) == 0  strcmp(data, () == 0  strcmp(data, )) == 0)
        return 0;
    else  숫자 일시 1 반환
        return 1;

}

int prec(char op[])
{
    if (strcmp(op, () == 0  strcmp(op, )) == 0)
        return 0;
    else if (strcmp(op, +) == 0  strcmp(op, -) == 0)
        return 1;
    else if (strcmp(op, ) == 0  strcmp(op, ) == 0)
        return 2;
    else
        return -1;
}

int infix_to_postfix(LinkedStackType s)
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

        if (strcmp(data, +) == 0  strcmp(data, -) == 0  strcmp(data, ) == 0  strcmp(data, ) == 0)
        {
            while (!is_empty(&temp) && (prec(data) = prec(peek(&temp))))
                strcpy(postfix[j++], pop(&temp));
            push(&temp, data);
        }
        else if (strcmp(data, () == 0)
        {
            push(&temp, data);
        }
        else if (strcmp(data, )) == 0)
        {
            strcpy(top_op, pop(&temp));
            while (strcmp(top_op, () != 0) {
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

    return j;
}

int eval(char s) {
    int i = 0, j, idx = 0;;
    LinkedStackType stack, temp;
    char data[5];
    char input[5];
    int postfixSize;
    int op1, op2;

	if (!checkDigit(s)) { 인자를 확인한다 - 명세서 2번
		return -999;
	}

    if (!matchBracket(s)) {  괄호를 검사한다 - 명세서 4번
        return -999;
    }

     exp 를 node로 변환하여 스택에 쌓는다.
    init(&stack);
	for (i = 0; i  strlen(s); i++) {
        data[0] = s[i];
        data[1] = '0';
        if (!isNumber(data)) { 숫자가 아니라면 , 연산자거나 또는 괄호 삽입
            push(&stack, data);
        }
        else {
            for (j = i; j  strlen(s); j++) {
                data[0] = s[j];
                data[1] = '0';
                if (!isNumber(data)) {
                    break;
                }
                else {
                    input[idx++] = data[0];
                }
            }
            i = j-1;
            input[idx] = '0';
            idx = 0;
            push(&stack, input);
        }
    }

     계산을 위해 중위 표기를 후위 표기로 변환
    postfixSize = infix_to_postfix(&stack);
    for (i = 0; i  postfixSize; i++) {
        if (isNumber(postfix[i])) {  정수형일때
            if (atoi(postfix[i])  99) {  99를 넘어서면 에러 - 명세서 3
                return -999;
            }
        }
    }

     계산
    init(&temp);

    for (i = 0; i  postfixSize; i++) {
        strcpy(data, postfix[i]);

         연산자
        if (strcmp(data, +) == 0  strcmp(data, -) == 0  strcmp(data, ) == 0  strcmp(data, ) == 0) {
            op2 = atoi(pop(&temp));  atof = 문자열을 실수형으로 변환한다.
            op1 = atoi(pop(&temp));
            if (strcmp(data, +) == 0) sprintf(data, %d, op1 + op2);  sprintf 실수형을 문자열로 변환한다.
            else if (strcmp(data, -) == 0) sprintf(data, %d, op1 - op2);
            else if (strcmp(data, ) == 0) sprintf(data, %d, op1  op2);
            else if (strcmp(data, ) == 0) {
                if (op2 == 0) { 0으로 나누는지 아닌지를 판별한다 - 명세서 6
                    return -999;
                }
                else {
                    sprintf(data, %d, op1  op2);
                }
            }
            push(&temp, data);
        }
        else { 피연산자
            push(&temp, data);
        }
    }

    return atoi(pop(&temp));

}

int main(void) {
	char exp = (12+3)5;
	int result;

	result = eval(exp);  main 함수에서 eval 함수를 실행시켜 수식 계산 결과를 출력할 수 있는 eval 함수

	if (result == -999) {
		printf(Errorn);
		return 1;
	}
	else {
		printf(Result = %dn, result);
		return 0;
	}
}