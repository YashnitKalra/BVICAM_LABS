// gd => graphic driver
#include<iostream>
#include<vector>
#include<graphics.h>
using namespace std;

int main(){
    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);
    
    setcolor(YELLOW);
    rectangle(50,50,100,200);
    floodfill(51,51,1);

    setcolor(BLUE);
    rectangle(100,50,400,200);
    floodfill(101,51,1);

    setcolor(RED);
    int poly1[] = {50,50,75,10,100,50,50,50};
    drawpoly(4, &poly1[0]);
    floodfill(75,26,1);

    setcolor(GREEN);
    int poly2[] = {75,10,400,10,400,50,100,50,75,10};
    drawpoly(5, &poly2[0]);
    floodfill(100,45,1);

    getch();
    closegraph(); 
    return 0;
}