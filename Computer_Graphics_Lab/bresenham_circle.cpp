#include<iostream>
#include<graphics.h>
using namespace std;

void putPixels(int xc,int yc, int x, int y){
	putpixel(xc+x,yc+y,GREEN);
	putpixel(xc+x,yc-y,RED);
	putpixel(xc-x,yc+y,BLUE);
	putpixel(xc-x,yc-y,BROWN);
	putpixel(xc+y,yc+x,WHITE);
	putpixel(xc+y,yc-x,CYAN);
	putpixel(xc-y,yc+x,MAGENTA);
	putpixel(xc-y,yc-x,YELLOW);
}

int main(){
    int r;
    cout<<"Enter radius: "; cin>>r;
    float p = 5/4 - r;
    int xc = 200, yc = 200;

    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);

    int x = 0, y = r;
    while(y>x){
        putPixels(xc,yc,x,y);
        if(p<0){
            x++;
            p += 2*x + 1;
        }else{
            x++;
            y--;
            p += 2*x + 1 - 2*y;
        }
    }

    getch();
    closegraph(); 

    return 0;
}