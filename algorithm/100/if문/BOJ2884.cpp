#include <iostream>
using namespace std;
int main(int argc, char** argv)
{
	int hour,min;
	cin>>hour>>min;
	if(min<=44)
	{
		min+=15;
		hour--;
		if(hour<0)
			hour=23;
	}
	else
		min-=45;
	cout<< hour <<" "<< min;
    return 0;

}