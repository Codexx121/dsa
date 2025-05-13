w:#include<stdio.h>
#include<stdlib.h>
void main()
{
FILE *file;
char ch;
int chars,word,line;
file=fopen("newprogram1.txt","r");
chars=word=line=0;
while((ch=fgetc(file))!=EOF)
{
chars++;
if(ch=='\n'||ch=='\0')
line++;
if(ch==' '||ch=='\t'||ch=='\n'||ch=='\0')
word++;
}
printf("Total characters:%d\n",chars);
printf("Total words:%d\n",word);
printf("Total lines:%d\n",line);
fclose(file);
}
