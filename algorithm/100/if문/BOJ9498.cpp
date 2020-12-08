#include <iostream>
using namespace std;
int main(int argc, char** argv)
{
	int grade;
	cin>>grade;
	if(90<=grade&&grade<=100)
		cout<<"A";
	else if(80<=grade&&grade<=89)
			cout<<"B";
	else if(70<=grade&&grade<=79)
			cout<<"C";
	else if(60<=grade&&grade<=69)
			cout<<"D";
	else
		cout<<"F";
    return 0;

}