import java.util.*;
class hashtable{
static final int SIZE=7;
static String[] HTable = new String[SIZE];
static String Gone="Deleted";

static int C_Hash(String St){
    int alphaSum=0,numsum=0,specsum=0;
    for (char ch:St.toCharArray()){
        if(Character.isLetter(ch)){
            alphaSum+=(int) ch;
        }
        else if(Character.isDigit(ch)){
            numsum+=(int)ch;
        }
         else {
        specsum+=(int)ch;
        }
    }
    return (alphaSum + 3 * numsum + 5 * specsum + 7) % SIZE;
}
}


static void insert(String St){
    int hash= C_Hash(St);
    int index;
    int i =0;
    while (i<SIZE){
        index= (hash+i*i)%SIZE;
        if()

    }
}

class real{
    public static void main(String[] args) {
    Scanner inp=new Scanner(System.in);
    System.out.println("Enter your name");
    String Main=inp.nextLine();
    int HashVal= hashtable.calchash(Main);
    System.out.println("Your hash is "+HashVal);
    }
}