#include <iostream>
using namespace std;
int main(int argc, char** argv)
{
	int a,b;
    scanf("%d %d", &a, &b);
	int b1,b2,b3;
	b1=b/100;
	b2=(b-(b1*100))/10;
	b3=(b-(b1*100)-(b2*10));
	printf("%d\n",a*b3);
	printf("%d\n",a*b2);
	printf("%d\n",a*b1);
	printf("%d\n",a*b);
	
    return 0;

}