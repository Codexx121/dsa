 #include<string.h>
      #include<stdio.h>
       #include<stdlib.h>
     void main(){
      char stri[3000];
      FILE *file;
     file=fopen("newprogram.txt","w");
      if(file==NULL)
       {
      printf("Error");
      exit(1);
     }
      printf("Enter text:\n");
      fgets(stri,sizeof(stri),stdin);
      fprintf(file,"%s",stri);
    fclose(file);
     }

