
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
void main(){
char string[3000];
FILE *file;
file=fopen("newprogram.txt","a");
for(int i=0;i<3;i++){
printf("Enter text:\n");
fgets(string,sizeof(string),stdin);
fprintf(file,"%s",string);
}
fclose(file);
}


