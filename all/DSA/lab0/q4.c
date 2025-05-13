#include<stdio.h>
#include<stdlib.h>
void main(){
int c;
FILE *file1, *file2;
file2=fopen("newprogram1.txt","w");
file1=fopen("newprogram.txt","r");
while((c=fgetc(file1))!=EOF)
{
fputc(c,file2);
}
fclose(file1);
fclose(file2);
}








