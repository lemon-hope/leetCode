bool isPalindrome(int x) {
    /**
    * 1 we reverse the number then we compare the original number with the reverse 
    **/
    long int reverse = 0;
    long int remainder = 0;
    long int number =(long int) x;

    while(number != 0){
        // get the last digit of x
        remainder = number % 10;
        // shift the last digit to the left and add it to reverse
        reverse = (long int)(reverse*10 + remainder);
        //remove the last digit from the number
        number = number/10;
    }
    return (x >=0 && reverse == x)? true:false;

}