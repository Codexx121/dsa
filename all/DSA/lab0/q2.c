
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
void main(){
char s[100];
FILE *file;
file=fopen("newprogram.txt","r");
while(fgets(s,sizeof(s),file)!=NULL){
printf("%s",s);}
fclose(file);
}




