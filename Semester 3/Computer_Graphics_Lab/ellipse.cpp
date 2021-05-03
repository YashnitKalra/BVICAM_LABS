#include<iostream>
#include<graphics.h>
using namespace std;

void putPixels(int xc,int yc, int x, int y){
	putpixel(xc+x,yc+y,GREEN);
	putpixel(xc+x,yc-y,RED);
	putpixel(xc-x,yc+y,BLUE);
	putpixel(xc-x,yc-y,BROWN);
}

int main(){
    int rx, ry;
    cout<<"Enter rx: "; cin>>rx;
    cout<<"Enter ry: "; cin>>ry;
    float p1 = pow(ry,2) - pow(rx,2)*ry + 1/4*pow(rx,2);
    int xc = 200, yc = 200;

    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);

    int x = 0, y = ry;
    
    while(2*pow(rx,2)*y >= 2*pow(ry,2)*x){
        if(p1<0){
            x++;
            p1 += 2*pow(ry,2)*x + pow(ry,2);
        }else{
            x++;
            y--;
            p1 += 2*pow(ry,2)*x - 2*pow(rx,2)*(y) + pow(ry,2);
        }
        putPixels(xc, yc, x, y);
    }

    float p2 = pow(ry,2)*pow(x+1/2,2) + pow(rx,2)*pow(y-1,2) - pow(rx,2)*pow(ry,2);
    while(y>0){
        if(p2>0){
            y--;
            p2 += -2*pow(rx,2)*y + pow(rx,2);
        }else{
            x++; y--;
            p2 += 2*pow(ry,2)*x - 2*pow(rx,2)*y + pow(rx,2);
        }
        putPixels(xc, yc, x, y);
    }

    getch();
    closegraph(); 

    return 0;
}