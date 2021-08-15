//infix_to_postfix
#define _crt_secure_no_warnings
#include <stdio.h>
#include <stdlib.h>
#define max_stack_size 100

typedef int element;
typedef struct {
    element stack[max_stack_size];
    int top;
} stacktype;
typedef enum {
    leftparen, rightparen, plus, minus, multiply, divide, eos, operand
} words;

void init(stacktype* s) {
    s->top = -1;
}

int is_full(stacktype* s) {
    return (s->top == (max_stack_size - 1));
}

int is_empty(stacktype* s) {
    return (s->top == -1);
}

void push(stacktype* s, element item) {
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }
    else s->stack[++(s->top)] = item;
}

element peek(stacktype* s) {
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    else return s->stack[s->top];
}

element pop(stacktype* s) {
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    else return s->stack[(s->top)--];
}

int prec(char op) {
    switch (op) {
    case '(':case')':return 0;
    case'+':case'-':return 1;
    case'*':case'/': case '%': return 2;
    }
    return -1;
}

void infix_to_postfix(char infix[], char postfix[]){

    int i = 0;
    int len = 0;
    char ch, input;
    char top_op;
    int j=0;
    while (infix[i] != '\0') {
        len++; i++;
    }

    stacktype s;
    init(&s);

    for (i = 0; i < len; i++) {
        ch = infix[i];
        switch (ch) {
            case '+': case '-': case '*': case '/': case '%':
                while (!is_empty(&s) && (prec(ch) <= prec(peek(&s)))) {
                    postfix[j++] = pop(&s);
                }
                push(&s, ch);
                break;
            case '(':
                push(&s, ch);
                break;
            case ')':
                top_op = pop(&s);
                while (top_op != '(') {
                    postfix[j++] = top_op;
                    top_op = pop(&s);
                }
                break;
            case '0': case '1': case '2': case '3': case '4':
            case '5': case '6': case '7': case '8': case '9':
                postfix[j++] = ch;
                break;
            default:
                break;
        }
    }

    while (!is_empty(&s)) {
        postfix[j++] = pop(&s);
    }

    postfix[j] = '\0';

}

int eval(char postfix[])
{
    int op1, op2, value, i = 0;
    int len=0;
    stacktype s;
    char ch;
    while (postfix[i] != '\0') {
        len++; i++;
    }

    init(&s);

    for (i = 0; i < len; i++) {
        ch = postfix[i];

        if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '%') {
            value = ch - '0';
            push(&s, value);
        }
        else {
            op2 = pop(&s);
            op1 = pop(&s);

            switch (ch)
            {
            case '+': push(&s, op1 + op2); break;
            case '-': push(&s, op1 - op2); break;
            case '*': push(&s, op1 * op2); break;
            case '/': push(&s, op1 / op2);  break;
            case '%': push(&s, op1 % op2); break;
            default:
                break;
            }
        }
    }


    return pop(&s);

}

int main() {
    char infix[20], postfix[20];
    puts("수식 입력: ");
    //(5+6)*8+9/(3+5*8)+7
    gets(infix, sizeof(infix));
    infix_to_postfix(infix, postfix);
    printf("postfix : %s \n", postfix);
    printf("result : %d \n", eval(postfix));

    return 0;
}