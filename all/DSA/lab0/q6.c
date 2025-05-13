#include<stdio.h>
#include<stdlib.h>
void main()
{
char c;
FILE *file1=fopen("newprogram1.txt","r");
FILE *file2=fopen("newprogram2.txt","r");
FILE *file3=fopen("newprogram3.txt","w");
while((c=fgetc(file1))!=EOF)
fputc(c,file3);
fclose(file3);
FILE *file31=fopen("newprogram3.txt","a");
while((c=fgetc(file2))!=EOF)
fputc(c,file31);
fclose(file1);
fclose(file2);
fclose(file31);
}



