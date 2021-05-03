#include<iostream>
#include<graphics.h>
using namespace std;

int main(){
    int x1,y1,x2,y2;
    cout<<"Enter x1: "; cin>>x1;
    cout<<"Enter y1: "; cin>>y1;
    cout<<"Enter x2: "; cin>>x2;
    cout<<"Enter y2: "; cin>>y2;
    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);

    int dx = x2-x1, dy = y2-y1;
    int x=x1,y=y1;
    int p = 2*dy - dx;
    putpixel(x1,y1,RED);

    for(int x=x1;x<x2;x++){
        if(p<0){
            putpixel(x+1,y,RED);
            p += 2*dy;
        }else{
            putpixel(x+1,y+1,RED);
            y++;
            p += 2*dy - 2*dx;
        }
    }

    getch();
    closegraph(); 

    return 0;
}