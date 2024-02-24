/**
* Approach :
*   We process the string from back to front and using map.
*   for each char in the string verify if it's one of the special cases where to use -
*   If we found a special case, we handle it with the appropriate function and we add the result. 
*
**/
#define TAB_SIZE 7
int getValue(char c);
int specialCaseHandler(char charBefore, char charAfter);

int romanToInt(char* s) {
    size_t len = strlen(s);
    int nb=0;
    for(int i=len-1; i >= 0; i--){
        // verify if is one of the six particular instances 
        if(i>0 && (((s[i] == 'V' || s[i] == 'X') && s[i-1]=='I') ||((s[i] == 'L'|| s[i] == 'C') && s[i-1]=='X')|| ((s[i] == 'D' ||s[i] == 'M') && s[i-1]=='C'))){
            nb +=specialCaseHandler(s[i-1],s[i]);
            i--;
        }else{
            nb +=getValue(s[i]);
        }
        
    }

    return nb;   

}

int specialCaseHandler(char charBefore, char charAfter){
    return (getValue(charAfter) - getValue(charBefore)); 
}

int getValue(char c){
   char roman[TAB_SIZE] = {'I', 'V', 'X', 'L','C','D','M'};
   int value[TAB_SIZE] = {1, 5,10,50,100,500,1000};

   for(int i=0; i < TAB_SIZE; i++){
       if(c == roman[i]){
           return value[i];
       }
   }

    return -1;
}

/********************* SUBMISSION RESULTS ***************************************/
/*
Runtime
3ms
Beats86.63%of users with C
Memory
5.68MB
Beats86.91%of users with C

*/ 

