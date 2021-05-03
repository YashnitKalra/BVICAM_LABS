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

    float dx = x2-x1, dy = y2-y1;
    float m = dy/dx;
    float x=x1,y=y1;

    if(m<=1){
        for(x=x1;x<=x2;x++){
            putpixel(x,y,RED);
            y+=m;
        }
    }else{
        for(y=y1;y<=y2;y++){
            putpixel(x,y,RED);
            x+=1/m;
        }
    }

    getch();
    closegraph(); 

    return 0;
}