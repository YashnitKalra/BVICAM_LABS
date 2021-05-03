// gd => graphic driver
#include<iostream>
#include<graphics.h>
using namespace std;

int main(){
    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);
    
    setcolor(GREEN);
    rectangle(50,50,100,200);
    floodfill(51,51,WHITE);

    setcolor(BLUE);
    rectangle(65,125,85,200);
    floodfill(66,126,1);

    setcolor(RED);
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

    setcolor(BLUE);
    rectangle(200,87,300,135);
    floodfill(201,88,1);

    getch();
    closegraph(); 
    return 0;
}