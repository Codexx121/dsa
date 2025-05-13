#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 10

struct Student {
  char id[15];
  char name[30];
  char date[15];
  float cgpa;
};

struct Stack {
  struct Student stack[MAX_SIZE];
  int cursor;
};

struct Stack new_stack() {
  struct Stack stack;
  stack.cursor = -1;
  return stack;
}

void push(struct Stack *stack, struct Student student) {
  if (stack->cursor >= MAX_SIZE - 1) {
    printf("Stack Overflow\n");
    return;
  }

  stack->stack[++stack->cursor] = student;
}

struct Student pop(struct Stack *stack) {
  if (stack->cursor <= -1) {
    printf("Stack Underflow");
    struct Student null_student;
    return null_student;
  }

  return stack->stack[stack->cursor--];
}

void print_student(struct Student student) {
  printf("%s\t%s\t%s\t%.2f\n", student.id, student.name, student.date,
         student.cgpa);
}

void print_stack(struct Stack stack) {
  if (stack.cursor <= -1) {
    printf("There are currently no students\n");
    return;
  }

  printf("ID\t\tName\tDate\t\tCGPA\n");
  printf("=================================================\n");

  while (stack.cursor > -1) {
    print_student(pop(&stack));
  }
}

void store_student(struct Student student, FILE *fptr) {
  fprintf(fptr, "%s\t%s\t%s\t%.2f\n", student.id, student.name, student.date,
          student.cgpa);
}

void store_stack(struct Stack stack, FILE *fptr) {
  if (stack.cursor <= -1) {
    return;
  }

  fprintf(fptr, "ID\t\tName\tDate\t\tCGPA\n");
  fprintf(fptr, "=================================================\n");

  while (stack.cursor > -1) {
    store_student(pop(&stack), fptr);
  }
}

int main() {
  FILE *fptr = fopen("studentin.dat", "r");

  if (fptr == NULL) {
    printf("Failed to open file\n");
    exit(1);
  }

  fseek(fptr, 64, SEEK_CUR);
  struct Stack stack = new_stack();

  while (1) {
    struct Student new_student;

    int result = fscanf(fptr, "%s\t%s\t%s\t%f", new_student.id,
                        new_student.name, new_student.date, &new_student.cgpa);

    if (result == EOF) {
      fclose(fptr);
      break;
    }

    push(&stack, new_student);
  }

  fptr = fopen("studentout.dat", "w");

  if (fptr == NULL) {
    printf("Failed to open file\n");
    exit(1);
  }

  print_stack(stack);
  store_stack(stack, fptr);
}
